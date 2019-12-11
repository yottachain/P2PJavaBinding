package io.yottachain.p2phost.interfaces;

import io.yottachain.p2phost.constants.MsgType;

public interface Callback {
    byte[] onMessage(byte[] data, String pubkey);

    default String type() {
        return MsgType.DEFAULT_MSG;
    }
}

