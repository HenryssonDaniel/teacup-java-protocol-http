package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.SETTING_THE;
import static org.teacup.protocol.http.node.Constants.VERIFY;

import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSessionContext;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.ObjectAssert;

class SslSessionContextImpl implements SslSessionContextSetter {
  private static final Logger LOGGER = Logger.getLogger(SslSessionContextImpl.class.getName());

  private ObjectAssert<? super SSLSessionContext, ?> assertion;
  private ObjectAssert<? super Enumeration<byte[]>, ?> ids;
  private ObjectAssert<Integer, IntegerAssert> sessionCacheSize;
  private ObjectAssert<Integer, IntegerAssert> sessionTimeout;

  @Override
  public void setAssertion(ObjectAssert<? super SSLSessionContext, ?> assertion) {
    this.assertion = assertion;
  }

  @Override
  public void setIds(ObjectAssert<? super Enumeration<byte[]>, ?> ids) {
    this.ids = ids;
  }

  @Override
  public void setSessionCacheSize(IntegerAssert sessionCacheSize) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "session cache size"));
    this.sessionCacheSize = sessionCacheSize;
  }

  @Override
  public void setSessionTimeout(IntegerAssert sessionTimeout) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "session timeout"));
    this.sessionTimeout = sessionTimeout;
  }

  @Override
  public void verify(SSLSessionContext sslSessionContext) {
    LOGGER.log(Level.FINE, String.format(VERIFY, "SSL session context"));
    if (assertion != null) assertion.verify(sslSessionContext);

    verifyIds(sslSessionContext);
    verifyInteger(sessionCacheSize, sslSessionContext.getSessionCacheSize());
    verifyInteger(sessionTimeout, sslSessionContext.getSessionTimeout());
  }

  private void verifyIds(SSLSessionContext sslSessionContext) {
    if (ids != null) ids.verify(sslSessionContext.getIds());
  }

  private static void verifyInteger(
      ObjectAssert<? super Integer, IntegerAssert> objectAssert, int actual) {
    if (objectAssert != null) objectAssert.verify(actual);
  }
}