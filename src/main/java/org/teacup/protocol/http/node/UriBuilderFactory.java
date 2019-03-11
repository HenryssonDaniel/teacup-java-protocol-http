package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.CREATE_BUILDER;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * URI builder factory.
 *
 * @since 1.0
 */
public enum UriBuilderFactory {
  ;

  private static final Logger LOGGER = Logger.getLogger(UriBuilderFactory.class.getName());

  /**
   * Create a new URI builder.
   *
   * @return the URI builder
   */
  public static UriBuilder create() {
    LOGGER.log(Level.FINE, String.format(CREATE_BUILDER, "URI"));
    return new UriBuilderImpl();
  }
}
