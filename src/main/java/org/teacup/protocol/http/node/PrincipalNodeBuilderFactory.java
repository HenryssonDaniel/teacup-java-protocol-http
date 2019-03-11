package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.CREATE_BUILDER;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Principal node builder factory.
 *
 * @since 1.0
 */
public enum PrincipalNodeBuilderFactory {
  ;

  private static final Logger LOGGER =
      Logger.getLogger(PrincipalNodeBuilderFactory.class.getName());

  /**
   * Creates a new principal node builder.
   *
   * @return the principal node builder
   */
  public static PrincipalNodeBuilder create() {
    LOGGER.log(Level.FINE, String.format(CREATE_BUILDER, "principal"));
    return new PrincipalNodeBuilderImpl();
  }
}
