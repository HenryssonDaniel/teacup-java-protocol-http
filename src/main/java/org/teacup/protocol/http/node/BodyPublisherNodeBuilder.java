package org.teacup.protocol.http.node;

import java.net.http.HttpRequest.BodyPublisher;
import org.teacup.core.NodeBuilder;
import org.teacup.core.assertion.LongAssert;

/**
 * Body publisher node builder.
 *
 * @since 1.0
 */
public interface BodyPublisherNodeBuilder
    extends NodeBuilder<BodyPublisher, BodyPublisherNode, BodyPublisherNodeBuilder> {
  /**
   * Sets the content length.
   *
   * @param contentLength the content lentth
   * @return the body publisher node builder
   */
  BodyPublisherNodeBuilder setContentLength(LongAssert contentLength);
}
