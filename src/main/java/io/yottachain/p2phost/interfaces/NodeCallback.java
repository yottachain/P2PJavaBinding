package io.yottachain.p2phost.interfaces;

import io.yottachain.p2phost.constants.MsgType;

public interface NodeCallback {
    byte[] onMessageFromNode(byte[] data, String pubkey);

    default String type() {
        return MsgType.NODE_MSG;
    }
}
