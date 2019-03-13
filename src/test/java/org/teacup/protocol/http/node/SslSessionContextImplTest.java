package org.teacup.protocol.http.node;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.Enumeration;
import javax.net.ssl.SSLSessionContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.ObjectAssert;

class SslSessionContextImplTest {
  private final IntegerAssert integerAssert = mock(IntegerAssert.class);
  private final SSLSessionContext sslSessionContext = mock(SSLSessionContext.class);
  private final SslSessionContextSetter sslSessionContextSetter = new SslSessionContextImpl();

  @Mock private ObjectAssert<? super Enumeration<byte[]>, ?> enumObjectAssert;
  @Mock private ObjectAssert<? super SSLSessionContext, ?> objectAssert;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void setAssertion() {
    sslSessionContextSetter.setAssertion(objectAssert);
    sslSessionContextSetter.verify(sslSessionContext);

    verify(sslSessionContext, never()).getIds();
    verify(sslSessionContext, never()).getSessionCacheSize();
    verify(sslSessionContext, never()).getSessionTimeout();

    verify(objectAssert).verify(sslSessionContext);
  }

  @Test
  void setIds() {
    sslSessionContextSetter.setIds(enumObjectAssert);
    sslSessionContextSetter.verify(sslSessionContext);

    verify(sslSessionContext).getIds();
    verify(sslSessionContext, never()).getSessionCacheSize();
    verify(sslSessionContext, never()).getSessionTimeout();

    verify(enumObjectAssert).verify(sslSessionContext.getIds());
  }

  @Test
  void setSessionCacheSize() {
    sslSessionContextSetter.setSessionCacheSize(integerAssert);
    sslSessionContextSetter.verify(sslSessionContext);

    verify(sslSessionContext, never()).getIds();
    verify(sslSessionContext).getSessionCacheSize();
    verify(sslSessionContext, never()).getSessionTimeout();

    verify(integerAssert).verify(sslSessionContext.getSessionCacheSize());
  }

  @Test
  void setSessionTimeout() {
    sslSessionContextSetter.setSessionTimeout(integerAssert);
    sslSessionContextSetter.verify(sslSessionContext);

    verify(sslSessionContext, never()).getIds();
    verify(sslSessionContext, never()).getSessionCacheSize();
    verify(sslSessionContext).getSessionTimeout();

    verify(integerAssert).verify(sslSessionContext.getSessionTimeout());
  }
}
