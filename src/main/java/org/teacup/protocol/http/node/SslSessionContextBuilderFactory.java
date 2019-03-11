package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.CREATE_BUILDER;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * SSL session context builder factory.
 *
 * @since 1.0
 */
public enum SslSessionContextBuilderFactory {
  ;

  private static final Logger LOGGER =
      Logger.getLogger(SslSessionContextBuilderFactory.class.getName());

  /**
   * Create a new SSL session context builder.
   *
   * @return the SSL session context builder
   */
  public static SslSessionContextBuilder create() {
    LOGGER.log(Level.FINE, String.format(CREATE_BUILDER, "SSL session context"));
    return new SslSessionContextBuilderImpl();
  }
}
