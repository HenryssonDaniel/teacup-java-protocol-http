package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSessionContext;

class SslSessionContextImpl
    extends SetterImpl<SSLSessionContext, GenericObjectAssert<SSLSessionContext, ?>>
    implements SslSessionContextSetter {
  private static final Logger LOGGER = Factory.getLogger(SslSessionContextImpl.class);

  private GenericObjectAssert<? super Enumeration<byte[]>, ?> ids;
  private GenericObjectAssert<Integer, ?> sessionCacheSize;
  private GenericObjectAssert<Integer, ?> sessionTimeout;

  @Override
  public void setIds(GenericObjectAssert<? super Enumeration<byte[]>, ?> ids) {
    this.ids = ids;
  }

  @Override
  public void setSessionCacheSize(GenericIntegerAssert<?> sessionCacheSize) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "session cache size");
    this.sessionCacheSize = sessionCacheSize;
  }

  @Override
  public void setSessionTimeout(GenericIntegerAssert<?> sessionTimeout) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "session timeout");
    this.sessionTimeout = sessionTimeout;
  }

  @Override
  public void verify(SSLSessionContext sslSessionContext) {
    LOGGER.log(Level.FINE, Constants.VERIFY, "SSL session context");

    verifyAssertion(getAssertion(), sslSessionContext);
    verifyIds(sslSessionContext);
    verifySessionCacheSize(sslSessionContext);
    verifySessionTimeout(sslSessionContext);
  }

  private static void verifyAssertion(
      GenericObjectAssert<? super SSLSessionContext, ?> objectAssert,
      SSLSessionContext sslSessionContext) {
    if (objectAssert != null) objectAssert.verify(sslSessionContext);
  }

  private void verifyIds(SSLSessionContext sslSessionContext) {
    if (ids != null) ids.verify(sslSessionContext.getIds());
  }

  private void verifySessionCacheSize(SSLSessionContext sslSessionContext) {
    if (sessionCacheSize != null) sessionCacheSize.verify(sslSessionContext.getSessionCacheSize());
  }

  private void verifySessionTimeout(SSLSessionContext sslSessionContext) {
    if (sessionTimeout != null) sessionTimeout.verify(sslSessionContext.getSessionTimeout());
  }
}
