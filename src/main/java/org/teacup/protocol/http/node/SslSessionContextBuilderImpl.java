package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.SETTING_THE;

import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSessionContext;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.ObjectAssert;

class SslSessionContextBuilderImpl
    extends BuilderImpl<
        SSLSessionContext, SslSessionContext, SslSessionContextSetter, SslSessionContextBuilder>
    implements SslSessionContextBuilder {
  private static final Logger LOGGER =
      Logger.getLogger(SslSessionContextBuilderImpl.class.getName());

  SslSessionContextBuilderImpl() {
    super(new SslSessionContextImpl());
  }

  @Override
  public SslSessionContextBuilder setIds(ObjectAssert<? super Enumeration<byte[]>, ?> ids) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "ID's"));
    getImplementation().setIds(ids);
    return this;
  }

  @Override
  public SslSessionContextBuilder setSessionCacheSize(IntegerAssert<?> sessionCacheSize) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "session cache size"));
    getImplementation().setSessionCacheSize(sessionCacheSize);
    return this;
  }

  @Override
  public SslSessionContextBuilder setSessionTimeout(IntegerAssert<?> sessionTimeout) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "session timeout"));
    getImplementation().setSessionTimeout(sessionTimeout);
    return this;
  }

  @Override
  protected SslSessionContextSetter createImplementation() {
    return new SslSessionContextImpl();
  }
}
