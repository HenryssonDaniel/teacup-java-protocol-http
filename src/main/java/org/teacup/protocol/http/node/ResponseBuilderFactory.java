package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.CREATE_BUILDER;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Response builder factory.
 *
 * @since 1.0
 */
public enum ResponseBuilderFactory {
  ;

  private static final Logger LOGGER = Logger.getLogger(ResponseBuilderFactory.class.getName());

  /**
   * Creates a new response builder.
   *
   * @param <T> the response body type
   * @return the response builder
   */
  public static <T> ResponseBuilder<T> create() {
    LOGGER.log(Level.FINE, String.format(CREATE_BUILDER, "response"));
    return new ResponseBuilderImpl<>();
  }
}
