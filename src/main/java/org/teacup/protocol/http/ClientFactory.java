package org.teacup.protocol.http;

import java.net.http.HttpClient;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Factory class for {@link Client}.
 *
 * @since 1.0
 */
public enum ClientFactory {
  ;

  private static final Logger LOGGER = Logger.getLogger(ClientFactory.class.getName());

  /**
   * Creates a new {@link Client}.
   *
   * @param httpClient the HTTP client
   * @return the client
   */
  public static Client create(HttpClient httpClient) {
    LOGGER.log(Level.FINE, "Creating a new client");
    return new ClientImpl(httpClient);
  }
}
