package org.teacup.protocol.http;

import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.PushPromiseHandler;

/**
 * Response handler interface.
 *
 * @param <T> the response body type
 * @since 1.0
 */
public interface Handler<T> {
  /**
   * Returns the body handler.
   *
   * @return the body handler
   */
  BodyHandler<T> getBodyHandler();

  /**
   * Returns the push promise handler.
   *
   * @return the push promise handler
   */
  PushPromiseHandler<T> getPushPromiseHandler();
}
