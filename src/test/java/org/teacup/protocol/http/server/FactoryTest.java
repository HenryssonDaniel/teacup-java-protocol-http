package org.teacup.protocol.http.server;

import static org.assertj.core.api.Assertions.assertThat;

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
    assertThat(Factory.createServer(0, "", 0)).isExactlyInstanceOf(SimpleImpl.class);
  }

  @Test
  void createStreams() {
    assertThat(Factory.createStreams(null, null)).isExactlyInstanceOf(StreamsImpl.class);
  }
}
