package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.NodeBuilder;
import io.github.henryssondaniel.teacup.core.assertion.ComparableAssert;
import io.github.henryssondaniel.teacup.core.assertion.IntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.MapAssert;
import io.github.henryssondaniel.teacup.core.assertion.ObjectAssert;
import java.net.http.HttpClient.Version;
import java.net.http.HttpResponse;
import java.util.List;

/**
 * Response builder.
 *
 * @param <T> the response body type
 * @since 1.0
 */
public interface ResponseBuilder<T>
    extends NodeBuilder<HttpResponse<T>, Response<T>, ResponseBuilder<T>> {
  /**
   * Sets the body.
   *
   * @param body the body
   * @return the response builder
   */
  ResponseBuilder<T> setBody(ObjectAssert<? super T, ?> body);

  /**
   * Sets the headers.
   *
   * @param headers the headers
   * @return the response builder
   */
  ResponseBuilder<T> setHeaders(MapAssert<String, List<String>, ?> headers);

  /**
   * Sets the previous response.
   *
   * @param previousResponse the previous response
   * @return the response builder
   */
  ResponseBuilder<T> setPreviousResponse(Response<T> previousResponse);

  /**
   * Sets the request.
   *
   * @param request the request
   * @return the response builder
   */
  ResponseBuilder<T> setRequest(Request request);

  /**
   * Sets the SSL session.
   *
   * @param sslSession the SSL session
   * @return the response builder
   */
  ResponseBuilder<T> setSslSession(SslSession sslSession);

  /**
   * Sets the status code.
   *
   * @param statusCode the status code node
   * @return the response builder
   */
  ResponseBuilder<T> setStatusCode(IntegerAssert<?> statusCode);

  /**
   * Sets the URI node.
   *
   * @param uri URI node
   * @return the response builder
   */
  ResponseBuilder<T> setUri(Uri uri);

  /**
   * Sets the version.
   *
   * @param version the version
   * @return the response builder
   */
  ResponseBuilder<T> setVersion(ComparableAssert<? super Version, ?> version);
}
