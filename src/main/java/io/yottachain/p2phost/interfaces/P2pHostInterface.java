package io.yottachain.p2phost.interfaces;

import io.yottachain.p2phost.core.exception.P2pHostException;
import io.yottachain.p2phost.core.wrapper.P2pHostWrapper;

public interface P2pHostInterface {
    void close() throws P2pHostException;
    String id() throws P2pHostException;
    String[] addrs() throws P2pHostException;
    void connect(String nodeId, String[] addrs) throws P2pHostException;
    void disconnect(String nodeId) throws P2pHostException;
    byte[] sendMsg(String nodeId, byte[] msgType, byte[] msg) throws P2pHostException;
    void registerHandler(String msgType, P2pHostWrapper.P2pHostLib.P2pHostCallback callback) throws P2pHostException;
    void unregisterHandler(String msgType) throws P2pHostException;
}
