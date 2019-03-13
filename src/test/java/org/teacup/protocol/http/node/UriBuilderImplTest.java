package org.teacup.protocol.http.node;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.teacup.core.DefaultNodeBuilder;
import org.teacup.core.Utils;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.StringAssert;

class UriBuilderImplTest {
  private final BooleanAssert booleanAssert = mock(BooleanAssert.class);
  private final StringAssert stringAssert = mock(StringAssert.class);
  private final UriBuilder uriBuilder = new UriBuilderImpl();
  private final UriSetter uriSetter = mock(UriSetter.class);

  @BeforeEach
  void beforeEach() throws IllegalAccessException, NoSuchFieldException {
    Utils.setField(DefaultNodeBuilder.class, uriBuilder, "setter", uriSetter);
  }

  @Test
  void createSetter() {
    assertThat(new UriBuilderImpl().createSetter()).isExactlyInstanceOf(UriImpl.class);
  }

  @Test
  void setAbsolute() {
    assertThat(uriBuilder.setAbsolute(booleanAssert)).isSameAs(uriBuilder);
    verify(uriSetter).setAbsolute(booleanAssert);
  }

  @Test
  void setAuthority() {
    assertThat(uriBuilder.setAuthority(stringAssert)).isSameAs(uriBuilder);
    verify(uriSetter).setAuthority(stringAssert);
  }

  @Test
  void setFragment() {
    assertThat(uriBuilder.setFragment(stringAssert)).isSameAs(uriBuilder);
    verify(uriSetter).setFragment(stringAssert);
  }

  @Test
  void setHost() {
    assertThat(uriBuilder.setHost(stringAssert)).isSameAs(uriBuilder);
    verify(uriSetter).setHost(stringAssert);
  }

  @Test
  void setOpaque() {
    assertThat(uriBuilder.setOpaque(booleanAssert)).isSameAs(uriBuilder);
    verify(uriSetter).setOpaque(booleanAssert);
  }

  @Test
  void setPath() {
    assertThat(uriBuilder.setPath(stringAssert)).isSameAs(uriBuilder);
    verify(uriSetter).setPath(stringAssert);
  }

  @Test
  void setPort() {
    var integerAssert = mock(IntegerAssert.class);

    assertThat(uriBuilder.setPort(integerAssert)).isSameAs(uriBuilder);
    verify(uriSetter).setPort(integerAssert);
  }

  @Test
  void setQuery() {
    assertThat(uriBuilder.setQuery(stringAssert)).isSameAs(uriBuilder);
    verify(uriSetter).setQuery(stringAssert);
  }

  @Test
  void setRawAuthority() {
    assertThat(uriBuilder.setRawAuthority(stringAssert)).isSameAs(uriBuilder);
    verify(uriSetter).setRawAuthority(stringAssert);
  }

  @Test
  void setRawFragment() {
    assertThat(uriBuilder.setRawFragment(stringAssert)).isSameAs(uriBuilder);
    verify(uriSetter).setRawFragment(stringAssert);
  }

  @Test
  void setRawPath() {
    assertThat(uriBuilder.setRawPath(stringAssert)).isSameAs(uriBuilder);
    verify(uriSetter).setRawPath(stringAssert);
  }

  @Test
  void setRawQuery() {
    assertThat(uriBuilder.setRawQuery(stringAssert)).isSameAs(uriBuilder);
    verify(uriSetter).setRawQuery(stringAssert);
  }

  @Test
  void setRawSchemeSpecificPart() {
    assertThat(uriBuilder.setRawSchemeSpecificPart(stringAssert)).isSameAs(uriBuilder);
    verify(uriSetter).setRawSchemeSpecificPart(stringAssert);
  }

  @Test
  void setRawUserInfo() {
    assertThat(uriBuilder.setRawUserInfo(stringAssert)).isSameAs(uriBuilder);
    verify(uriSetter).setRawUserInfo(stringAssert);
  }

  @Test
  void setScheme() {
    assertThat(uriBuilder.setScheme(stringAssert)).isSameAs(uriBuilder);
    verify(uriSetter).setScheme(stringAssert);
  }

  @Test
  void setSchemeSpecificPart() {
    assertThat(uriBuilder.setSchemeSpecificPart(stringAssert)).isSameAs(uriBuilder);
    verify(uriSetter).setSchemeSpecificPart(stringAssert);
  }

  @Test
  void setUserInfo() {
    assertThat(uriBuilder.setUserInfo(stringAssert)).isSameAs(uriBuilder);
    verify(uriSetter).setUserInfo(stringAssert);
  }
}
