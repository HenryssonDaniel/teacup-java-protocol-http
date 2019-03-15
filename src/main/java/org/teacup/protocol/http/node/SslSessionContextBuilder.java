package org.teacup.protocol.http.node;

import java.util.Enumeration;
import javax.net.ssl.SSLSessionContext;
import org.teacup.core.NodeBuilder;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.ObjectAssert;

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
  SslSessionContextBuilder setIds(ObjectAssert<? super Enumeration<byte[]>, ?> ids);

  /**
   * Sets the session cache size.
   *
   * @param sessionCacheSize the session cache size
   * @return the SSL session context builder
   */
  SslSessionContextBuilder setSessionCacheSize(IntegerAssert<?> sessionCacheSize);

  /**
   * Sets the session timeout.
   *
   * @param sessionTimeout the session timeout
   * @return the SSL session context builder
   */
  SslSessionContextBuilder setSessionTimeout(IntegerAssert<?> sessionTimeout);
}
