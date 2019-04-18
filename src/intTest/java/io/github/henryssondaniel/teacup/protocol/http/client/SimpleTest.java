package io.github.henryssondaniel.teacup.protocol.http.client;

import static org.assertj.core.api.Assertions.assertThat;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleTest {
  private static final int CODE = 200;
  private static final int PORT = 1234;

  private final HandlerBuilder<String> handlerBuilder =
      Factory.createHandlerBuilder(new TestBodyHandler());
  private final HttpRequest httpRequest =
      HttpRequest.newBuilder(URI.create("http://localhost:1234/test")).build();
  private final Simple simple = Factory.createSimple(HttpClient.newHttpClient());

  private io.github.henryssondaniel.teacup.protocol.http.server.Simple server;

  @AfterEach
  void afterEach() {
    server.tearDown();
  }

  @BeforeEach
  void beforeEach() throws IOException {
    server =
        (io.github.henryssondaniel.teacup.protocol.http.server.Simple)
            io.github.henryssondaniel.teacup.protocol.http.server.Factory.createServer(
                HttpServer.create(new InetSocketAddress("localhost", PORT), 0));
    server.setUp();
    server.setContext(
        io.github.henryssondaniel.teacup.protocol.http.server.Factory.createContextBuilder(
                "/",
                io.github.henryssondaniel.teacup.protocol.http.server.Factory.createResponseBuilder(
                        CODE, 0L)
                    .build())
            .build());
  }

  @Test
  void send() throws IOException, InterruptedException {
    assertThat(simple.send(handlerBuilder.build(), httpRequest).statusCode()).isEqualTo(CODE);
  }

  @Test
  void sendAsynchronously() throws ExecutionException, InterruptedException {
    assertThat(simple.sendAsynchronously(handlerBuilder.build(), httpRequest).get().statusCode())
        .isEqualTo(CODE);
  }

  @Test
  void sendAsynchronouslyWithPushPromiseHandler() throws ExecutionException, InterruptedException {
    assertThat(
            simple
                .sendAsynchronously(
                    handlerBuilder.setPushPromiseHandler(new TestPushPromiseHandler()).build(),
                    httpRequest)
                .get()
                .statusCode())
        .isEqualTo(CODE);
  }
}
