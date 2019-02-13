package org.teacup.protocols.http;

import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.PushPromiseHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

class HandlerBuilderImpl<T> implements HandlerBuilder<T> {
  private static final Logger LOGGER = Logger.getLogger(HandlerBuilderImpl.class.getName());
  private final BodyHandler<T> bodyHandler;
  private PushPromiseHandler<T> promiseHandler;

  HandlerBuilderImpl(BodyHandler<T> bodyHandler) {
    this.bodyHandler = bodyHandler;
  }

  @Override
  public Handler<T> build() {
    LOGGER.log(Level.FINE, "Building the handler");
    return new HandlerImpl<>(bodyHandler, promiseHandler);
  }

  @Override
  public HandlerBuilder<T> setPushPromiseHandler(PushPromiseHandler<T> pushPromiseHandler) {
    LOGGER.log(Level.FINE, "Setting the push promise handler");
    promiseHandler = pushPromiseHandler;
    return this;
  }
}
