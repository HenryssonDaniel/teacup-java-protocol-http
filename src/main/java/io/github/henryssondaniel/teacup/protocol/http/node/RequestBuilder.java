package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.NodeBuilder;
import io.github.henryssondaniel.teacup.core.assertion.GenericBooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericComparableAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericMapAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.Map;

/**
 * Request builder.
 *
 * @since 1.0
 */
public interface RequestBuilder extends NodeBuilder<HttpRequest, Request, RequestBuilder> {
  /**
   * Sets the body publisher.
   *
   * @param bodyPublisher the body publisher
   * @return the request builder
   */
  RequestBuilder setBodyPublisher(BodyPublisher bodyPublisher);

  /**
   * Sets whether expect continue or not.
   *
   * @param expectContinue whether expect continue or not
   * @return the request builder
   */
  RequestBuilder setExpectContinue(GenericBooleanAssert<?> expectContinue);

  /**
   * Sets the headers.
   *
   * @param headers the headers
   * @return the request builder
   */
  RequestBuilder setHeaders(
      GenericMapAssert<String, List<String>, ? super Map<String, List<String>>, ?> headers);

  /**
   * Sets the method.
   *
   * @param method the method
   * @return the request builder
   */
  RequestBuilder setMethod(GenericStringAssert<?> method);

  /**
   * Sets the timeout.
   *
   * @param timeout the timeout
   * @return the request builder
   */
  RequestBuilder setTimeout(Duration timeout);

  /**
   * Sets the URI.
   *
   * @param uri the URI
   * @return the request builder
   */
  RequestBuilder setUri(Uri uri);

  /**
   * Sets the version.
   *
   * @param version the version
   * @return the request builder
   */
  RequestBuilder setVersion(GenericComparableAssert<? super Version, ?> version);
}
