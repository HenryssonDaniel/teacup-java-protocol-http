package org.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.LongAssert;
import java.net.http.HttpRequest;

interface BodyPublisherSetter extends BodyPublisher, Setter<HttpRequest.BodyPublisher> {
  void setContentLength(LongAssert<?> contentLength);
}
