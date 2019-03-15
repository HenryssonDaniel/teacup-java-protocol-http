package org.teacup.protocol.http.node;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.StringAssert;

class UriBuilderImplTest {
  private final BooleanAssert<?> booleanAssert = mock(BooleanAssert.class);
  private final StringAssert<?> stringAssert = mock(StringAssert.class);
  @InjectMocks private final UriBuilder uriBuilder = new UriBuilderImpl();

  @Mock private UriSetter setter;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createSetter() {
    assertThat(new UriBuilderImpl().createSetter()).isExactlyInstanceOf(UriImpl.class);
  }

  @Test
  void setAbsolute() {
    assertThat(uriBuilder.setAbsolute(booleanAssert)).isSameAs(uriBuilder);
    verify(setter).setAbsolute(booleanAssert);
  }

  @Test
  void setAuthority() {
    assertThat(uriBuilder.setAuthority(stringAssert)).isSameAs(uriBuilder);
    verify(setter).setAuthority(stringAssert);
  }

  @Test
  void setFragment() {
    assertThat(uriBuilder.setFragment(stringAssert)).isSameAs(uriBuilder);
    verify(setter).setFragment(stringAssert);
  }

  @Test
  void setHost() {
    assertThat(uriBuilder.setHost(stringAssert)).isSameAs(uriBuilder);
    verify(setter).setHost(stringAssert);
  }

  @Test
  void setOpaque() {
    assertThat(uriBuilder.setOpaque(booleanAssert)).isSameAs(uriBuilder);
    verify(setter).setOpaque(booleanAssert);
  }

  @Test
  void setPath() {
    assertThat(uriBuilder.setPath(stringAssert)).isSameAs(uriBuilder);
    verify(setter).setPath(stringAssert);
  }

  @Test
  void setPort() {
    var integerAssert = mock(IntegerAssert.class);

    assertThat(uriBuilder.setPort(integerAssert)).isSameAs(uriBuilder);
    verify(setter).setPort(integerAssert);
  }

  @Test
  void setQuery() {
    assertThat(uriBuilder.setQuery(stringAssert)).isSameAs(uriBuilder);
    verify(setter).setQuery(stringAssert);
  }

  @Test
  void setRawAuthority() {
    assertThat(uriBuilder.setRawAuthority(stringAssert)).isSameAs(uriBuilder);
    verify(setter).setRawAuthority(stringAssert);
  }

  @Test
  void setRawFragment() {
    assertThat(uriBuilder.setRawFragment(stringAssert)).isSameAs(uriBuilder);
    verify(setter).setRawFragment(stringAssert);
  }

  @Test
  void setRawPath() {
    assertThat(uriBuilder.setRawPath(stringAssert)).isSameAs(uriBuilder);
    verify(setter).setRawPath(stringAssert);
  }

  @Test
  void setRawQuery() {
    assertThat(uriBuilder.setRawQuery(stringAssert)).isSameAs(uriBuilder);
    verify(setter).setRawQuery(stringAssert);
  }

  @Test
  void setRawSchemeSpecificPart() {
    assertThat(uriBuilder.setRawSchemeSpecificPart(stringAssert)).isSameAs(uriBuilder);
    verify(setter).setRawSchemeSpecificPart(stringAssert);
  }

  @Test
  void setRawUserInfo() {
    assertThat(uriBuilder.setRawUserInfo(stringAssert)).isSameAs(uriBuilder);
    verify(setter).setRawUserInfo(stringAssert);
  }

  @Test
  void setScheme() {
    assertThat(uriBuilder.setScheme(stringAssert)).isSameAs(uriBuilder);
    verify(setter).setScheme(stringAssert);
  }

  @Test
  void setSchemeSpecificPart() {
    assertThat(uriBuilder.setSchemeSpecificPart(stringAssert)).isSameAs(uriBuilder);
    verify(setter).setSchemeSpecificPart(stringAssert);
  }

  @Test
  void setUserInfo() {
    assertThat(uriBuilder.setUserInfo(stringAssert)).isSameAs(uriBuilder);
    verify(setter).setUserInfo(stringAssert);
  }
}
