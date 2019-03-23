package org.teacup.protocol.http.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.teacup.core.Server;

/**
 * Factory.
 *
 * @since 1.0
 */
public enum Factory {
  ;

  private static final Logger LOGGER = Logger.getLogger(Factory.class.getName());

  /**
   * Creates a new context builder.
   *
   * @param path the path
   * @param response the response
   * @return the context builder
   */
  public static ContextBuilder createContextBuilder(String path, Response response) {
    LOGGER.log(Level.FINE, "Creating a new context builder with path: " + path);
    return new ContextBuilderImpl(path, response);
  }

  /**
   * Creates a new response builder.
   *
   * @param code the code
   * @param length the length
   * @return the response builder
   */
  public static ResponseBuilder createResponseBuilder(int code, long length) {
    LOGGER.log(
        Level.FINE, "Creating a new context builder with code: " + code + " and length: " + length);
    return new ResponseBuilderImpl(code, length);
  }

  /**
   * Creates a new server.
   *
   * @param backlog the backlog
   * @param host the host
   * @param port the port
   * @return the server
   */
  public static Server createServer(int backlog, String host, int port) {
    LOGGER.log(
        Level.FINE,
        "Creating a new server with backlog: "
            + backlog
            + ", host: "
            + host
            + " and port: "
            + port);
    return new SimpleImpl(backlog, host, port);
  }

  /**
   * Creates new streams.
   *
   * @param inputStream the input stream
   * @param outputStream the output stream
   * @return the streams
   */
  public static Streams createStreams(InputStream inputStream, OutputStream outputStream) {
    LOGGER.log(Level.FINE, "Creating new streams");
    return new StreamsImpl(inputStream, outputStream);
  }
}
