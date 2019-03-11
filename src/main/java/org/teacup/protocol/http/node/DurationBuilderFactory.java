package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.CREATE_BUILDER;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Duration builder factory.
 *
 * @since 1.0
 */
public enum DurationBuilderFactory {
  ;

  private static final Logger LOGGER = Logger.getLogger(DurationBuilderFactory.class.getName());

  /**
   * Creates a new duration builder.
   *
   * @return the duration builder
   */
  public static DurationBuilder create() {
    LOGGER.log(Level.FINE, String.format(CREATE_BUILDER, "duration"));
    return new DurationBuilderImpl();
  }
}
