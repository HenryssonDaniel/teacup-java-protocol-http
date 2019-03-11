package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.CREATE_BUILDER;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Body publisher builder factory.
 *
 * @since 1.0
 */
public enum BodyPublisherBuilderFactory {
  ;

  private static final Logger LOGGER =
      Logger.getLogger(BodyPublisherBuilderFactory.class.getName());

  /**
   * Creates a new body publisher builder.
   *
   * @return the body publisher builder
   */
  public static BodyPublisherBuilder create() {
    LOGGER.log(Level.FINE, String.format(CREATE_BUILDER, "body publisher"));
    return new BodyPublisherBuilderImpl();
  }
}
