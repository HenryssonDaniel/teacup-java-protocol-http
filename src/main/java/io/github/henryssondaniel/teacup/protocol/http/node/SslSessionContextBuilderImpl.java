package io.github.henryssondaniel.teacup.protocol.http.node;

import static io.github.henryssondaniel.teacup.protocol.http.node.Constants.SETTING_THE;

import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSessionContext;

class SslSessionContextBuilderImpl
    extends BuilderImpl<
        SSLSessionContext, SslSessionContext, SslSessionContextSetter, SslSessionContextBuilder>
    implements SslSessionContextBuilder {
  private static final Logger LOGGER = Factory.getLogger(SslSessionContextBuilderImpl.class);

  SslSessionContextBuilderImpl() {
    super(new SslSessionContextImpl());
  }

  @Override
  public SslSessionContextBuilder setIds(GenericObjectAssert<? super Enumeration<byte[]>, ?> ids) {
    LOGGER.log(Level.FINE, SETTING_THE, "ID's");
    getImplementation().setIds(ids);
    return this;
  }

  @Override
  public SslSessionContextBuilder setSessionCacheSize(GenericIntegerAssert<?> sessionCacheSize) {
    LOGGER.log(Level.FINE, SETTING_THE, "session cache size");
    getImplementation().setSessionCacheSize(sessionCacheSize);
    return this;
  }

  @Override
  public SslSessionContextBuilder setSessionTimeout(GenericIntegerAssert<?> sessionTimeout) {
    LOGGER.log(Level.FINE, SETTING_THE, "session timeout");
    getImplementation().setSessionTimeout(sessionTimeout);
    return this;
  }

  @Override
  protected SslSessionContextSetter createImplementation() {
    return new SslSessionContextImpl();
  }
}
