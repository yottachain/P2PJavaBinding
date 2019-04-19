package io.yottachain.p2phost;

import io.yottachain.p2phost.core.exception.P2pHostException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class YottaP2PTest {

    @BeforeClass
    public static void startP2P() throws P2pHostException {
        YottaP2P.start(34692, "5KQKydL7TuRwjzaFSK4ezH9RUXWuYHW1yYDp5CmQfsfTuu9MBLZ");
    }

    @Test
    public void testID() throws P2pHostException {
        String id = YottaP2P.id();
        assertEquals(id, "16Uiu2HAmPkuuzD6VkanLAtPLFpNSD1bdfF1KeZ3ws82g9qUSU84u");
    }



    @AfterClass
    public static void closeP2P() throws P2pHostException {
        YottaP2P.close();
    }
}
