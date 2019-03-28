package org.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.IntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.ObjectAssert;
import java.util.Enumeration;
import javax.net.ssl.SSLSessionContext;

interface SslSessionContextSetter extends Setter<SSLSessionContext>, SslSessionContext {
  void setIds(ObjectAssert<? super Enumeration<byte[]>, ?> ids);

  void setSessionCacheSize(IntegerAssert<?> sessionCacheSize);

  void setSessionTimeout(IntegerAssert<?> sessionTimeout);
}
