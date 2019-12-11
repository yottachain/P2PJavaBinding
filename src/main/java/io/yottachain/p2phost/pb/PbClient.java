package io.yottachain.p2phost.pb;

import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.yottachain.p2phost.core.exception.P2pHostException;
import io.yottachain.p2phost.core.wrapper.P2pHostWrapper;
import io.yottachain.p2phost.interfaces.P2pHostInterface;

import java.util.ArrayList;
import java.util.List;

public class PbClient implements P2pHostInterface {

    private final ManagedChannel channel;
    private final P2PHostGrpc.P2PHostBlockingStub blockingStub;

    public PbClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        this.blockingStub = P2PHostGrpc.newBlockingStub(channel);
    }
    @Override
    public void close() throws P2pHostException {
        try {
            blockingStub.close(Empty.newBuilder().build());
        } catch (StatusRuntimeException e) {
            throw new P2pHostException("", e);
        }
    }

    @Override
    public String id() throws P2pHostException {
        try {
            StringMsg resp = blockingStub.iD(Empty.newBuilder().build());
            return resp.getValue();
        } catch (StatusRuntimeException e) {
            throw new P2pHostException("", e);
        }
    }

    @Override
    public String[] addrs() throws P2pHostException {
        try {
            StringListMsg resp = blockingStub.addrs(Empty.newBuilder().build());
            return resp.getValuesList().toArray(new String[0]);
        } catch (StatusRuntimeException e) {
            throw new P2pHostException("", e);
        }
    }

    @Override
    public void connect(String nodeId, String[] addrs) throws P2pHostException {
        try {
            List<String> addrList = new ArrayList<>();
            for (String s : addrs) {
                addrList.add(s);
            }
            ConnectReq req = ConnectReq.newBuilder()
                    .setId(nodeId)
                    .addAllAddrs(addrList)
                    .build();
            blockingStub.connect(req);
        } catch (StatusRuntimeException e) {
            throw new P2pHostException("", e);
        }
    }

    @Override
    public void disconnect(String nodeId) throws P2pHostException {
        try {
            StringMsg req = StringMsg.newBuilder().setValue(nodeId).build();
            blockingStub.disConnect(req);
        } catch (StatusRuntimeException e) {
            throw new P2pHostException("", e);
        }
    }

    @Override
    public byte[] sendMsg(String nodeId, byte[] msgType, byte[] msg) throws P2pHostException {
        try {
            SendMsgReq req = SendMsgReq.newBuilder()
                    .setId(nodeId)
                    .setMsgType(ByteString.copyFrom(msgType))
                    .setMsg(ByteString.copyFrom(msg))
                    .build();
            SendMsgResp resp = blockingStub.sendMsg(req);
            return resp.getValue().toByteArray();
        } catch (StatusRuntimeException e) {
            throw new P2pHostException("", e);
        }
    }

    @Override
    public void registerHandler(String msgType, P2pHostWrapper.P2pHostLib.P2pHostCallback callback) throws P2pHostException {
//        try {
//            blockingStub.registerHandler(StringMsg.newBuilder().setValue(msgType).build());
//        } catch (StatusRuntimeException e) {
//            throw new P2pHostException("", e);
//        }
    }

    @Override
    public void unregisterHandler(String msgType) throws P2pHostException {
        try {
            blockingStub.unregisterHandler(StringMsg.newBuilder().setValue(msgType).build());
        } catch (StatusRuntimeException e) {
            throw new P2pHostException("", e);
        }
    }
}
