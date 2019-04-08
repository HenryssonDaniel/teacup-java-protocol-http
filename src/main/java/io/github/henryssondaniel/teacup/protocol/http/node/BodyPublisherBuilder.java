package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.NodeBuilder;
import io.github.henryssondaniel.teacup.core.assertion.GenericLongAssert;
import java.net.http.HttpRequest;

/**
 * Body publisher builder.
 *
 * @since 1.0
 */
public interface BodyPublisherBuilder
    extends NodeBuilder<HttpRequest.BodyPublisher, BodyPublisher, BodyPublisherBuilder> {
  /**
   * Sets the content length.
   *
   * @param contentLength the content length
   * @return the body publisher builder
   */
  BodyPublisherBuilder setContentLength(GenericLongAssert<?> contentLength);
}
