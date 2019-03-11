package org.teacup.protocol.http;

import static org.teacup.protocol.http.Constants.CREATE_BUILDER;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Body publisher node builder factory.
 *
 * @since 1.0
 */
public enum BodyPublisherNodeBuilderFactory {
  ;

  private static final Logger LOGGER =
      Logger.getLogger(BodyPublisherNodeBuilderFactory.class.getName());

  /**
   * Creates a new body publisher node builder.
   *
   * @return the body publisher node builder
   */
  public static BodyPublisherNodeBuilder create() {
    LOGGER.log(Level.FINE, String.format(CREATE_BUILDER, "body publisher"));
    return new BodyPublisherNodeBuilderImpl();
  }
}
