package org.teacup.protocols.http;

import static org.teacup.protocols.http.Constants.CREATE_BUILDER;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Duration node builder factory.
 *
 * @since 1.0
 */
public enum DurationNodeBuilderFactory {
  ;

  private static final Logger LOGGER = Logger.getLogger(DurationNodeBuilderFactory.class.getName());

  /**
   * Creates a new duration node builder.
   *
   * @return the duration node builder
   */
  public static DurationNodeBuilder create() {
    LOGGER.log(Level.FINE, String.format(CREATE_BUILDER, "duration"));
    return new DurationNodeBuilderImpl();
  }
}
