package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.CREATE_BUILDER;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * SSL session builder factory.
 *
 * @since 1.0
 */
public enum SslSessionBuilderFactory {
  ;

  private static final Logger LOGGER = Logger.getLogger(SslSessionBuilderFactory.class.getName());

  /**
   * Create a new SSL session builder.
   *
   * @return the SSL session builder
   */
  public static SslSessionBuilder create() {
    LOGGER.log(Level.FINE, String.format(CREATE_BUILDER, "SSL session"));
    return new SslSessionBuilderImpl();
  }
}
