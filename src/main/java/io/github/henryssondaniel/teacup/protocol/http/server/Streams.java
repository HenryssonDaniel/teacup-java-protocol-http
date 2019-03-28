package io.github.henryssondaniel.teacup.protocol.http.server;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Streams.
 *
 * @since 1.0
 */
public interface Streams {
  /**
   * Returns the input stream.
   *
   * @return the input stream
   */
  InputStream getInputStream();

  /**
   * Returns the output stream.
   *
   * @return the output stream
   */
  OutputStream getOutputStream();
}
