package org.teacup.protocol.http.client;

import java.net.http.HttpResponse.PushPromiseHandler;
import org.teacup.core.Builder;

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
