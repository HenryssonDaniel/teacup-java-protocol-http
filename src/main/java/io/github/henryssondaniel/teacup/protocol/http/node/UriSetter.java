package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.BooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.IntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.StringAssert;
import java.net.URI;

interface UriSetter extends Setter<URI>, Uri {
  void setAbsolute(BooleanAssert<?> absolute);

  void setAuthority(StringAssert<?> authority);

  void setFragment(StringAssert<?> fragment);

  void setHost(StringAssert<?> host);

  void setOpaque(BooleanAssert<?> opaque);

  void setPath(StringAssert<?> path);

  void setPort(IntegerAssert<?> port);

  void setQuery(StringAssert<?> query);

  void setRawAuthority(StringAssert<?> rawAuthority);

  void setRawFragment(StringAssert<?> rawFragment);

  void setRawPath(StringAssert<?> rawPath);

  void setRawQuery(StringAssert<?> rawQuery);

  void setRawSchemeSpecificPart(StringAssert<?> rawSchemeSpecificPart);

  void setRawUserInfo(StringAssert<?> rawUserInfo);

  void setScheme(StringAssert<?> scheme);

  void setSchemeSpecificPart(StringAssert<?> schemeSpecificPart);

  void setUserInfo(StringAssert<?> userInfo);
}
