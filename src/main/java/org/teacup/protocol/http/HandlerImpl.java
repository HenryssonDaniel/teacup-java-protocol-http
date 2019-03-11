package org.teacup.protocol.http;

import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.PushPromiseHandler;

class HandlerImpl<T> implements Handler<T> {
  private final BodyHandler<T> bodyHandler;
  private final PushPromiseHandler<T> pushPromiseHandler;

  HandlerImpl(BodyHandler<T> bodyHandler, PushPromiseHandler<T> pushPromiseHandler) {
    this.bodyHandler = bodyHandler;
    this.pushPromiseHandler = pushPromiseHandler;
  }

  @Override
  public BodyHandler<T> getBodyHandler() {
    return bodyHandler;
  }

  @Override
  public PushPromiseHandler<T> getPushPromiseHandler() {
    return pushPromiseHandler;
  }
}
