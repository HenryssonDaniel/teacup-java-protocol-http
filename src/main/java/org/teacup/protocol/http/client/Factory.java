package org.teacup.protocol.http.client;

import java.net.http.HttpClient;
import java.net.http.HttpResponse.BodyHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Factory class for {@link Simple}.
 *
 * @since 1.0
 */
public enum Factory {
  ;

  private static final Logger LOGGER = Logger.getLogger(Factory.class.getName());

  /**
   * Create a new handler builder.
   *
   * @param bodyHandler the body handler
   * @param <T> the response body type
   * @return the handler builder
   */
  public static <T> HandlerBuilder<T> createHandlerBuilder(BodyHandler<T> bodyHandler) {
    LOGGER.log(Level.FINE, "Creating a new handler builder");
    return new HandlerBuilderImpl<>(bodyHandler);
  }

  /**
   * Creates a new {@link Simple}.
   *
   * @param httpClient the HTTP client
   * @return the simple
   */
  public static Simple createSimple(HttpClient httpClient) {
    LOGGER.log(Level.FINE, "Creating a new client");
    return new SimpleImpl(httpClient);
  }
}
