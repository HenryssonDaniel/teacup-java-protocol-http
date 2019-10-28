package io.github.henryssondaniel.teacup.protocol.http.server;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpPrincipal;
import java.net.InetSocketAddress;
import java.net.URI;

/**
 * An incoming request to the server.
 *
 * @since 1.0
 */
public interface Request extends io.github.henryssondaniel.teacup.protocol.server.Request {
  /**
   * Returns the body.
   *
   * @return the body
   */
  String getBody();

  /**
   * Returns the headers.
   *
   * @return the headers
   */
  Headers getHeaders();

  /**
   * Returns the HTTP context.
   *
   * @return the HTTP context
   */
  HttpContext getHttpContext();

  /**
   * Returns the HTTP principal.
   *
   * @return the HTTP principal
   */
  HttpPrincipal getHttpPrincipal();

  /**
   * Returns the local address.
   *
   * @return the local address
   */
  InetSocketAddress getLocalAddress();

  /**
   * Returns the method.
   *
   * @return the method
   */
  String getMethod();

  /**
   * Returns the protocol.
   *
   * @return the protocol
   */
  String getProtocol();

  /**
   * Returns the remote address.
   *
   * @return the remote address
   */
  InetSocketAddress getRemoteAddress();

  /**
   * Returns the URI.
   *
   * @return the URI
   */
  URI getURI();
}
