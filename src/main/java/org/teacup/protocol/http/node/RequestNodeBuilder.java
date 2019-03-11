package org.teacup.protocol.http.node;

import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.util.List;
import org.teacup.core.NodeBuilder;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.ComparableAssert;
import org.teacup.core.assertion.MapAssert;
import org.teacup.core.assertion.StringAssert;

/**
 * Request node builder.
 *
 * @since 1.0
 */
public interface RequestNodeBuilder
    extends NodeBuilder<HttpRequest, RequestNode, RequestNodeBuilder> {
  /**
   * Sets the body publisher.
   *
   * @param bodyPublisher the body publisher
   * @return the request node builder
   */
  RequestNodeBuilder setBodyPublisher(BodyPublisherNode bodyPublisher);

  /**
   * Sets whether expect continue or not.
   *
   * @param expectContinue whether expect continue or not
   * @return the request node builder
   */
  RequestNodeBuilder setExpectContinue(BooleanAssert expectContinue);

  /**
   * Sets the headers.
   *
   * @param headers the headers
   * @return the request node builder
   */
  RequestNodeBuilder setHeaders(MapAssert<String, List<String>, ?> headers);

  /**
   * Sets the method.
   *
   * @param method the method
   * @return the request node builder
   */
  RequestNodeBuilder setMethod(StringAssert method);

  /**
   * Sets the timeout.
   *
   * @param timeout the timeout
   * @return the request node builder
   */
  RequestNodeBuilder setTimeout(DurationNode timeout);

  /**
   * Sets the URI.
   *
   * @param uri the URI
   * @return the request node builder
   */
  RequestNodeBuilder setUri(UriNode uri);

  /**
   * Sets the version.
   *
   * @param version the version
   * @return the request node builder
   */
  RequestNodeBuilder setVersion(ComparableAssert<? super Version, ?> version);
}
