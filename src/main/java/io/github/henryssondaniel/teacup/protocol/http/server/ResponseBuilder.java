package io.github.henryssondaniel.teacup.protocol.http.server;

import io.github.henryssondaniel.teacup.protocol.Builder;
import java.util.List;
import java.util.Map;

/**
 * Response builder.
 *
 * @since 1.0
 */
public interface ResponseBuilder extends Builder<Response> {
  /**
   * Sets the attributes.
   *
   * @param attributes the attributes
   * @return the response builder
   */
  ResponseBuilder setAttributes(Map<String, Object> attributes);

  /**
   * Sets the body.
   *
   * @param body the body
   * @return the response builder
   */
  ResponseBuilder setBody(byte... body);

  /**
   * Sets the headers.
   *
   * @param headers the headers
   * @return the response builder
   */
  ResponseBuilder setHeaders(Map<String, ? extends List<String>> headers);

  /**
   * Sets the streams.
   *
   * @param streams the streams
   * @return the response builder
   */
  ResponseBuilder setStreams(Streams streams);
}
