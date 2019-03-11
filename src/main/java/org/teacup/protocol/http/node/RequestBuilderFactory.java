package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.CREATE_BUILDER;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Request builder factory.
 *
 * @since 1.0
 */
public enum RequestBuilderFactory {
  ;

  private static final Logger LOGGER = Logger.getLogger(RequestBuilderFactory.class.getName());

  /**
   * Creates a new request builder.
   *
   * @return the request builder
   */
  public static RequestBuilder create() {
    LOGGER.log(Level.FINE, String.format(CREATE_BUILDER, "request"));
    return new RequestBuilderImpl();
  }
}
