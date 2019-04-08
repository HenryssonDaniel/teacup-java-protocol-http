package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericBooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import java.net.URI;

interface UriSetter extends Setter<URI>, Uri {
  void setAbsolute(GenericBooleanAssert<?> absolute);

  void setAuthority(GenericStringAssert<?> authority);

  void setFragment(GenericStringAssert<?> fragment);

  void setHost(GenericStringAssert<?> host);

  void setOpaque(GenericBooleanAssert<?> opaque);

  void setPath(GenericStringAssert<?> path);

  void setPort(GenericIntegerAssert<?> port);

  void setQuery(GenericStringAssert<?> query);

  void setRawAuthority(GenericStringAssert<?> rawAuthority);

  void setRawFragment(GenericStringAssert<?> rawFragment);

  void setRawPath(GenericStringAssert<?> rawPath);

  void setRawQuery(GenericStringAssert<?> rawQuery);

  void setRawSchemeSpecificPart(GenericStringAssert<?> rawSchemeSpecificPart);

  void setRawUserInfo(GenericStringAssert<?> rawUserInfo);

  void setScheme(GenericStringAssert<?> scheme);

  void setSchemeSpecificPart(GenericStringAssert<?> schemeSpecificPart);

  void setUserInfo(GenericStringAssert<?> userInfo);
}
