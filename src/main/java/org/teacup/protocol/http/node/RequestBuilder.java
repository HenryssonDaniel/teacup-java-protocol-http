package org.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.NodeBuilder;
import io.github.henryssondaniel.teacup.core.assertion.BooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.ComparableAssert;
import io.github.henryssondaniel.teacup.core.assertion.MapAssert;
import io.github.henryssondaniel.teacup.core.assertion.StringAssert;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.util.List;

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
  RequestBuilder setExpectContinue(BooleanAssert<?> expectContinue);

  /**
   * Sets the headers.
   *
   * @param headers the headers
   * @return the request builder
   */
  RequestBuilder setHeaders(MapAssert<String, List<String>, ?> headers);

  /**
   * Sets the method.
   *
   * @param method the method
   * @return the request builder
   */
  RequestBuilder setMethod(StringAssert<?> method);

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
  RequestBuilder setVersion(ComparableAssert<? super Version, ?> version);
}
