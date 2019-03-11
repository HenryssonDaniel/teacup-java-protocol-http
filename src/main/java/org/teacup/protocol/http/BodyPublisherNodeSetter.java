package org.teacup.protocol.http;

import java.net.http.HttpRequest.BodyPublisher;
import org.teacup.core.assertion.LongAssert;
import org.teacup.core.assertion.ObjectAssert;

interface BodyPublisherNodeSetter extends BodyPublisherNode {
  void setAssertion(ObjectAssert<? super BodyPublisher, ?> assertion);

  void setContentLength(LongAssert contentLength);
}
