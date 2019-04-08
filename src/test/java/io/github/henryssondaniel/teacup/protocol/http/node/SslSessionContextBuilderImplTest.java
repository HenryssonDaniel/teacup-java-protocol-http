package io.github.henryssondaniel.teacup.protocol.http.node;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import io.github.henryssondaniel.teacup.core.assertion.IntegerAssert;
import java.util.Enumeration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class SslSessionContextBuilderImplTest {
  private final GenericIntegerAssert<?> genericIntegerAssert = mock(IntegerAssert.class);

  @InjectMocks
  private final SslSessionContextBuilder sslSessionContextBuilder =
      new SslSessionContextBuilderImpl();

  @Mock private GenericObjectAssert<? super Enumeration<byte[]>, ?> genericObjectAssert;
  @Mock private SslSessionContextSetter implementation;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createImplementation() {
    assertThat(new SslSessionContextBuilderImpl().createImplementation())
        .isExactlyInstanceOf(SslSessionContextImpl.class);
  }

  @Test
  void setIds() {
    assertThat(sslSessionContextBuilder.setIds(genericObjectAssert))
        .isSameAs(sslSessionContextBuilder);
    verify(implementation).setIds(genericObjectAssert);
  }

  @Test
  void setSessionCacheSize() {
    assertThat(sslSessionContextBuilder.setSessionCacheSize(genericIntegerAssert))
        .isSameAs(sslSessionContextBuilder);
    verify(implementation).setSessionCacheSize(genericIntegerAssert);
  }

  @Test
  void setSessionTimeout() {
    assertThat(sslSessionContextBuilder.setSessionTimeout(genericIntegerAssert))
        .isSameAs(sslSessionContextBuilder);
    verify(implementation).setSessionTimeout(genericIntegerAssert);
  }
}
