package org.teacup.protocols.http;

import java.net.URI;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.ObjectAssert;
import org.teacup.core.assertion.StringAssert;

interface UriNodeSetter extends UriNode {
  void setAbsolute(BooleanAssert absolute);

  void setAssertion(ObjectAssert<? super URI, ?> assertion);

  void setAuthority(StringAssert authority);

  void setFragment(StringAssert fragment);

  void setHost(StringAssert host);

  void setOpaque(BooleanAssert opaque);

  void setPath(StringAssert path);

  void setPort(IntegerAssert port);

  void setQuery(StringAssert query);

  void setRawAuthority(StringAssert rawAuthority);

  void setRawFragment(StringAssert rawFragment);

  void setRawPath(StringAssert rawPath);

  void setRawQuery(StringAssert rawQuery);

  void setRawSchemeSpecificPart(StringAssert rawSchemeSpecificPart);

  void setRawUserInfo(StringAssert rawUserInfo);

  void setScheme(StringAssert scheme);

  void setSchemeSpecificPart(StringAssert schemeSpecificPart);

  void setUserInfo(StringAssert userInfo);
}
