package io.yottachain.p2phost.core;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import io.jafka.jeos.util.Base58;
import io.yottachain.p2phost.core.exception.P2pHostException;
import io.yottachain.p2phost.core.interfaces.MsgCallback;
import io.yottachain.p2phost.core.wrapper.P2pHostWrapper;
import io.yottachain.p2phost.interfaces.P2pHostInterface;
import io.yottachain.p2phost.utils.Ripemd160;

public class P2pHost implements P2pHostInterface {

    public P2pHost(int port, String privateKey) throws P2pHostException {
        Pointer errPtr = P2pHostWrapper.P2pHostLib.INSTANCE.StartWrp(port, privateKey);
        if (errPtr != null) {
            String err = errPtr.getString(0);
            P2pHostWrapper.P2pHostLib.INSTANCE.FreeString(errPtr);
            throw new P2pHostException(err);
        }
    }

    public void close() throws P2pHostException {
        Pointer errPtr = P2pHostWrapper.P2pHostLib.INSTANCE.CloseWrp();
        if (errPtr != null) {
            String err = errPtr.getString(0);
            P2pHostWrapper.P2pHostLib.INSTANCE.FreeString(errPtr);
            throw new P2pHostException(err);
        }
    }

    public String id() throws P2pHostException {
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

    public String[] addrs() throws P2pHostException {
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

    public void connect(String nodeId, String[] addrs) throws P2pHostException {
        Pointer paddrs = new StringArray(addrs);
        Pointer errPtr = P2pHostWrapper.P2pHostLib.INSTANCE.ConnectWrp(nodeId, paddrs, addrs.length);
        if (errPtr != null) {
            String err = errPtr.getString(0);
            P2pHostWrapper.P2pHostLib.INSTANCE.FreeString(errPtr);
            throw new P2pHostException(err);
        }
    }

    public void disconnect(String nodeId) throws P2pHostException {
        Pointer errPtr = P2pHostWrapper.P2pHostLib.INSTANCE.DisconnectWrp(nodeId);
        if (errPtr != null) {
            String err = errPtr.getString(0);
            P2pHostWrapper.P2pHostLib.INSTANCE.FreeString(errPtr);
            throw new P2pHostException(err);
        }
    }

    public byte[] sendMsg(String nodeId, int msgType, byte[] msg) throws P2pHostException {
        Pointer msgPtr = null;
        if (msg!=null && msg.length!=0) {
            msgPtr = new Memory(Native.getNativeSize(Byte.TYPE) * msg.length);
            for (int i = 0; i < msg.length; i++) {
                msgPtr.setByte(i, msg[i]);
            }
        }
        Pointer sendMsgRetPtr = P2pHostWrapper.P2pHostLib.INSTANCE.SendMsgWrp(nodeId, msgType, msgPtr, msg.length);
        Native.free(Pointer.nativeValue(msgPtr));
        Pointer.nativeValue(msgPtr, 0); //avoid duplicate free when garbage collecting
        if (sendMsgRetPtr != null) {
            try {
                P2pHostWrapper.SendMsgRet sendMsgRet = new P2pHostWrapper.SendMsgRet(sendMsgRetPtr);
                if (sendMsgRet.error != null) {
                    String err = sendMsgRet.error.getString(0);
                    throw new P2pHostException(err);
                }
                byte[] msgRet = sendMsgRet.msg.getByteArray(0, (int)sendMsgRet.size);
                return msgRet;
            } finally {
                P2pHostWrapper.P2pHostLib.INSTANCE.FreeSendMsgRet(sendMsgRetPtr);
            }
        } else {
            throw new P2pHostException("SendMsgRet is null");
        }
    }

    public void registerHandler(String msgType, P2pHostWrapper.P2pHostLib.P2pHostCallback callback) throws P2pHostException {
        Pointer errPtr = P2pHostWrapper.P2pHostLib.INSTANCE.RegisterHandlerWrp(msgType, callback);
        if (errPtr != null) {
            String err = errPtr.getString(0);
            P2pHostWrapper.P2pHostLib.INSTANCE.FreeString(errPtr);
            throw new P2pHostException(err);
        }
    }

    public void unregisterHandler(String msgType) throws P2pHostException {
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
                    byte[] bytes = Base58.decode(publicKey);
                    byte[] csum = Ripemd160.from(bytes).bytes();
                    byte[] c = new byte[bytes.length+4];
                    System.arraycopy(bytes, 0, c, 0, bytes.length);
                    System.arraycopy(csum, 0, c, bytes.length, 4);
                    byte[] msg = data.getByteArray(0, (int) size);
                    byte[] ret = callback.onMessage(msgType, msg, Base58.encode(c));
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

}
