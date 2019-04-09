package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericLongAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import java.net.http.HttpRequest;

interface BodyPublisherSetter
    extends BodyPublisher,
        Setter<HttpRequest.BodyPublisher, GenericObjectAssert<HttpRequest.BodyPublisher, ?>> {
  void setContentLength(GenericLongAssert<?> contentLength);
}
