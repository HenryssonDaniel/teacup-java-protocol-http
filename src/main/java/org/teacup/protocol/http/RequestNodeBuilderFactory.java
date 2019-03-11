package org.teacup.protocol.http;

import static org.teacup.protocol.http.Constants.CREATE_BUILDER;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Request node builder factory.
 *
 * @since 1.0
 */
public enum RequestNodeBuilderFactory {
  ;

  private static final Logger LOGGER = Logger.getLogger(RequestNodeBuilderFactory.class.getName());

  /**
   * Creates a new request node builder.
   *
   * @return the request node builder
   */
  public static RequestNodeBuilder create() {
    LOGGER.log(Level.FINE, String.format(CREATE_BUILDER, "request"));
    return new RequestNodeBuilderImpl();
  }
}
