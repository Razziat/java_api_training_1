package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;

public class PingHandler implements HttpHandler {
    private final Server server;

    public PingHandler(Server server){
        this.server = server;
    }

    public void pingContext(HttpServer http) {
        http.createContext("/ping", exchange -> server.response("OK", exchange, 200));
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String body = "OK";
        exchange.sendResponseHeaders(200, body.length());
        try (OutputStream os = exchange.getResponseBody()){
            os.write(body.getBytes());
        }
    }
}
