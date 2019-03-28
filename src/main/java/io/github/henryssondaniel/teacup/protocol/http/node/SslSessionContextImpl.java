package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.IntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.ObjectAssert;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSessionContext;

class SslSessionContextImpl extends SetterImpl<SSLSessionContext>
    implements SslSessionContextSetter {
  private static final Logger LOGGER = Logger.getLogger(SslSessionContextImpl.class.getName());

  private ObjectAssert<? super Enumeration<byte[]>, ?> ids;
  private ObjectAssert<Integer, ?> sessionCacheSize;
  private ObjectAssert<Integer, ?> sessionTimeout;

  @Override
  public void setIds(ObjectAssert<? super Enumeration<byte[]>, ?> ids) {
    this.ids = ids;
  }

  @Override
  public void setSessionCacheSize(IntegerAssert<?> sessionCacheSize) {
    LOGGER.log(Level.FINE, String.format(Constants.SETTING_THE, "session cache size"));
    this.sessionCacheSize = sessionCacheSize;
  }

  @Override
  public void setSessionTimeout(IntegerAssert<?> sessionTimeout) {
    LOGGER.log(Level.FINE, String.format(Constants.SETTING_THE, "session timeout"));
    this.sessionTimeout = sessionTimeout;
  }

  @Override
  public void verify(SSLSessionContext sslSessionContext) {
    LOGGER.log(Level.FINE, String.format(Constants.VERIFY, "SSL session context"));

    verifyAssertion(getAssertion(), sslSessionContext);
    verifyIds(sslSessionContext);
    verifySessionCacheSize(sslSessionContext);
    verifySessionTimeout(sslSessionContext);
  }

  private static void verifyAssertion(
      ObjectAssert<? super SSLSessionContext, ?> objectAssert,
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
