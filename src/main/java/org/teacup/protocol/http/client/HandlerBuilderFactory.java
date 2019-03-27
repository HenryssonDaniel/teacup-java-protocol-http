package org.teacup.protocol.http.client;

import java.net.http.HttpResponse.BodyHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handler builder factory.
 *
 * @since 1.0
 */
public enum HandlerBuilderFactory {
  ;

  private static final Logger LOGGER = Logger.getLogger(HandlerBuilderFactory.class.getName());

  /**
   * Create a new handler builder.
   *
   * @param bodyHandler the body handler
   * @param <T> the response body type
   * @return the handler builder
   */
  public static <T> HandlerBuilder<T> create(BodyHandler<T> bodyHandler) {
    LOGGER.log(Level.FINE, "Creating a new handler builder");
    return new HandlerBuilderImpl<>(bodyHandler);
  }
}
