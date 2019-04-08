package io.github.henryssondaniel.teacup.protocol.http.node;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.github.henryssondaniel.teacup.core.assertion.GenericBooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UriBuilderImplTest {
  private final GenericBooleanAssert<?> genericBooleanAssert = mock(GenericBooleanAssert.class);
  private final GenericStringAssert<?> genericStringAssert = mock(GenericStringAssert.class);
  @InjectMocks private final UriBuilder uriBuilder = new UriBuilderImpl();

  @Mock private UriSetter implementation;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createImplementation() {
    assertThat(new UriBuilderImpl().createImplementation()).isExactlyInstanceOf(UriImpl.class);
  }

  @Test
  void setAbsolute() {
    assertThat(uriBuilder.setAbsolute(genericBooleanAssert)).isSameAs(uriBuilder);
    verify(implementation).setAbsolute(genericBooleanAssert);
  }

  @Test
  void setAuthority() {
    assertThat(uriBuilder.setAuthority(genericStringAssert)).isSameAs(uriBuilder);
    verify(implementation).setAuthority(genericStringAssert);
  }

  @Test
  void setFragment() {
    assertThat(uriBuilder.setFragment(genericStringAssert)).isSameAs(uriBuilder);
    verify(implementation).setFragment(genericStringAssert);
  }

  @Test
  void setHost() {
    assertThat(uriBuilder.setHost(genericStringAssert)).isSameAs(uriBuilder);
    verify(implementation).setHost(genericStringAssert);
  }

  @Test
  void setOpaque() {
    assertThat(uriBuilder.setOpaque(genericBooleanAssert)).isSameAs(uriBuilder);
    verify(implementation).setOpaque(genericBooleanAssert);
  }

  @Test
  void setPath() {
    assertThat(uriBuilder.setPath(genericStringAssert)).isSameAs(uriBuilder);
    verify(implementation).setPath(genericStringAssert);
  }

  @Test
  void setPort() {
    var genericIntegerAssert = mock(GenericIntegerAssert.class);

    assertThat(uriBuilder.setPort(genericIntegerAssert)).isSameAs(uriBuilder);
    verify(implementation).setPort(genericIntegerAssert);
  }

  @Test
  void setQuery() {
    assertThat(uriBuilder.setQuery(genericStringAssert)).isSameAs(uriBuilder);
    verify(implementation).setQuery(genericStringAssert);
  }

  @Test
  void setRawAuthority() {
    assertThat(uriBuilder.setRawAuthority(genericStringAssert)).isSameAs(uriBuilder);
    verify(implementation).setRawAuthority(genericStringAssert);
  }

  @Test
  void setRawFragment() {
    assertThat(uriBuilder.setRawFragment(genericStringAssert)).isSameAs(uriBuilder);
    verify(implementation).setRawFragment(genericStringAssert);
  }

  @Test
  void setRawPath() {
    assertThat(uriBuilder.setRawPath(genericStringAssert)).isSameAs(uriBuilder);
    verify(implementation).setRawPath(genericStringAssert);
  }

  @Test
  void setRawQuery() {
    assertThat(uriBuilder.setRawQuery(genericStringAssert)).isSameAs(uriBuilder);
    verify(implementation).setRawQuery(genericStringAssert);
  }

  @Test
  void setRawSchemeSpecificPart() {
    assertThat(uriBuilder.setRawSchemeSpecificPart(genericStringAssert)).isSameAs(uriBuilder);
    verify(implementation).setRawSchemeSpecificPart(genericStringAssert);
  }

  @Test
  void setRawUserInfo() {
    assertThat(uriBuilder.setRawUserInfo(genericStringAssert)).isSameAs(uriBuilder);
    verify(implementation).setRawUserInfo(genericStringAssert);
  }

  @Test
  void setScheme() {
    assertThat(uriBuilder.setScheme(genericStringAssert)).isSameAs(uriBuilder);
    verify(implementation).setScheme(genericStringAssert);
  }

  @Test
  void setSchemeSpecificPart() {
    assertThat(uriBuilder.setSchemeSpecificPart(genericStringAssert)).isSameAs(uriBuilder);
    verify(implementation).setSchemeSpecificPart(genericStringAssert);
  }

  @Test
  void setUserInfo() {
    assertThat(uriBuilder.setUserInfo(genericStringAssert)).isSameAs(uriBuilder);
    verify(implementation).setUserInfo(genericStringAssert);
  }
}
