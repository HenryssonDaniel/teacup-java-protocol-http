package org.teacup.protocol.http.node;

import java.net.http.HttpRequest;
import org.teacup.core.assertion.LongAssert;

interface BodyPublisherSetter extends BodyPublisher, Setter<HttpRequest.BodyPublisher> {
  void setContentLength(LongAssert<?> contentLength);
}
