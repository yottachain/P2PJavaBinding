package io.yottachain.p2phost.interfaces;

import io.yottachain.p2phost.constants.MsgType;

public interface UserCallback {
    byte[] onMessageFromUser(byte[] data, String pubkey);

    default String type() {
        return MsgType.USER_MSG;
    }
}
