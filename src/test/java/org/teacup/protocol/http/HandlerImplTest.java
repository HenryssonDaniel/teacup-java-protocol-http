package org.teacup.protocol.http;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.PushPromiseHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class HandlerImplTest {
  @Mock private BodyHandler<String> bodyHandler;
  private Handler<String> handler;
  @Mock private PushPromiseHandler<String> pushPromiseHandler;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
    handler = new HandlerImpl<>(bodyHandler, pushPromiseHandler);
  }

  @Test
  void getBodyHandler() {
    assertThat(handler.getBodyHandler()).isSameAs(bodyHandler);
  }

  @Test
  void getPushPromiseHandler() {
    assertThat(handler.getPushPromiseHandler()).isSameAs(pushPromiseHandler);
  }
}
