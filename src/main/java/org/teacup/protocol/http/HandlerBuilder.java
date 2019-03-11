package org.teacup.protocol.http;

import java.net.http.HttpResponse.PushPromiseHandler;

/**
 * Handler builder interface.
 *
 * @param <T> the response body type
 * @since 1.0
 */
public interface HandlerBuilder<T> {
  /**
   * Build.
   *
   * @return the handler
   */
  Handler<T> build();

  /**
   * Sets the push promise handler.
   *
   * @param pushPromiseHandler the push promise handler
   */
  HandlerBuilder<T> setPushPromiseHandler(PushPromiseHandler<T> pushPromiseHandler);
}
