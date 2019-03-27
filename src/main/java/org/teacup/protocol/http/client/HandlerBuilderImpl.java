package org.teacup.protocol.http.client;

import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.PushPromiseHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.teacup.core.DefaultBuilder;

class HandlerBuilderImpl<T> extends DefaultBuilder<Handler<T>, HandlerSetter<T>>
    implements HandlerBuilder<T> {
  private static final Logger LOGGER = Logger.getLogger(HandlerBuilderImpl.class.getName());
  private final BodyHandler<T> bodyHandler;

  HandlerBuilderImpl(BodyHandler<T> bodyHandler) {
    super(new HandlerImpl<>(bodyHandler));

    this.bodyHandler = bodyHandler;
  }

  @Override
  public HandlerBuilder<T> setPushPromiseHandler(PushPromiseHandler<T> pushPromiseHandler) {
    LOGGER.log(Level.FINE, "Setting the push promise handler");
    getImplementation().setPushPromiseHandler(pushPromiseHandler);
    return this;
  }

  @Override
  protected HandlerSetter<T> createImplementation() {
    return new HandlerImpl<>(bodyHandler);
  }
}
