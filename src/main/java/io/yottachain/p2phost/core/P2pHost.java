package io.yottachain.p2phost.core;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import io.yottachain.p2phost.core.exception.P2pHostException;
import io.yottachain.p2phost.core.interfaces.MsgCallback;
import io.yottachain.p2phost.core.wrapper.P2pHostWrapper;

public class P2pHost {

    public static void start(int port, String privateKey) throws P2pHostException {
        Pointer errPtr = P2pHostWrapper.P2pHostLib.INSTANCE.StartWrp(port, privateKey);
        if (errPtr != null) {
            String err = errPtr.getString(0);
            P2pHostWrapper.P2pHostLib.INSTANCE.FreeString(errPtr);
            throw new P2pHostException(err);
        }
    }

    public static void close() throws P2pHostException {
        Pointer errPtr = P2pHostWrapper.P2pHostLib.INSTANCE.CloseWrp();
        if (errPtr != null) {
            String err = errPtr.getString(0);
            P2pHostWrapper.P2pHostLib.INSTANCE.FreeString(errPtr);
            throw new P2pHostException(err);
        }
    }

    public static String id() throws P2pHostException {
        Pointer idRetPtr = P2pHostWrapper.P2pHostLib.INSTANCE.IDWrp();
        if (idRetPtr != null) {
            try {
                P2pHostWrapper.IDRet idRet = new P2pHostWrapper.IDRet(idRetPtr);
                if (idRet.error != null) {
                    String err = idRet.error.getString(0);
                    throw new P2pHostException(err);
                }
                return idRet.id.getString(0);
            } finally {
                P2pHostWrapper.P2pHostLib.INSTANCE.FreeIDRet(idRetPtr);
            }
        } else {
            throw new P2pHostException("IDRet is null");
        }
    }

    public static String[] addrs() throws P2pHostException {
        Pointer addrsRetPtr = P2pHostWrapper.P2pHostLib.INSTANCE.AddrsWrp();
        if (addrsRetPtr != null) {
            try {
                P2pHostWrapper.AddrsRet addrsRet = new P2pHostWrapper.AddrsRet(addrsRetPtr);
                if (addrsRet.error != null) {
                    String err = addrsRet.error.getString(0);
                    throw new P2pHostException(err);
                }
                String[] addrs = addrsRet.addrs.getStringArray(0, addrsRet.size);
                return addrs;
            } finally {
                P2pHostWrapper.P2pHostLib.INSTANCE.FreeAddrsRet(addrsRetPtr);
            }
        } else {
            throw new P2pHostException("AddrsRet is null");
        }
    }

    public static void connect(String nodeId, String[] addrs) throws P2pHostException {
        Pointer paddrs = new StringArray(addrs);
        Pointer errPtr = P2pHostWrapper.P2pHostLib.INSTANCE.ConnectWrp(nodeId, paddrs, addrs.length);
        if (errPtr != null) {
            String err = errPtr.getString(0);
            P2pHostWrapper.P2pHostLib.INSTANCE.FreeString(errPtr);
            throw new P2pHostException(err);
        }
    }

    public static void disconnect(String nodeId) throws P2pHostException {
        Pointer errPtr = P2pHostWrapper.P2pHostLib.INSTANCE.DisconnectWrp(nodeId);
        if (errPtr != null) {
            String err = errPtr.getString(0);
            P2pHostWrapper.P2pHostLib.INSTANCE.FreeString(errPtr);
            throw new P2pHostException(err);
        }
    }

    public static byte[] sendMsg(String nodeId, String msgType, byte[] msg) throws P2pHostException {
        Pointer msgPtr = new Memory(Native.getNativeSize(Byte.TYPE) * msg.length);
        for (int i=0; i<msg.length; i++) {
            msgPtr.setByte(i, msg[i]);
        }
        Pointer sendMsgRetPtr = P2pHostWrapper.P2pHostLib.INSTANCE.SendMsgWrp(nodeId, msgType, msgPtr, msg.length);
        Native.free(Pointer.nativeValue(msgPtr));
        Pointer.nativeValue(msgPtr, 0); //avoid duplicate free when garbage collecting
        if (sendMsgRetPtr != null) {
            try {
                P2pHostWrapper.SendMsgRet senMsgRet = new P2pHostWrapper.SendMsgRet(sendMsgRetPtr);
                if (senMsgRet.error != null) {
                    String err = senMsgRet.error.getString(0);
                    throw new P2pHostException(err);
                }
                byte[] msgRet = senMsgRet.msg.getByteArray(0, (int)senMsgRet.size);
                return msgRet;
            } finally {
                P2pHostWrapper.P2pHostLib.INSTANCE.FreeSendMsgRet(sendMsgRetPtr);
            }
        } else {
            throw new P2pHostException("SendMsgRet is null");
        }
    }

