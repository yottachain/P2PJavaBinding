package io.yottachain.p2phost.callbackserver;

import io.jafka.jeos.util.Base58;
import io.jafka.jeos.util.ecc.Hex;
import io.undertow.Undertow;
import io.undertow.UndertowOptions;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.handlers.form.FormData;
import io.undertow.server.handlers.form.FormDataParser;
import io.undertow.server.handlers.form.FormParserFactory;
import io.undertow.util.Headers;
import io.yottachain.p2phost.core.exception.P2pHostException;

import java.util.HashMap;
import java.util.Map;

public class Server {

    public interface ServerCallback {
        byte[] onMessage(byte[] data, String pubkey);
    }

    public static Undertow server;
    private static Map<String, ServerCallback> callbackMap = new HashMap<String, ServerCallback>();

    public static void startCallbackServer() throws P2pHostException {
        String portStr = System.getenv("P2PHOST_CALLBACKPORT");
        int port = 18999;
        try {
            port = Integer.parseInt(portStr);
        } catch (Exception e) {}
        String ioThreadsStr = System.getenv("P2PHOST_UNDERTOW_IOTHREADS");
        int iothreads = Math.max(Runtime.getRuntime().availableProcessors(), 2);
        try {
            iothreads = Integer.parseInt(ioThreadsStr);
        } catch (Exception e) {}
        String workerThreadsStr = System.getenv("P2PHOST_UNDERTOW_WORKERTHREADS");
        int workerThreads = iothreads * 10;
        try {
            workerThreads = Integer.parseInt(workerThreadsStr);
        } catch (Exception e) {}
        if (server!=null)
            throw new P2pHostException("Callback server is started.");
        server = Undertow.builder()
                .setIoThreads(iothreads)
                .setWorkerThreads(workerThreads)
                .setServerOption(UndertowOptions.ENABLE_HTTP2, true)
                .setServerOption(UndertowOptions.HTTP2_SETTINGS_MAX_CONCURRENT_STREAMS, 10)
                .setServerOption(UndertowOptions.HTTP2_SETTINGS_HEADER_TABLE_SIZE, 8192)
                .setServerOption(UndertowOptions.HTTP2_SETTINGS_ENABLE_PUSH, true)
                .setServerOption(UndertowOptions.HTTP2_SETTINGS_INITIAL_WINDOW_SIZE, 65535)
                .setServerOption(UndertowOptions.HTTP2_SETTINGS_MAX_FRAME_SIZE, 16384)
                .addHttpListener(port, "127.0.0.1")
                .setHandler(new HttpHandler() {
                    public void handleRequest(final HttpServerExchange exchange) throws Exception {
                        if (exchange.isInIoThread()) {
                            exchange.dispatch(this);
                            return;
                        }
                        final FormDataParser parser = FormParserFactory.builder().build().createParser(exchange);
                        try {
                            FormData parameters = parser.parseBlocking();
                            FormData.FormValue typeForm = parameters.getFirst("type");
                            if (typeForm==null) {
                                exchange.setStatusCode(500);
                                exchange.getResponseSender().send("type can not be null");
                                return;
                            }
                            String type = typeForm.getValue();
                            FormData.FormValue dataForm = parameters.getFirst("data");
                            if (dataForm==null) {
                                exchange.setStatusCode(500);
                                exchange.getResponseSender().send("data can not be null");
                                return;
                            }
                            byte[] data = Hex.toBytes(dataForm.getValue());
                            FormData.FormValue pubkeyForm = parameters.getFirst("pubkey");
                            if (pubkeyForm==null) {
                                exchange.setStatusCode(500);
                                exchange.getResponseSender().send("pubkey can not be null");
                                return;
                            }
                            String pubkey = pubkeyForm.getValue();
//                            byte[] bytes = Base58.decode(pubkey);
//                            byte[] csum = Ripemd160.from(bytes).bytes();
//                            byte[] c = new byte[bytes.length+4];
//                            System.arraycopy(bytes, 0, c, 0, bytes.length);
//                            System.arraycopy(csum, 0, c, bytes.length, 4);
//                            pubkey = Base58.encode(c);
                            ServerCallback cb = callbackMap.get(type);
                            if (cb==null) {
                                exchange.setStatusCode(500);
                                exchange.getResponseSender().send("No callback function for type " + type);
                                return;
                            }
                            byte[] retVal = cb.onMessage(data, pubkey);
                            exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                            exchange.getResponseSender().send(Hex.toHex(retVal));
                        } catch (Exception e) {
                            exchange.setStatusCode(500);
                            exchange.getResponseSender().send(e.getMessage());
                            return;
                        }
                    }
                }).build();
        server.start();
    }

    public static void stopCallbackServer() throws P2pHostException {
        if (server!=null) {
            server.stop();
        }
    }
    public static void registerCallback(String type, ServerCallback callback) {
        callbackMap.put(type, callback);
    }
}
