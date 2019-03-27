package org.teacup.protocol.http;

import java.net.http.HttpClient;
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
   * Creates a new {@link Simple}.
   *
   * @param httpClient the HTTP client
   * @return the simple
   */
  public static Simple create(HttpClient httpClient) {
    LOGGER.log(Level.FINE, "Creating a new client");
    return new SimpleImpl(httpClient);
  }
}
