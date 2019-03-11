package org.teacup.protocols.http;

import static org.teacup.protocols.http.Constants.CREATE_BUILDER;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * URI node builder factory.
 *
 * @since 1.0
 */
public enum UriNodeBuilderFactory {
  ;

  private static final Logger LOGGER = Logger.getLogger(UriNodeBuilderFactory.class.getName());

  /**
   * Create a new URI node builder.
   *
   * @return the URI node builder
   */
  public static UriNodeBuilder create() {
    LOGGER.log(Level.FINE, String.format(CREATE_BUILDER, "URI"));
    return new UriNodeBuilderImpl();
  }
}
