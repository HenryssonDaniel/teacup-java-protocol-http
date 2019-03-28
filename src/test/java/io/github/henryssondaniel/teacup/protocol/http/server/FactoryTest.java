package io.github.henryssondaniel.teacup.protocol.http.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import com.sun.net.httpserver.HttpServer;
import org.junit.jupiter.api.Test;

class FactoryTest {
  @Test
  void createContextBuilder() {
    assertThat(Factory.createContextBuilder(null, null))
        .isExactlyInstanceOf(ContextBuilderImpl.class);
  }

  @Test
  void createResponseBuilder() {
    assertThat(Factory.createResponseBuilder(0, 0L)).isExactlyInstanceOf(ResponseBuilderImpl.class);
  }

  @Test
  void createServer() {
    var httpServer = mock(HttpServer.class);
    assertThat(Factory.createServer(httpServer)).isExactlyInstanceOf(SimpleImpl.class);
  }

  @Test
  void createStreams() {
    assertThat(Factory.createStreams(null, null)).isExactlyInstanceOf(StreamsImpl.class);
  }
}
