package io.yottachain.p2phost.interfaces;

import io.yottachain.p2phost.constants.MsgType;

public interface BPNodeCallback {
    byte[] onMessageFromBPNode(byte[] data, String pubkey);

    default String type() {
        return MsgType.BPNODE_MSG;
    }
}
