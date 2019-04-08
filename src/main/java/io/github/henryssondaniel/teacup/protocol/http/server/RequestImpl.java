package io.github.henryssondaniel.teacup.protocol.http.server;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpPrincipal;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

class RequestImpl implements RequestSetter {
  private static final Logger LOGGER = Logger.getLogger(RequestImpl.class.getName());
  private static final String MESSAGE = "{0}etting the headers";

  private final Map<String, List<String>> headers = new Headers();

  private String body;
  private HttpContext httpContext;
  private HttpPrincipal httpPrincipal;
  private InetSocketAddress localAddress;
  private String method;
  private String protocol;
  private InetSocketAddress remoteAddress;
  private URI uri;

  @Override
  public String getBody() {
    return body;
  }

  @Override
  public Headers getHeaders() {
    LOGGER.log(Level.FINE, MESSAGE, "G");

    var newHeaders = new Headers();
    newHeaders.putAll(headers);

    return newHeaders;
  }

  @Override
  public HttpContext getHttpContext() {
    return httpContext;
  }

  @Override
  public HttpPrincipal getHttpPrincipal() {
    return httpPrincipal;
  }

  @Override
  public InetSocketAddress getLocalAddress() {
    return localAddress;
  }

  @Override
  public String getMethod() {
    return method;
  }

  @Override
  public String getProtocol() {
    return protocol;
  }

  @Override
  public InetSocketAddress getRemoteAddress() {
    return remoteAddress;
  }

  @Override
  public URI getURI() {
    return uri;
  }

  @Override
  public void setBody(String body) {
    this.body = body;
  }

  @Override
  public void setHeaders(Headers headers) {
    LOGGER.log(Level.FINE, MESSAGE, "S");

    this.headers.clear();
    this.headers.putAll(headers);
  }

  @Override
  public void setHttpContext(HttpContext httpContext) {
    this.httpContext = httpContext;
  }

  @Override
  public void setHttpPrincipal(HttpPrincipal httpPrincipal) {
    this.httpPrincipal = httpPrincipal;
  }

  @Override
  public void setLocalAddress(InetSocketAddress localAddress) {
    this.localAddress = localAddress;
  }

  @Override
  public void setMethod(String method) {
    this.method = method;
  }

  @Override
  public void setProtocol(String protocol) {
    this.protocol = protocol;
  }

  @Override
  public void setRemoteAddress(InetSocketAddress remoteAddress) {
    this.remoteAddress = remoteAddress;
  }

  @Override
  public void setUri(URI uri) {
    this.uri = uri;
  }
}
