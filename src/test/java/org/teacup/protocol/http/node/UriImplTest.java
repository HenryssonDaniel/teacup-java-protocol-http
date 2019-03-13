package org.teacup.protocol.http.node;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.net.URI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.ObjectAssert;
import org.teacup.core.assertion.StringAssert;

class UriImplTest {
  private final BooleanAssert booleanAssert = mock(BooleanAssert.class);
  private final StringAssert stringAssert = mock(StringAssert.class);
  private final URI uri = URI.create("uri");
  private final UriSetter uriSetter = new UriImpl();

  @Mock private ObjectAssert<? super URI, ?> objectAssert;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void setAbsolute() {
    uriSetter.setAbsolute(booleanAssert);
    uriSetter.verify(uri);

    verify(booleanAssert).verify(uri.isAbsolute());
  }

  @Test
  void setAssertion() {
    uriSetter.setAssertion(objectAssert);
    uriSetter.verify(uri);

    verify(objectAssert).verify(uri);
  }

  @Test
  void setAuthority() {
    uriSetter.setAuthority(stringAssert);
    uriSetter.verify(uri);

    verify(stringAssert).verify(uri.getAuthority());
  }

  @Test
  void setFragment() {
    uriSetter.setFragment(stringAssert);
    uriSetter.verify(uri);

    verify(stringAssert).verify(uri.getFragment());
  }

  @Test
  void setHost() {
    uriSetter.setHost(stringAssert);
    uriSetter.verify(uri);

    verify(stringAssert).verify(uri.getHost());
  }

  @Test
  void setOpaque() {
    uriSetter.setOpaque(booleanAssert);
    uriSetter.verify(uri);

    verify(booleanAssert).verify(uri.isOpaque());
  }

  @Test
  void setPath() {
    uriSetter.setPath(stringAssert);
    uriSetter.verify(uri);

    verify(stringAssert).verify(uri.getPath());
  }

  @Test
  void setPort() {
    var integerAssert = mock(IntegerAssert.class);

    uriSetter.setPort(integerAssert);
    uriSetter.verify(uri);

    verify(integerAssert).verify(uri.getPort());
  }

  @Test
  void setQuery() {
    uriSetter.setQuery(stringAssert);
    uriSetter.verify(uri);

    verify(stringAssert).verify(uri.getQuery());
  }

  @Test
  void setRawAuthority() {
    uriSetter.setRawAuthority(stringAssert);
    uriSetter.verify(uri);

    verify(stringAssert).verify(uri.getRawAuthority());
  }

  @Test
  void setRawFragment() {
    uriSetter.setRawFragment(stringAssert);
    uriSetter.verify(uri);

    verify(stringAssert).verify(uri.getRawFragment());
  }

  @Test
  void setRawPath() {
    uriSetter.setRawPath(stringAssert);
    uriSetter.verify(uri);

    verify(stringAssert).verify(uri.getRawPath());
  }

  @Test
  void setRawQuery() {
    uriSetter.setRawQuery(stringAssert);
    uriSetter.verify(uri);

    verify(stringAssert).verify(uri.getRawQuery());
  }

  @Test
  void setRawSchemeSpecificPart() {
    uriSetter.setRawSchemeSpecificPart(stringAssert);
    uriSetter.verify(uri);

    verify(stringAssert).verify(uri.getRawSchemeSpecificPart());
  }

  @Test
  void setRawUserInfo() {
    uriSetter.setRawUserInfo(stringAssert);
    uriSetter.verify(uri);

    verify(stringAssert).verify(uri.getRawUserInfo());
  }

  @Test
  void setScheme() {
    uriSetter.setScheme(stringAssert);
    uriSetter.verify(uri);

    verify(stringAssert).verify(uri.getScheme());
  }

  @Test
  void setSchemeSpecificPart() {
    uriSetter.setSchemeSpecificPart(stringAssert);
    uriSetter.verify(uri);

    verify(stringAssert).verify(uri.getSchemeSpecificPart());
  }

  @Test
  void setUserInfo() {
    uriSetter.setUserInfo(stringAssert);
    uriSetter.verify(uri);

    verify(stringAssert).verify(uri.getUserInfo());
  }
}
