package org.teacup.protocol.http.node;

import java.net.http.HttpRequest;
import org.teacup.core.assertion.LongAssert;
import org.teacup.core.assertion.ObjectAssert;

interface BodyPublisherSetter extends BodyPublisher {
  void setAssertion(ObjectAssert<? super HttpRequest.BodyPublisher, ?> assertion);

  void setContentLength(LongAssert contentLength);
}
