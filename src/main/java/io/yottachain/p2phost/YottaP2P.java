package io.yottachain.p2phost;

import com.sun.jna.CallbackThreadInitializer;
import com.sun.jna.Native;
import io.yottachain.p2phost.callbackserver.Server;
import io.yottachain.p2phost.constants.MsgType;
import io.yottachain.p2phost.core.P2pHost;
import io.yottachain.p2phost.core.exception.P2pHostException;
import io.yottachain.p2phost.core.interfaces.MsgCallback;
import io.yottachain.p2phost.core.wrapper.P2pHostWrapper;
import io.yottachain.p2phost.interfaces.BPNodeCallback;
import io.yottachain.p2phost.interfaces.NodeCallback;
import io.yottachain.p2phost.interfaces.UserCallback;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class YottaP2P {

    private static Map<String, P2pHostWrapper.P2pHostLib.P2pHostCallback> callbackMap = new HashMap<String, P2pHostWrapper.P2pHostLib.P2pHostCallback>();

    public static void start(int port, String privateKey) throws P2pHostException {
        P2pHost.start(port, privateKey);
    }

    public static void close() throws P2pHostException {
        P2pHost.close();
    }

    public static String id() throws P2pHostException {
        return P2pHost.id();
    }

    public static String[] addrs() throws P2pHostException {
        return P2pHost.addrs();
    }

    public static void connect(String nodeId, String[] addrs) throws P2pHostException {
        P2pHost.connect(nodeId, addrs);
    }

    public static void disconnect(String nodeId) throws P2pHostException {
        P2pHost.disconnect(nodeId);
    }

    public static byte[] sendToBPUMsg(String nodeId, byte[] msg) throws P2pHostException {
        return P2pHost.sendMsg(nodeId, MsgType.USER_MSG, msg);
    }

    public static byte[] sendToBPMsg(String nodeId, byte[] msg) throws P2pHostException {
        return P2pHost.sendMsg(nodeId, MsgType.BPNODE_MSG, msg);
    }

    public static byte[] sendToNodeMsg(String nodeId, byte[] msg) throws P2pHostException {
        return P2pHost.sendMsg(nodeId, MsgType.NODE_MSG, msg);
    }

    public static void registerUserCallback(UserCallback userCallback) {
//        try {
//            P2pHostWrapper.P2pHostLib.P2pHostCallback cb = P2pHost.createCallbackWrapper(new MsgCallback() {
//                @Override
//                public byte[] onMessage(String msgType, byte[] msg, String publicKey) {
//                    return userCallback.onMessageFromUser(msg, publicKey);
//                }
//            });
//            callbackMap.put(userCallback.type(), cb);
//            P2pHost.registerHandler(userCallback.type(), cb);
//            //Native.setCallbackThreadInitializer(cb, new CallbackThreadInitializer(true, false, "JNA-Callback-Thread-" + userCallback.type()));
//        } catch (P2pHostException e) {
//            throw new RuntimeException(e);
//        }
        try {
            if (Server.server==null) {
                Server.startCallbackServer();
            }
            Server.registerCallback(userCallback.type(), new Server.ServerCallback() {
                @Override
                public byte[] onMessage(byte[] data, String pubkey) {
                    return userCallback.onMessageFromUser(data, pubkey);
                }
            });
            P2pHost.registerHandler(userCallback.type(), null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void registerBPNodeCallback(BPNodeCallback bpNodeCallback) {
//        try {
//            P2pHostWrapper.P2pHostLib.P2pHostCallback cb = P2pHost.createCallbackWrapper(new MsgCallback() {
//                @Override
//                public byte[] onMessage(String msgType, byte[] msg, String publicKey) {
//                    return bpNodeCallback.onMessageFromBPNode(msg, publicKey);
//                }
//            });
//            callbackMap.put(bpNodeCallback.type(), cb);
//            P2pHost.registerHandler(bpNodeCallback.type(), cb);
//            //Native.setCallbackThreadInitializer(cb, new CallbackThreadInitializer(true, false, "JNA-Callback-Thread-" + bpNodeCallback.type()));
//        } catch (P2pHostException e) {
//            throw new RuntimeException(e);
//        }
        try {
            if (Server.server==null) {
                Server.startCallbackServer();
            }
            Server.registerCallback(bpNodeCallback.type(), new Server.ServerCallback() {
                @Override
                public byte[] onMessage(byte[] data, String pubkey) {
                    return bpNodeCallback.onMessageFromBPNode(data, pubkey);
                }
            });
            P2pHost.registerHandler(bpNodeCallback.type(), null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void registerNodeCallback(NodeCallback nodeCallback) {
//        try {
//            P2pHostWrapper.P2pHostLib.P2pHostCallback cb = P2pHost.createCallbackWrapper(new MsgCallback() {
//                @Override
//                public byte[] onMessage(String msgType, byte[] msg, String publicKey) {
//                    return nodeCallback.onMessageFromNode(msg, publicKey);
//                }
//            });
//            callbackMap.put(nodeCallback.type(), cb);
//            P2pHost.registerHandler(nodeCallback.type(), cb);
//            //Native.setCallbackThreadInitializer(cb, new CallbackThreadInitializer(true, false, "JNA-Callback-Thread-" + nodeCallback.type()));
//        } catch (P2pHostException e) {
//            throw new RuntimeException(e);
//        }
        try {
            if (Server.server==null) {
                Server.startCallbackServer();
            }
            Server.registerCallback(nodeCallback.type(), new Server.ServerCallback() {
                @Override
                public byte[] onMessage(byte[] data, String pubkey) {
                    return nodeCallback.onMessageFromNode(data, pubkey);
                }
            });
            P2pHost.registerHandler(nodeCallback.type(), null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        //首先必须先启动P2P服务，8888为端口，5JdDoNZwSADC3KG7xCh7mCF62fKp86sLf3GUNDY2B8t2UUB9HdJ为私钥（Base58形式，节点之间须不同）
        YottaP2P.start(8888, "5JdDoNZwSADC3KG7xCh7mCF62fKp86sLf3GUNDY2B8t2UUB9HdJ");
        //打印当前节点ID（由公钥生成，Base58形式）
        System.out.println(YottaP2P.id());
        //打印监听地址列表
        String[] addrs = YottaP2P.addrs();
        for (String str : addrs) {
            System.out.println(str);
        }
        final Random r = new Random();
        //注册客户端回调接口
        YottaP2P.registerUserCallback(new UserCallback() {
            @Override
            public byte[] onMessageFromUser(byte[] data, String pubkey) {
                System.out.println("Received: " + new String(data)); //打印接收的消息
                System.out.println("Publickey: " + pubkey); //打印公钥（Base58形式）
//                try {
//                    Thread.sleep(r.nextInt(100));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                return ((new String(data))+": acked").getBytes();
            }
        });
        //关闭节点
        //YottaP2P.close();

        Thread.sleep(100000000);
    }

    public static void main1(String[] args) throws Exception {
        //首先必须先启动P2P服务，9999为端口，5KQKydL7TuRwjzaFSK4ezH9RUXWuYHW1yYDp5CmQfsfTuu9MBLZ为私钥（Base58形式，节点之间须不同）
        YottaP2P.start(9999, "5KQKydL7TuRwjzaFSK4ezH9RUXWuYHW1yYDp5CmQfsfTuu9MBLZ");
        //打印当前节点ID（由公钥生成，Base58形式）
        System.out.println(YottaP2P.id());
        //打印监听地址列表
        String[] addrs = YottaP2P.addrs();
        for (String str : addrs) {
            System.out.println(str);
        }
        //对端节点地址，来自对端的addrs方法调用
        String[] serverAddrs = {"/ip4/127.0.0.1/tcp/8888"};
        //连接对端节点，16Uiu2HAm44FX3YuzGXJgHMqnyMM5zCzeT6PUoBNZkz66LutfRREM为对端ID，来自id方法调用，serverAddrs为对端监听地址列表
        YottaP2P.connect("16Uiu2HAm44FX3YuzGXJgHMqnyMM5zCzeT6PUoBNZkz66LutfRREM", serverAddrs);
//        YottaP2P.disconnect("16Uiu2HAm44FX3YuzGXJgHMqnyMM5zCzeT6PUoBNZkz66LutfRREM");
//        String[] serverAddrs2 = {"/ip4/129.28.188.167/tcp/9999"};
//        YottaP2P.connect("16Uiu2HAm3Rea9AGSJYZLgU3ZqdzNoZfb5UUmYF8SAN7FH97HNauq", serverAddrs2);
        //向对端发送用户端消息并获取响应消息，16Uiu2HAm44FX3YuzGXJgHMqnyMM5zCzeT6PUoBNZkz66LutfRREM为对端ID
        for (int i=0; i<5000; i++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i=0; i<10; i++) {
                            byte[] ret = YottaP2P.sendToBPUMsg("16Uiu2HAm44FX3YuzGXJgHMqnyMM5zCzeT6PUoBNZkz66LutfRREM", ("hello a" + i).getBytes());
                            System.out.println(new String(ret));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        for (int i=0; i<10000; i++) {
//                            byte[] ret = YottaP2P.sendToBPUMsg("16Uiu2HAm44FX3YuzGXJgHMqnyMM5zCzeT6PUoBNZkz66LutfRREM", ("hello b" + i).getBytes());
//                            System.out.println(new String(ret));
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        for (int i=0; i<10000; i++) {
//                            byte[] ret = YottaP2P.sendToBPUMsg("16Uiu2HAm44FX3YuzGXJgHMqnyMM5zCzeT6PUoBNZkz66LutfRREM", ("hello c" + i).getBytes());
//                            System.out.println(new String(ret));
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        for (int i=0; i<10000; i++) {
//                            byte[] ret = YottaP2P.sendToBPUMsg("16Uiu2HAm44FX3YuzGXJgHMqnyMM5zCzeT6PUoBNZkz66LutfRREM", ("hello d" + i).getBytes());
//                            System.out.println(new String(ret));
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
        }
        //断开与对端的连接
        YottaP2P.disconnect("16Uiu2HAm44FX3YuzGXJgHMqnyMM5zCzeT6PUoBNZkz66LutfRREM");

//        for (int i=0; i<10; i++) {
//            final int ii = i;
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for (int j=0; j<100; j++) {
//                        try {
//                            byte[] ret = YottaP2P.sendToBPUMsg("16Uiu2HAm44FX3YuzGXJgHMqnyMM5zCzeT6PUoBNZkz66LutfRREM", "hello".getBytes());
//                            System.out.println(ii+"/"+j+": "+new String(ret));
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }).start();
//        }
    }
}
