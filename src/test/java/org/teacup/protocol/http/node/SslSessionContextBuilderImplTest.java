package org.teacup.protocol.http.node;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Enumeration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.ObjectAssert;

class SslSessionContextBuilderImplTest {
  private final IntegerAssert integerAssert = mock(IntegerAssert.class);

  @InjectMocks
  private final SslSessionContextBuilder sslSessionContextBuilder =
      new SslSessionContextBuilderImpl();

  @Mock private ObjectAssert<? super Enumeration<byte[]>, ?> objectAssert;
  @Mock private SslSessionContextSetter setter;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createSetter() {
    assertThat(new SslSessionContextBuilderImpl().createSetter())
        .isExactlyInstanceOf(SslSessionContextImpl.class);
  }

  @Test
  void setIds() {
    assertThat(sslSessionContextBuilder.setIds(objectAssert)).isSameAs(sslSessionContextBuilder);
    verify(setter).setIds(objectAssert);
  }

  @Test
  void setSessionCacheSize() {
    assertThat(sslSessionContextBuilder.setSessionCacheSize(integerAssert))
        .isSameAs(sslSessionContextBuilder);
    verify(setter).setSessionCacheSize(integerAssert);
  }

  @Test
  void setSessionTimeout() {
    assertThat(sslSessionContextBuilder.setSessionTimeout(integerAssert))
        .isSameAs(sslSessionContextBuilder);
    verify(setter).setSessionTimeout(integerAssert);
  }
}
