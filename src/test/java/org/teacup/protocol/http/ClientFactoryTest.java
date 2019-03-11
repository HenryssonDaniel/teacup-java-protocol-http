package org.teacup.protocol.http;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.net.http.HttpClient;
import org.junit.jupiter.api.Test;

class ClientFactoryTest {
  @Test
  void create() {
    var httpClient = mock(HttpClient.class);
    assertThat(ClientFactory.create(httpClient)).isInstanceOf(ClientImpl.class);
  }
}
