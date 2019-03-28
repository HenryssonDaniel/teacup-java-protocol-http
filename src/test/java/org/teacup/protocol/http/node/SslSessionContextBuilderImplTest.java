package org.teacup.protocol.http.node;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.github.henryssondaniel.teacup.core.assertion.IntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.ObjectAssert;
import java.util.Enumeration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class SslSessionContextBuilderImplTest {
  private final IntegerAssert<?> integerAssert = mock(IntegerAssert.class);

  @InjectMocks
  private final SslSessionContextBuilder sslSessionContextBuilder =
      new SslSessionContextBuilderImpl();

  @Mock private SslSessionContextSetter implementation;
  @Mock private ObjectAssert<? super Enumeration<byte[]>, ?> objectAssert;

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
    assertThat(sslSessionContextBuilder.setIds(objectAssert)).isSameAs(sslSessionContextBuilder);
    verify(implementation).setIds(objectAssert);
  }

  @Test
  void setSessionCacheSize() {
    assertThat(sslSessionContextBuilder.setSessionCacheSize(integerAssert))
        .isSameAs(sslSessionContextBuilder);
    verify(implementation).setSessionCacheSize(integerAssert);
  }

  @Test
  void setSessionTimeout() {
    assertThat(sslSessionContextBuilder.setSessionTimeout(integerAssert))
        .isSameAs(sslSessionContextBuilder);
    verify(implementation).setSessionTimeout(integerAssert);
  }
}
