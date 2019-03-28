package org.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.BooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.ComparableAssert;
import io.github.henryssondaniel.teacup.core.assertion.MapAssert;
import io.github.henryssondaniel.teacup.core.assertion.StringAssert;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.util.List;

interface RequestSetter extends Request, Setter<HttpRequest> {
  void setBodyPublisher(BodyPublisher bodyPublisher);

  void setExpectContinue(BooleanAssert<?> expectContinue);

  void setHeaders(MapAssert<String, List<String>, ?> headers);

  void setMethod(StringAssert<?> method);

  void setTimeout(Duration timeout);

  void setUri(Uri uri);

  void setVersion(ComparableAssert<? super Version, ?> version);
}
