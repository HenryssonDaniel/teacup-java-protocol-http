package org.teacup.protocol.http.node;

import java.net.http.HttpClient.Version;
import java.net.http.HttpResponse;
import java.util.List;
import org.teacup.core.NodeBuilder;
import org.teacup.core.assertion.ComparableAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.MapAssert;
import org.teacup.core.assertion.ObjectAssert;

/**
 * Response node builder.
 *
 * @param <T> the response body type
 * @since 1.0
 */
public interface ResponseNodeBuilder<T>
    extends NodeBuilder<HttpResponse<T>, ResponseNode<T>, ResponseNodeBuilder<T>> {
  /**
   * Sets the body.
   *
   * @param body the body
   * @return the response node builder
   */
  ResponseNodeBuilder<T> setBody(ObjectAssert<? super T, ?> body);

  /**
   * Sets the headers.
   *
   * @param headers the headers
   * @return the response node builder
   */
  ResponseNodeBuilder<T> setHeaders(MapAssert<String, List<String>, ?> headers);

  /**
   * Sets the previous response.
   *
   * @param previousResponse the previous response
   * @return the response node builder
   */
  ResponseNodeBuilder<T> setPreviousResponse(ResponseNode<T> previousResponse);

  /**
   * Sets the request.
   *
   * @param request the request
   * @return the response node builder
   */
  ResponseNodeBuilder<T> setRequest(RequestNode request);

  /**
   * Sets the SSL session.
   *
   * @param sslSession the SSL session
   * @return the response node builder
   */
  ResponseNodeBuilder<T> setSslSession(SslSessionNode sslSession);

  /**
   * Sets the status code.
   *
   * @param statusCode the status code node
   * @return the response node builder
   */
  ResponseNodeBuilder<T> setStatusCode(IntegerAssert statusCode);

  /**
   * Sets the URI node.
   *
   * @param node the URI node
   * @return the response node builder
   */
  ResponseNodeBuilder<T> setUri(UriNode node);

  /**
   * Sets the version.
   *
   * @param version the version
   * @return the response node builder
   */
  ResponseNodeBuilder<T> setVersion(ComparableAssert<? super Version, ?> version);
}
