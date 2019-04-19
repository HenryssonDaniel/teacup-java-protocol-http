package io.github.henryssondaniel.teacup.protocol.http.server;

import static org.assertj.core.api.Assertions.assertThat;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class SimpleTest {
  private static final int CODE = 200;
  private static final int PORT = 2314;

  private final Object lock = new Object();

  private boolean wait = true;

  @Test
  void createSimpleBuilder() throws IOException, InterruptedException {
    var server =
        Factory.createServer(HttpServer.create(new InetSocketAddress("localhost", PORT), 0));
    server.setUp();

    var contextBuilder =
        Factory.createContextBuilder("/", Factory.createResponseBuilder(CODE, 0L).build());

    var context = contextBuilder.build();

    var supplier = server.setContext(context);
    var extraSupplier = server.setContext(context);

    new Thread(() -> setContext(server, contextBuilder)).start();

    HttpClient.newHttpClient()
        .send(
            HttpRequest.newBuilder(URI.create("http://localhost:2314")).build(),
            BodyHandlers.ofString());

    verifyRequest(supplier.get());
    verifyRequest(extraSupplier.get());

    server.removeSupplier(supplier);
    server.removeSupplier(extraSupplier);

    synchronized (lock) {
      while (wait) lock.wait(1L);
    }

    server.tearDown();
  }

  private void setContext(Simple server, ContextBuilder contextBuilder) {
    synchronized (lock) {
      server.setContext(
          contextBuilder.setAttributes(Collections.singletonMap("key", "value")).build());
      wait = false;
      lock.notifyAll();
    }
  }

  private static void verifyRequest(List<? extends Request> requests) {
    assertThat(requests).hasSize(1);

    var request = requests.get(0);
    assertThat(request.getBody()).isEmpty();
    assertThat(request.getHeaders()).isNotEmpty();
    assertThat(request.getHttpContext()).isNotNull();
    assertThat(request.getHttpPrincipal()).isNull();
    assertThat(request.getLocalAddress().getHostString()).isEqualTo("127.0.0.1");
    assertThat(request.getMethod()).isEqualTo("GET");
    assertThat(request.getProtocol()).isEqualTo("HTTP/1.1");
    assertThat(request.getRemoteAddress().getHostString()).isEqualTo("127.0.0.1");
    assertThat(request.getURI()).isEqualTo(URI.create("/"));
  }
}
