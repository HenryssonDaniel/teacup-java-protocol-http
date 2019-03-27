package org.teacup.protocol.http.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.net.http.HttpClient;
import java.net.http.HttpResponse.BodyHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class FactoryTest {
  @Mock private BodyHandler<String> bodyHandler;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createHandlerBuilder() {
    assertThat(Factory.createHandlerBuilder(bodyHandler)).isInstanceOf(HandlerBuilderImpl.class);
  }

  @Test
  void createSimple() {
    var httpClient = mock(HttpClient.class);
    assertThat(Factory.createSimple(httpClient)).isInstanceOf(SimpleImpl.class);
  }
}
