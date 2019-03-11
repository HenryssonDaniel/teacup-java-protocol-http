package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.CREATE_BUILDER;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * SSL session node builder factory.
 *
 * @since 1.0
 */
public enum SslSessionNodeBuilderFactory {
  ;

  private static final Logger LOGGER =
      Logger.getLogger(SslSessionNodeBuilderFactory.class.getName());

  /**
   * Create a new SSL session node builder.
   *
   * @return the SSL session node builder
   */
  public static SslSessionNodeBuilder create() {
    LOGGER.log(Level.FINE, String.format(CREATE_BUILDER, "SSL session"));
    return new SslSessionNodeBuilderImpl();
  }
}
