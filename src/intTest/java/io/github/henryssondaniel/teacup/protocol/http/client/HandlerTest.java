package io.github.henryssondaniel.teacup.protocol.http.client;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.PushPromiseHandler;
import org.junit.jupiter.api.Test;

class HandlerTest {
  @Test
  void createHandlerBuilder() {
    BodyHandler<String> bodyHandler = new TestBodyHandler();
    PushPromiseHandler<String> pushPromiseHandler = new TestPushPromiseHandler();

    Handler<?> handler =
        Factory.createHandlerBuilder(bodyHandler).setPushPromiseHandler(pushPromiseHandler).build();

    assertThat(handler.getBodyHandler()).isSameAs(bodyHandler);
    assertThat(handler.getPushPromiseHandler()).isSameAs(pushPromiseHandler);
  }
}
