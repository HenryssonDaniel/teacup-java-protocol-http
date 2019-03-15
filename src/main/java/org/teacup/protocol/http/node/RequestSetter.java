package org.teacup.protocol.http.node;

import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.util.List;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.ComparableAssert;
import org.teacup.core.assertion.MapAssert;
import org.teacup.core.assertion.StringAssert;

interface RequestSetter extends Request, Setter<HttpRequest> {
  void setBodyPublisher(BodyPublisher bodyPublisher);

  void setExpectContinue(BooleanAssert<?> expectContinue);

  void setHeaders(MapAssert<String, List<String>, ?> headers);

  void setMethod(StringAssert<?> method);

  void setTimeout(Duration timeout);

  void setUri(Uri uri);

  void setVersion(ComparableAssert<? super Version, ?> version);
}
