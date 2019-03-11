package org.teacup.protocols.http;

import static org.teacup.protocols.http.Constants.CREATE_BUILDER;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * SSL session context node builder factory.
 *
 * @since 1.0
 */
public enum SslSessionContextNodeBuilderFactory {
  ;

  private static final Logger LOGGER =
      Logger.getLogger(SslSessionContextNodeBuilderFactory.class.getName());

  /**
   * Create a new SSL session context node builder.
   *
   * @return the SSL session context node builder
   */
  public static SslSessionContextNodeBuilder create() {
    LOGGER.log(Level.FINE, String.format(CREATE_BUILDER, "SSL session context"));
    return new SslSessionContextNodeBuilderImpl();
  }
}
