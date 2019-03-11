package org.teacup.protocols.http;

import static org.teacup.protocols.http.Constants.BUILD;
import static org.teacup.protocols.http.Constants.SETTING_THE;

import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSessionContext;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.ObjectAssert;

class SslSessionContextNodeBuilderImpl implements SslSessionContextNodeBuilder {
  private static final Logger LOGGER =
      Logger.getLogger(SslSessionContextNodeBuilderImpl.class.getName());
  private SslSessionContextNodeSetter sslSessionContextNodeSetter = new SslSessionContextNodeImpl();

  @Override
  public SslSessionContextNode build() {
    LOGGER.log(Level.FINE, String.format(BUILD, "SSL session context"));

    SslSessionContextNode sslSessionContextNode = sslSessionContextNodeSetter;
    sslSessionContextNodeSetter = new SslSessionContextNodeImpl();

    return sslSessionContextNode;
  }

  @Override
  public SslSessionContextNodeBuilder setAssertion(ObjectAssert<SSLSessionContext, ?> assertion) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "assertion"));
    sslSessionContextNodeSetter.setAssertion(assertion);
    return this;
  }

  @Override
  public SslSessionContextNodeBuilder setIds(ObjectAssert<? super Enumeration<byte[]>, ?> ids) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "ID's"));
    sslSessionContextNodeSetter.setIds(ids);
    return this;
  }

  @Override
  public SslSessionContextNodeBuilder setSessionCacheSize(IntegerAssert sessionCacheSize) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "session cache size"));
    sslSessionContextNodeSetter.setSessionCacheSize(sessionCacheSize);
    return this;
  }

  @Override
  public SslSessionContextNodeBuilder setSessionTimeout(IntegerAssert sessionTimeout) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "session timeout"));
    sslSessionContextNodeSetter.setSessionTimeout(sessionTimeout);
    return this;
  }
}
