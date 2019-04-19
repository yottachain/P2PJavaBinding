package io.yottachain.p2phost.core.interfaces;

public interface MsgCallback {
    public byte[] onMessage(String msgType, byte[] msg, String publicKey);
}
