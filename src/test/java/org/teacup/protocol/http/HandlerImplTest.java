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
  private HandlerSetter<String> handlerSetter;
  @Mock private PushPromiseHandler<String> pushPromiseHandler;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
    handlerSetter = new HandlerImpl<>(bodyHandler);
  }

  @Test
  void getBodyHandler() {
    assertThat(handlerSetter.getBodyHandler()).isSameAs(bodyHandler);
  }

  @Test
  void getPushPromiseHandler() {
    assertThat(handlerSetter.getPushPromiseHandler()).isNull();
  }

  @Test
  void setAndGetPushPromiseHandler() {
    handlerSetter.setPushPromiseHandler(pushPromiseHandler);
    assertThat(handlerSetter.getPushPromiseHandler()).isSameAs(pushPromiseHandler);
  }
}
