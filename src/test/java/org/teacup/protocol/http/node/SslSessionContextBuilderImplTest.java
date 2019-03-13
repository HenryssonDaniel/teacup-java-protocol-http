package org.teacup.protocol.http.node;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Enumeration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.teacup.core.DefaultNodeBuilder;
import org.teacup.core.Utils;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.ObjectAssert;

class SslSessionContextBuilderImplTest {
  private final IntegerAssert integerAssert = mock(IntegerAssert.class);
  private final SslSessionContextBuilder sslSessionContextBuilder =
      new SslSessionContextBuilderImpl();
  private final SslSessionContextSetter sslSessionContextSetter =
      mock(SslSessionContextSetter.class);

  @Mock private ObjectAssert<? super Enumeration<byte[]>, ?> objectAssert;

  @BeforeEach
  void beforeEach() throws IllegalAccessException, NoSuchFieldException {
    Utils.setField(
        DefaultNodeBuilder.class, sslSessionContextBuilder, "setter", sslSessionContextSetter);
  }

  @Test
  void createSetter() {
    assertThat(new SslSessionContextBuilderImpl().createSetter())
        .isExactlyInstanceOf(SslSessionContextImpl.class);
  }

  @Test
  void setIds() {
    assertThat(sslSessionContextBuilder.setIds(objectAssert)).isSameAs(sslSessionContextBuilder);
    verify(sslSessionContextSetter).setIds(objectAssert);
  }

  @Test
  void setSessionCacheSize() {
    assertThat(sslSessionContextBuilder.setSessionCacheSize(integerAssert))
        .isSameAs(sslSessionContextBuilder);
    verify(sslSessionContextSetter).setSessionCacheSize(integerAssert);
  }

  @Test
  void setSessionTimeout() {
    assertThat(sslSessionContextBuilder.setSessionTimeout(integerAssert))
        .isSameAs(sslSessionContextBuilder);
    verify(sslSessionContextSetter).setSessionTimeout(integerAssert);
  }
}
