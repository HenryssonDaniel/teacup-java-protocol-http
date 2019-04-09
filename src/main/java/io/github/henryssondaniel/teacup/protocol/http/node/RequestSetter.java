package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericBooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericComparableAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericMapAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.Map;

interface RequestSetter extends Request, Setter<HttpRequest, GenericObjectAssert<HttpRequest, ?>> {
  void setBodyPublisher(BodyPublisher bodyPublisher);

  void setExpectContinue(GenericBooleanAssert<?> expectContinue);

  void setHeaders(
      GenericMapAssert<String, List<String>, ? super Map<String, List<String>>, ?> headers);

  void setMethod(GenericStringAssert<?> method);

  void setTimeout(Duration timeout);

  void setUri(Uri uri);

  void setVersion(GenericComparableAssert<? super Version, ?> version);
}
