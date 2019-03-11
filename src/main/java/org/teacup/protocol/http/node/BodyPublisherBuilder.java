package org.teacup.protocol.http.node;

import java.net.http.HttpRequest;
import org.teacup.core.NodeBuilder;
import org.teacup.core.assertion.LongAssert;

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
  BodyPublisherBuilder setContentLength(LongAssert contentLength);
}
