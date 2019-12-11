package io.yottachain.p2phost.core.wrapper;

import com.sun.jna.*;

import java.util.Arrays;
import java.util.List;

public class P2pHostWrapper {

    public static class IDRet extends Structure {
        public Pointer id;
        public Pointer error;

        public IDRet(Pointer ptr) {
            super(ptr);
            read();
        }

        @Override
        protected List getFieldOrder() {
            return Arrays.asList(new String[]{"id", "error"});
        }
    }

    public static class AddrsRet extends Structure {
        public Pointer addrs;
        public int size;
        public Pointer error;

        public AddrsRet(Pointer ptr) {
            super(ptr);
            read();
        }

        @Override
        protected List getFieldOrder() {
            return Arrays.asList(new String[]{"addrs", "size", "error"});
        }
    }

    public static class SendMsgRet extends Structure {
        public Pointer msg;
        public long size;
        public Pointer error;

        public SendMsgRet(Pointer ptr) {
            super(ptr);
            read();
        }

        @Override
        protected List getFieldOrder() {
            return Arrays.asList(new String[]{"msg", "size", "error"});
        }
    }

    public interface P2pHostLib extends Library {
        interface P2pHostCallback extends Callback {
            Pointer invoke(String msgType, Pointer data, long size, String publicKey);
        }

        P2pHostLib INSTANCE = (P2pHostLib)
                Native.load(Platform.isWindows()?"p2phost.dll":"p2phost.so",
                        P2pHostLib.class);

        Pointer StartWrp(int port, String privatekey);
        Pointer CloseWrp();
        Pointer IDWrp();
        Pointer AddrsWrp();
        Pointer ConnectWrp(String nodeId, Pointer addr, int size);
        Pointer DisconnectWrp(String nodeId);
        Pointer SendMsgWrp(String nodeId, Pointer msgType, Pointer msg, long size);
        Pointer RegisterHandlerWrp(String msgType, P2pHostCallback callback);
        Pointer UnregisterHandlerWrp(String msgType);


        void FreeString(Pointer ptr);
        void FreeIDRet(Pointer ptr);
        void FreeAddrsRet(Pointer ptr);
        void FreeSendMsgRet(Pointer ptr);

        Pointer CreateSendMsgRet(Pointer msg, long size, Pointer err);
        Pointer CreateSendMsgRet2(Pointer msg, long size, Pointer err);
    }
}
