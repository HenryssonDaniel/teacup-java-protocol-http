package org.teacup.protocol.http;

import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.PushPromiseHandler;

class HandlerImpl<T> implements HandlerSetter<T> {
  private final BodyHandler<T> bodyHandler;
  private PushPromiseHandler<T> pushPromiseHandler;

  HandlerImpl(BodyHandler<T> bodyHandler) {
    this.bodyHandler = bodyHandler;
  }

  @Override
  public BodyHandler<T> getBodyHandler() {
    return bodyHandler;
  }

  @Override
  public PushPromiseHandler<T> getPushPromiseHandler() {
    return pushPromiseHandler;
  }

  @Override
  public void setPushPromiseHandler(PushPromiseHandler<T> pushPromiseHandler) {
    this.pushPromiseHandler = pushPromiseHandler;
  }
}
