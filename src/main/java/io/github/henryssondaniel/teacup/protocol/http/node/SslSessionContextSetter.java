package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import java.util.Enumeration;
import javax.net.ssl.SSLSessionContext;

interface SslSessionContextSetter
    extends Setter<SSLSessionContext, GenericObjectAssert<SSLSessionContext, ?>>,
        SslSessionContext {
  void setIds(GenericObjectAssert<? super Enumeration<byte[]>, ?> ids);

  void setSessionCacheSize(GenericIntegerAssert<?> sessionCacheSize);

  void setSessionTimeout(GenericIntegerAssert<?> sessionTimeout);
}
