package org.teacup.protocol.http.node;

import java.util.Enumeration;
import javax.net.ssl.SSLSessionContext;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.ObjectAssert;

interface SslSessionContextNodeSetter extends SslSessionContextNode {
  void setAssertion(ObjectAssert<? super SSLSessionContext, ?> assertion);

  void setIds(ObjectAssert<? super Enumeration<byte[]>, ?> ids);

  void setSessionCacheSize(IntegerAssert sessionCacheSize);

  void setSessionTimeout(IntegerAssert sessionTimeout);
}
