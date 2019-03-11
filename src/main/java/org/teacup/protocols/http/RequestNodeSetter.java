package org.teacup.protocols.http;

import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.util.List;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.ComparableAssert;
import org.teacup.core.assertion.MapAssert;
import org.teacup.core.assertion.ObjectAssert;
import org.teacup.core.assertion.StringAssert;

interface RequestNodeSetter extends RequestNode {
  void setAssertion(ObjectAssert<? super HttpRequest, ?> assertion);

  void setBodyPublisher(BodyPublisherNode bodyPublisher);

  void setExpectContinue(BooleanAssert expectContinue);

  void setHeaders(MapAssert<String, List<String>, ?> headers);

  void setMethod(StringAssert method);

  void setTimeout(DurationNode timeout);

  void setUri(UriNode uri);

  void setVersion(ComparableAssert<? super Version, ?> version);
}
