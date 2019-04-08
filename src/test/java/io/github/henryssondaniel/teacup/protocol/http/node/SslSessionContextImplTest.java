package io.github.henryssondaniel.teacup.protocol.http.node;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import io.github.henryssondaniel.teacup.core.assertion.IntegerAssert;
import java.util.Enumeration;
import javax.net.ssl.SSLSessionContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class SslSessionContextImplTest {
  private final GenericIntegerAssert<?> genericIntegerAssert = mock(IntegerAssert.class);
  private final SSLSessionContext sslSessionContext = mock(SSLSessionContext.class);
  private final SslSessionContextSetter sslSessionContextSetter = new SslSessionContextImpl();

  @Mock private GenericObjectAssert<Enumeration<byte[]>, ?> genericEnumObjectAssert;
  @Mock private GenericObjectAssert<SSLSessionContext, ?> genericObjectAssert;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void setAssertion() {
    sslSessionContextSetter.setAssertion(genericObjectAssert);
    sslSessionContextSetter.verify(sslSessionContext);

    verify(sslSessionContext, never()).getIds();
    verify(sslSessionContext, never()).getSessionCacheSize();
    verify(sslSessionContext, never()).getSessionTimeout();

    verify(genericObjectAssert).verify(sslSessionContext);
  }

  @Test
  void setIds() {
    sslSessionContextSetter.setIds(genericEnumObjectAssert);
    sslSessionContextSetter.verify(sslSessionContext);

    verify(sslSessionContext).getIds();
    verify(sslSessionContext, never()).getSessionCacheSize();
    verify(sslSessionContext, never()).getSessionTimeout();

    verify(genericEnumObjectAssert).verify(sslSessionContext.getIds());
  }

  @Test
  void setSessionCacheSize() {
    sslSessionContextSetter.setSessionCacheSize(genericIntegerAssert);
    sslSessionContextSetter.verify(sslSessionContext);

    verify(sslSessionContext, never()).getIds();
    verify(sslSessionContext).getSessionCacheSize();
    verify(sslSessionContext, never()).getSessionTimeout();

    verify(genericIntegerAssert).verify(sslSessionContext.getSessionCacheSize());
  }

  @Test
  void setSessionTimeout() {
    sslSessionContextSetter.setSessionTimeout(genericIntegerAssert);
    sslSessionContextSetter.verify(sslSessionContext);

    verify(sslSessionContext, never()).getIds();
    verify(sslSessionContext, never()).getSessionCacheSize();
    verify(sslSessionContext).getSessionTimeout();

    verify(genericIntegerAssert).verify(sslSessionContext.getSessionTimeout());
  }
}
