package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import io.github.henryssondaniel.teacup.protocol.NodeBuilder;
import java.util.Enumeration;
import javax.net.ssl.SSLSessionContext;

/**
 * SSL session context builder.
 *
 * @since 1.0
 */
public interface SslSessionContextBuilder
    extends NodeBuilder<SSLSessionContext, SslSessionContext, SslSessionContextBuilder> {
  /**
   * Sets the ID's.
   *
   * @param ids the ID's
   * @return the SSL session context builder
   */
  SslSessionContextBuilder setIds(GenericObjectAssert<? super Enumeration<byte[]>, ?> ids);

  /**
   * Sets the session cache size.
   *
   * @param sessionCacheSize the session cache size
   * @return the SSL session context builder
   */
  SslSessionContextBuilder setSessionCacheSize(GenericIntegerAssert<?> sessionCacheSize);

  /**
   * Sets the session timeout.
   *
   * @param sessionTimeout the session timeout
   * @return the SSL session context builder
   */
  SslSessionContextBuilder setSessionTimeout(GenericIntegerAssert<?> sessionTimeout);
}
