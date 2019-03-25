package org.teacup.protocol.http;

import java.net.http.HttpResponse.PushPromiseHandler;

interface HandlerSetter<T> extends Handler<T> {
  void setPushPromiseHandler(PushPromiseHandler<T> pushPromiseHandler);
}