    public static void registerHandler(String msgType, P2pHostWrapper.P2pHostLib.P2pHostCallback callback) throws P2pHostException {
        Pointer errPtr = P2pHostWrapper.P2pHostLib.INSTANCE.RegisterHandlerWrp(msgType, callback);
        if (errPtr != null) {
            String err = errPtr.getString(0);
            P2pHostWrapper.P2pHostLib.INSTANCE.FreeString(errPtr);
            throw new P2pHostException(err);
        }
    }

    public static void unregisterHandler(String msgType) throws P2pHostException {
        Pointer errPtr = P2pHostWrapper.P2pHostLib.INSTANCE.UnregisterHandlerWrp(msgType);
        if (errPtr != null) {
            String err = errPtr.getString(0);
            P2pHostWrapper.P2pHostLib.INSTANCE.FreeString(errPtr);
            throw new P2pHostException(err);
        }
    }

    public static P2pHostWrapper.P2pHostLib.P2pHostCallback createCallbackWrapper(MsgCallback callback) {
        return new P2pHostWrapper.P2pHostLib.P2pHostCallback(){
            @Override
            public Pointer invoke(String msgType, Pointer data, long size, String publicKey) {
                Pointer ptr = null;
                try {
                    byte[] msg = data.getByteArray(0, (int) size);
                    byte[] ret = callback.onMessage(msgType, msg, publicKey);
                    ptr = new Memory(ret.length);
                    for (int i = 0; i < ret.length; i++) {
                        ptr.setByte(i, ret[i]);
                    }
                    Pointer retp = P2pHostWrapper.P2pHostLib.INSTANCE.CreateSendMsgRet2(ptr, ret.length, null);
                    return retp;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                } finally {
                    if (ptr != null) {
                        Native.free(Pointer.nativeValue(ptr));
                        Pointer.nativeValue(ptr, 0);
                    }
                }
            }
        };
    }

    public static P2pHostWrapper.P2pHostLib.P2pHostCallback callback;

    public static P2pHostWrapper.P2pHostLib.P2pHostCallback registerUserCallback(final MsgCallback cb) {
        callback = new P2pHostWrapper.P2pHostLib.P2pHostCallback(){

            @Override
            public Pointer invoke(String msgType, Pointer data, long size, String publicKey) {
                byte[] msg = data.getByteArray(0, (int)size);
                byte[] ret = cb.onMessage(msgType, msg, publicKey);
                Pointer ptr = new Memory(ret.length);
                for (int i=0; i<ret.length; i++) {
                    ptr.setByte(i, ret[i]);
                }
                Pointer retp = P2pHostWrapper.P2pHostLib.INSTANCE.CreateSendMsgRet2(ptr, ret.length, null);
                Native.free(Pointer.nativeValue(ptr));
                Pointer.nativeValue(ptr, 0);
                return retp;
            }
        };
        return callback;
    }



    public static void main1() {
        String privkey = "5JdDoNZwSADC3KG7xCh7mCF62fKp86sLf3GUNDY2B8t2UUB9HdJ";
        try {
            P2pHost.start(8888, privkey);
            System.out.println("id: " + P2pHost.id());
            String[] addrs = P2pHost.addrs();
            for (String addr : addrs) {
                System.out.println(addr);
            }
            P2pHost.registerHandler("test", registerUserCallback(new MsgCallback() {
                @Override
                public byte[] onMessage(String msgType, byte[] msg, String publicKey) {
                    System.out.println("PubKey: " + publicKey);
                    System.out.println("Received: " + new String(msg));
                    return ((new String(msg))+": acked").getBytes();
                }
            }));
            Thread.sleep(1000000);
            //P2pHost.close();
        } catch (P2pHostException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main2() {
        String privkey = "5KQKydL7TuRwjzaFSK4ezH9RUXWuYHW1yYDp5CmQfsfTuu9MBLZ";
        try {
            P2pHost.start(9999, privkey);
            System.out.println("id: " + P2pHost.id());
            String[] addrs = P2pHost.addrs();
            for (String addr : addrs) {
                System.out.println(addr);
            }
            P2pHost.connect("16Uiu2HAm44FX3YuzGXJgHMqnyMM5zCzeT6PUoBNZkz66LutfRREM", new String[]{"/ip4/127.0.0.1/tcp/8888"});
            byte[] ret = P2pHost.sendMsg("16Uiu2HAm44FX3YuzGXJgHMqnyMM5zCzeT6PUoBNZkz66LutfRREM", "test", "hello world".getBytes());
            System.out.println("Received: " + new String(ret));
            P2pHost.close();
        } catch (P2pHostException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        main2();
    }

}