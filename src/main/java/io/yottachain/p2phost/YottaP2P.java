package io.yottachain.p2phost;

import com.ibm.etcd.api.RangeResponse;
import com.ibm.etcd.client.EtcdClient;
import com.ibm.etcd.client.KeyUtils;
import com.ibm.etcd.client.KvStoreClient;
import com.ibm.etcd.client.kv.KvClient;
import io.grpc.netty.shaded.io.netty.util.internal.StringUtil;
import io.yottachain.p2phost.callbackserver.Server;
import io.yottachain.p2phost.core.P2pHost;
import io.yottachain.p2phost.core.exception.P2pHostException;
import io.yottachain.p2phost.core.wrapper.P2pHostWrapper;
import io.yottachain.p2phost.interfaces.*;
import io.yottachain.p2phost.pb.PbClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

public class YottaP2P {
    private static final Logger logger = Logger.getLogger(YottaP2P.class.getName());

    private static final String P2PHOST_ETCD_PREFIX = "/p2phost/";
    private static final String P2PHOST_PORT = P2PHOST_ETCD_PREFIX + "port";
    private static final String P2PHOST_PRIVKEY = P2PHOST_ETCD_PREFIX + "privkey";

    private static Map<String, P2pHostWrapper.P2pHostLib.P2pHostCallback> callbackMap = new HashMap<String, P2pHostWrapper.P2pHostLib.P2pHostCallback>();

    private static P2pHostInterface client;

    private static AtomicBoolean flag = new AtomicBoolean(true);

