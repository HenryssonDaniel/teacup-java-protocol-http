package org.teacup.protocol.http.client;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.http.HttpResponse.BodyHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class HandlerBuilderFactoryTest {
  @Mock private BodyHandler<String> bodyHandler;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void create() {
    assertThat(HandlerBuilderFactory.create(bodyHandler)).isInstanceOf(HandlerBuilderImpl.class);
  }
}
