package org.teacup.protocol.http.server;

import java.util.List;
import java.util.Map;

/**
 * An outgoing response from the server.
 *
 * @since 1.0
 */
public interface Response {
  /**
   * Returns the attributes.
   *
   * @return the attributes
   */
  Map<String, Object> getAttributes();

  /**
   * Returns the body.
   *
   * @return the body
   */
  byte[] getBody();

  /**
   * Returns the code.
   *
   * @return the code
   */
  int getCode();

  /**
   * Returns the headers.
   *
   * @return the headers
   */
  Map<String, List<String>> getHeaders();

  /**
   * Returns the length.
   *
   * @return the length
   */
  long getLength();

  /**
   * Returns the streams.
   *
   * @return the streams
   */
  Streams getStreams();
}