    public static void start(int port, String privateKey) throws P2pHostException {
        String embededStr = System.getenv("P2PHOST_EMBEDED");
        if (!StringUtil.isNullOrEmpty(embededStr) && embededStr.equals("false")) {
            logger.info("NodeMgmt is under standalone mode");
            String etcdportStr = System.getenv("ETCDPORT");
            int etcdport = 2379;
            try {
                etcdport = Integer.parseInt(etcdportStr);
            } catch (Exception e) {}
            logger.info("ETCD port is " + etcdport);
            String etcdhostname = System.getenv("ETCDHOSTNAME");
            if (StringUtil.isNullOrEmpty(etcdhostname)) {
                etcdhostname = "etcd-svc";
            }
            logger.info("ETCD hostname is " + etcdhostname);
            //1. 注册参数
            KvStoreClient etcdClient = EtcdClient.forEndpoint(etcdhostname, etcdport).withPlainText().build();
            final KvClient kvclient = etcdClient.getKvClient();
            logger.info("Create connection to ETCD: " + etcdhostname + ":" + etcdport);
            new Thread(() -> {
                while (flag.get()) {
                    try {
                        RangeResponse p2pPrivkeyResp = kvclient.get(KeyUtils.bs(P2PHOST_PRIVKEY)).sync();
                        String p2pPrivkeyNew = null;
                        if (p2pPrivkeyResp.getKvsCount()>0) {
                            p2pPrivkeyNew = p2pPrivkeyResp.getKvs(0).getValue().toStringUtf8();
                            logger.info("Read P2P private key from ETCD: " + p2pPrivkeyNew);
                        }
                        if (StringUtil.isNullOrEmpty(p2pPrivkeyNew) || !privateKey.equals(p2pPrivkeyNew)) {
                            kvclient.put(KeyUtils.bs(P2PHOST_PRIVKEY), KeyUtils.bs(privateKey)).sync();
                            logger.info("Write P2P private key to ETCD: " + privateKey);
                        }

                        RangeResponse p2pPortResp = kvclient.get(KeyUtils.bs(P2PHOST_PORT)).sync();
                        String p2pPortNew = null;
                        if (p2pPortResp.getKvsCount()>0) {
                            p2pPortNew = p2pPortResp.getKvs(0).getValue().toStringUtf8();
                            logger.info("Read P2P port from ETCD: " + p2pPortNew);
                        }
                        if (StringUtil.isNullOrEmpty(p2pPortNew) || !Integer.toString(port).equals(p2pPortNew)) {
                            kvclient.put(KeyUtils.bs(P2PHOST_PORT), KeyUtils.bs(Integer.toString(port))).sync();
                            logger.info("Write P2P port to ETCD: " + port);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(60000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    etcdClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {}
            //2. 建立GRPC连接
            String p2phostGRPCPortStr = System.getenv("P2PHOST_GRPCPORT");
            int p2phostGRPCPort = 11002;
            try {
                p2phostGRPCPort = Integer.parseInt(p2phostGRPCPortStr);
            } catch (Exception e) {}
            String p2phostGRPCHostname = System.getenv("P2PHOST_GRPCHOSTNAME");
            if (StringUtil.isNullOrEmpty(p2phostGRPCHostname)) {
                p2phostGRPCHostname = "p2phost-svc";
            }
            client = new PbClient(p2phostGRPCHostname, p2phostGRPCPort);
            logger.info("Create P2PHost GRPC connection: " + p2phostGRPCHostname + ":" + p2phostGRPCPort);
        } else {
            logger.info("NodeMgmt is under embeded mode");
            client = new P2pHost(port, privateKey);
        }
    }

    public static void close() throws P2pHostException {
        client.close();
    }

    public static String id() throws P2pHostException {
        return client.id();
    }

    public static String[] addrs() throws P2pHostException {
        return client.addrs();
    }

    public static void connect(String nodeId, String[] addrs) throws P2pHostException {
        client.connect(nodeId, addrs);
    }

    public static void disconnect(String nodeId) throws P2pHostException {
        client.disconnect(nodeId);
    }

    public static byte[] sendMsg(String nodeId, byte[] msgType, byte[] msg) throws P2pHostException {
        return client.sendMsg(nodeId, msgType, msg);
    }

//    public static byte[] sendToBPUMsg(String nodeId, byte[] msg) throws P2pHostException {
//        return client.sendMsg(nodeId, MsgType.USER_MSG, msg);
//    }
//
//    public static byte[] sendToBPMsg(String nodeId, byte[] msg) throws P2pHostException {
//        return client.sendMsg(nodeId, MsgType.BPNODE_MSG, msg);
//    }
//
//    public static byte[] sendToNodeMsg(String nodeId, byte[] msg) throws P2pHostException {
//        return client.sendMsg(nodeId, MsgType.NODE_MSG, msg);
//    }

    public static void registerCallback(Callback callback) {
        try {
            if (Server.server==null) {
                Server.startCallbackServer();
            }
            Server.registerCallback(callback.type(), new Server.ServerCallback() {
                @Override
                public byte[] onMessage(byte[] data, String pubkey) {
                    return callback.onMessage(data, pubkey);
                }
            });
            client.registerHandler(callback.type(), null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    public static void registerUserCallback(UserCallback userCallback) {
////        try {
////            P2pHostWrapper.P2pHostLib.P2pHostCallback cb = P2pHost.createCallbackWrapper(new MsgCallback() {
////                @Override
////                public byte[] onMessage(String msgType, byte[] msg, String publicKey) {
////                    return userCallback.onMessageFromUser(msg, publicKey);
////                }
////            });
////            callbackMap.put(userCallback.type(), cb);
////            P2pHost.registerHandler(userCallback.type(), cb);
////            //Native.setCallbackThreadInitializer(cb, new CallbackThreadInitializer(true, false, "JNA-Callback-Thread-" + userCallback.type()));
////        } catch (P2pHostException e) {
////            throw new RuntimeException(e);
////        }
//        try {
//            if (Server.server==null) {
//                Server.startCallbackServer();
//            }
//            Server.registerCallback(userCallback.type(), new Server.ServerCallback() {
//                @Override
//                public byte[] onMessage(byte[] data, String pubkey) {
//                    return userCallback.onMessageFromUser(data, pubkey);
//                }
//            });
//            client.registerHandler(userCallback.type(), null);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static void registerBPNodeCallback(BPNodeCallback bpNodeCallback) {
////        try {
////            P2pHostWrapper.P2pHostLib.P2pHostCallback cb = P2pHost.createCallbackWrapper(new MsgCallback() {
////                @Override
////                public byte[] onMessage(String msgType, byte[] msg, String publicKey) {
////                    return bpNodeCallback.onMessageFromBPNode(msg, publicKey);
////                }
////            });
////            callbackMap.put(bpNodeCallback.type(), cb);
////            P2pHost.registerHandler(bpNodeCallback.type(), cb);
////            //Native.setCallbackThreadInitializer(cb, new CallbackThreadInitializer(true, false, "JNA-Callback-Thread-" + bpNodeCallback.type()));
////        } catch (P2pHostException e) {
////            throw new RuntimeException(e);
////        }
//        try {
//            if (Server.server==null) {
//                Server.startCallbackServer();
//            }
//            Server.registerCallback(bpNodeCallback.type(), new Server.ServerCallback() {
//                @Override
//                public byte[] onMessage(byte[] data, String pubkey) {
//                    return bpNodeCallback.onMessageFromBPNode(data, pubkey);
//                }
//            });
//            client.registerHandler(bpNodeCallback.type(), null);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static void registerNodeCallback(NodeCallback nodeCallback) {
////        try {
////            P2pHostWrapper.P2pHostLib.P2pHostCallback cb = P2pHost.createCallbackWrapper(new MsgCallback() {
////                @Override
////                public byte[] onMessage(String msgType, byte[] msg, String publicKey) {
////                    return nodeCallback.onMessageFromNode(msg, publicKey);
////                }
////            });
////            callbackMap.put(nodeCallback.type(), cb);
////            P2pHost.registerHandler(nodeCallback.type(), cb);
////            //Native.setCallbackThreadInitializer(cb, new CallbackThreadInitializer(true, false, "JNA-Callback-Thread-" + nodeCallback.type()));
////        } catch (P2pHostException e) {
////            throw new RuntimeException(e);
////        }
//        try {
//            if (Server.server==null) {
//                Server.startCallbackServer();
//            }
//            Server.registerCallback(nodeCallback.type(), new Server.ServerCallback() {
//                @Override
//                public byte[] onMessage(byte[] data, String pubkey) {
//                    return nodeCallback.onMessageFromNode(data, pubkey);
//                }
//            });
//            client.registerHandler(nodeCallback.type(), null);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static void main1(String[] args) throws Exception {
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
        YottaP2P.registerCallback(new Callback() {
            @Override
            public byte[] onMessage(byte[] data, String pubkey) {
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

    public static void main(String[] args) throws Exception {
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
        String[] serverAddrs = {"/ip4/10.0.1.137/tcp/8888"};
        //连接对端节点，16Uiu2HAm44FX3YuzGXJgHMqnyMM5zCzeT6PUoBNZkz66LutfRREM为对端ID，来自id方法调用，serverAddrs为对端监听地址列表
        YottaP2P.connect("16Uiu2HAm44FX3YuzGXJgHMqnyMM5zCzeT6PUoBNZkz66LutfRREM", serverAddrs);
//        YottaP2P.disconnect("16Uiu2HAm44FX3YuzGXJgHMqnyMM5zCzeT6PUoBNZkz66LutfRREM");
//        String[] serverAddrs2 = {"/ip4/129.28.188.167/tcp/9999"};
//        YottaP2P.connect("16Uiu2HAm3Rea9AGSJYZLgU3ZqdzNoZfb5UUmYF8SAN7FH97HNauq", serverAddrs2);
        //向对端发送用户端消息并获取响应消息，16Uiu2HAm44FX3YuzGXJgHMqnyMM5zCzeT6PUoBNZkz66LutfRREM为对端ID
        for (int i=0; i<1; i++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i=0; i<10; i++) {
                            byte[] ret = YottaP2P.sendMsg("16Uiu2HAm44FX3YuzGXJgHMqnyMM5zCzeT6PUoBNZkz66LutfRREM", new byte[0], ("hello a" + i).getBytes());
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
