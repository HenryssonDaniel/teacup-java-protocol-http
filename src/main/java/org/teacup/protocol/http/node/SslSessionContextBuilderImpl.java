package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.BUILD;
import static org.teacup.protocol.http.node.Constants.SETTING_THE;

import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSessionContext;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.ObjectAssert;

class SslSessionContextBuilderImpl implements SslSessionContextBuilder {
  private static final Logger LOGGER =
      Logger.getLogger(SslSessionContextBuilderImpl.class.getName());
  private SslSessionContextSetter sslSessionContextSetter = new SslSessionContextImpl();

  @Override
  public SslSessionContext build() {
    LOGGER.log(Level.FINE, String.format(BUILD, "SSL session context"));

    SslSessionContext sslSessionContext = sslSessionContextSetter;
    sslSessionContextSetter = new SslSessionContextImpl();

    return sslSessionContext;
  }

  @Override
  public SslSessionContextBuilder setAssertion(ObjectAssert<SSLSessionContext, ?> assertion) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "assertion"));
    sslSessionContextSetter.setAssertion(assertion);
    return this;
  }

  @Override
  public SslSessionContextBuilder setIds(ObjectAssert<? super Enumeration<byte[]>, ?> ids) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "ID's"));
    sslSessionContextSetter.setIds(ids);
    return this;
  }

  @Override
  public SslSessionContextBuilder setSessionCacheSize(IntegerAssert sessionCacheSize) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "session cache size"));
    sslSessionContextSetter.setSessionCacheSize(sessionCacheSize);
    return this;
  }

  @Override
  public SslSessionContextBuilder setSessionTimeout(IntegerAssert sessionTimeout) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "session timeout"));
    sslSessionContextSetter.setSessionTimeout(sessionTimeout);
    return this;
  }
}
