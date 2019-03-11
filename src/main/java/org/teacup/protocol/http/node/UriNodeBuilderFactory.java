package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.CREATE_BUILDER;

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
