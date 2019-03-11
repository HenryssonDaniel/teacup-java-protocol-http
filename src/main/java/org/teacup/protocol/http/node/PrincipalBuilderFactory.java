package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.CREATE_BUILDER;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Principal builder factory.
 *
 * @since 1.0
 */
public enum PrincipalBuilderFactory {
  ;

  private static final Logger LOGGER = Logger.getLogger(PrincipalBuilderFactory.class.getName());

  /**
   * Creates a new principal builder.
   *
   * @return the principal builder
   */
  public static PrincipalBuilder create() {
    LOGGER.log(Level.FINE, String.format(CREATE_BUILDER, "principal"));
    return new PrincipalBuilderImpl();
  }
}
