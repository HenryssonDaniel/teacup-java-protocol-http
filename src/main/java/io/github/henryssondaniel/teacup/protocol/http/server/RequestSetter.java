package io.github.henryssondaniel.teacup.protocol.http.server;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpPrincipal;
import java.net.InetSocketAddress;
import java.net.URI;

interface RequestSetter extends Request {
  void setBody(String body);

  void setHeaders(Headers headers);

  void setHttpContext(HttpContext httpContext);

  void setHttpPrincipal(HttpPrincipal httpPrincipal);

  void setLocalAddress(InetSocketAddress localAddress);

  void setMethod(String method);

  void setProtocol(String protocol);

  void setRemoteAddress(InetSocketAddress remoteAddress);

  void setUri(URI uri);
}
