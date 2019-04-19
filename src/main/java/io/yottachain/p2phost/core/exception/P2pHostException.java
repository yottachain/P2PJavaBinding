package io.yottachain.p2phost.core.exception;

public class P2pHostException extends Exception {

    public P2pHostException(String msg) {
        super(msg);
    }

    public P2pHostException(String errmsg, Throwable t) {
        super(errmsg, t);
    }
}
