package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.CREATE_BUILDER;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Response node builder factory.
 *
 * @since 1.0
 */
public enum ResponseNodeBuilderFactory {
  ;

  private static final Logger LOGGER = Logger.getLogger(ResponseNodeBuilderFactory.class.getName());

  /**
   * Creates a new response node builder.
   *
   * @param <T> the response body type
   * @return the response node builder
   */
  public static <T> ResponseNodeBuilder<T> create() {
    LOGGER.log(Level.FINE, String.format(CREATE_BUILDER, "response"));
    return new ResponseNodeBuilderImpl<>();
  }
}
