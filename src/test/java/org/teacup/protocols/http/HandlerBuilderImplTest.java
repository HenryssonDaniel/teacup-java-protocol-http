package org.teacup.protocols.http;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.PushPromiseHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class HandlerBuilderImplTest {
  @Mock private BodyHandler<String> bodyHandler;
  private HandlerBuilder<String> handlerBuilder;
  @Mock private PushPromiseHandler<String> pushPromiseHandler;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
    handlerBuilder = new HandlerBuilderImpl<>(bodyHandler);
  }

  @Test
  void build() {
    var handler = handlerBuilder.build();
    assertThat(handler.getBodyHandler()).isSameAs(bodyHandler);
    assertThat(handler.getPushPromiseHandler()).isNull();
  }

  @Test
  void buildWithPushPromiseHandler() {
    handlerBuilder.setPushPromiseHandler(pushPromiseHandler);
    var handler = handlerBuilder.build();

    assertThat(handler.getBodyHandler()).isSameAs(bodyHandler);
    assertThat(handler.getPushPromiseHandler()).isSameAs(pushPromiseHandler);
  }
}
