package io.github.henryssondaniel.teacup.protocol.http.client;

import java.net.http.HttpResponse.PushPromiseHandler;

interface HandlerSetter<T> extends Handler<T> {
  void setPushPromiseHandler(PushPromiseHandler<T> pushPromiseHandler);
}
