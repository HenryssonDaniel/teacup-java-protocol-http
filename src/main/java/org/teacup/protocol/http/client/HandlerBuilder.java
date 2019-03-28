package org.teacup.protocol.http.client;

import io.github.henryssondaniel.teacup.core.Builder;
import java.net.http.HttpResponse.PushPromiseHandler;

/**
 * Handler builder interface.
 *
 * @param <T> the response body type
 * @since 1.0
 */
public interface HandlerBuilder<T> extends Builder<Handler<T>> {
  /**
   * Sets the push promise handler.
   *
   * @param pushPromiseHandler the push promise handler
   */
  HandlerBuilder<T> setPushPromiseHandler(PushPromiseHandler<T> pushPromiseHandler);
}
