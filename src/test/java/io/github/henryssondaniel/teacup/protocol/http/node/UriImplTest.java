package io.github.henryssondaniel.teacup.protocol.http.node;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.github.henryssondaniel.teacup.core.assertion.GenericBooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import java.net.URI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UriImplTest {
  private final GenericBooleanAssert<?> genericBooleanAssert = mock(GenericBooleanAssert.class);
  private final GenericStringAssert<?> genericStringAssert = mock(GenericStringAssert.class);
  private final URI uri = URI.create("uri");
  private final UriSetter uriSetter = new UriImpl();

  @Mock private GenericObjectAssert<URI, ?> genericObjectAssert;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void setAbsolute() {
    uriSetter.setAbsolute(genericBooleanAssert);
    uriSetter.verify(uri);

    verify(genericBooleanAssert).verify(uri.isAbsolute());
  }

  @Test
  void setAssertion() {
    uriSetter.setAssertion(genericObjectAssert);
    uriSetter.verify(uri);

    verify(genericObjectAssert).verify(uri);
  }

  @Test
  void setAuthority() {
    uriSetter.setAuthority(genericStringAssert);
    uriSetter.verify(uri);

    verify(genericStringAssert).verify(uri.getAuthority());
  }

  @Test
  void setFragment() {
    uriSetter.setFragment(genericStringAssert);
    uriSetter.verify(uri);

    verify(genericStringAssert).verify(uri.getFragment());
  }

  @Test
  void setHost() {
    uriSetter.setHost(genericStringAssert);
    uriSetter.verify(uri);

    verify(genericStringAssert).verify(uri.getHost());
  }

  @Test
  void setOpaque() {
    uriSetter.setOpaque(genericBooleanAssert);
    uriSetter.verify(uri);

    verify(genericBooleanAssert).verify(uri.isOpaque());
  }

  @Test
  void setPath() {
    uriSetter.setPath(genericStringAssert);
    uriSetter.verify(uri);

    verify(genericStringAssert).verify(uri.getPath());
  }

  @Test
  void setPort() {
    GenericIntegerAssert<?> genericIntegerAssert = mock(GenericIntegerAssert.class);

    uriSetter.setPort(genericIntegerAssert);
    uriSetter.verify(uri);

    verify(genericIntegerAssert).verify(uri.getPort());
  }

  @Test
  void setQuery() {
    uriSetter.setQuery(genericStringAssert);
    uriSetter.verify(uri);

    verify(genericStringAssert).verify(uri.getQuery());
  }

  @Test
  void setRawAuthority() {
    uriSetter.setRawAuthority(genericStringAssert);
    uriSetter.verify(uri);

    verify(genericStringAssert).verify(uri.getRawAuthority());
  }

  @Test
  void setRawFragment() {
    uriSetter.setRawFragment(genericStringAssert);
    uriSetter.verify(uri);

    verify(genericStringAssert).verify(uri.getRawFragment());
  }

  @Test
  void setRawPath() {
    uriSetter.setRawPath(genericStringAssert);
    uriSetter.verify(uri);

    verify(genericStringAssert).verify(uri.getRawPath());
  }

  @Test
  void setRawQuery() {
    uriSetter.setRawQuery(genericStringAssert);
    uriSetter.verify(uri);

    verify(genericStringAssert).verify(uri.getRawQuery());
  }

  @Test
  void setRawSchemeSpecificPart() {
    uriSetter.setRawSchemeSpecificPart(genericStringAssert);
    uriSetter.verify(uri);

    verify(genericStringAssert).verify(uri.getRawSchemeSpecificPart());
  }

  @Test
  void setRawUserInfo() {
    uriSetter.setRawUserInfo(genericStringAssert);
    uriSetter.verify(uri);

    verify(genericStringAssert).verify(uri.getRawUserInfo());
  }

  @Test
  void setScheme() {
    uriSetter.setScheme(genericStringAssert);
    uriSetter.verify(uri);

    verify(genericStringAssert).verify(uri.getScheme());
  }

  @Test
  void setSchemeSpecificPart() {
    uriSetter.setSchemeSpecificPart(genericStringAssert);
    uriSetter.verify(uri);

    verify(genericStringAssert).verify(uri.getSchemeSpecificPart());
  }

  @Test
  void setUserInfo() {
    uriSetter.setUserInfo(genericStringAssert);
    uriSetter.verify(uri);

    verify(genericStringAssert).verify(uri.getUserInfo());
  }
}
