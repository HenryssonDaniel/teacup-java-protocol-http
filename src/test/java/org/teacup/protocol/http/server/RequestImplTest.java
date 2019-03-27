package org.teacup.protocol.http.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpPrincipal;
import java.net.InetSocketAddress;
import java.net.URI;
import org.junit.jupiter.api.Test;

class RequestImplTest {
  private final InetSocketAddress inetSocketAddress = mock(InetSocketAddress.class);
  private final RequestSetter requestSetter = new RequestImpl();

  @Test
  void getBody() {
    assertThat(requestSetter.getBody()).isNull();
  }

  @Test
  void getHeaders() {
    assertThat(requestSetter.getHeaders()).isEmpty();
  }

  @Test
  void getHttpContext() {
    assertThat(requestSetter.getHttpContext()).isNull();
  }

  @Test
  void getHttpPrincipal() {
    assertThat(requestSetter.getHttpPrincipal()).isNull();
  }

  @Test
  void getLocalAddress() {
    assertThat(requestSetter.getLocalAddress()).isNull();
  }

  @Test
  void getMethod() {
    assertThat(requestSetter.getMethod()).isNull();
  }

  @Test
  void getProtocol() {
    assertThat(requestSetter.getProtocol()).isNull();
  }

  @Test
  void getRemoteAddress() {
    assertThat(requestSetter.getRemoteAddress()).isNull();
  }

  @Test
  void getURI() {
    assertThat(requestSetter.getURI()).isNull();
  }

  @Test
  void setAndGetBody() {
    var body = "body";
    requestSetter.setBody(body);
    assertThat(requestSetter.getBody()).isSameAs(body);
  }

  @Test
  void setAndGetHeaders() {
    var headers = mock(Headers.class);
    requestSetter.setHeaders(headers);
    assertThat(requestSetter.getHeaders()).isEqualTo(headers);
  }

  @Test
  void setAndGetHttpContext() {
    var httpContext = mock(HttpContext.class);
    requestSetter.setHttpContext(httpContext);
    assertThat(requestSetter.getHttpContext()).isSameAs(httpContext);
  }

  @Test
  void setAndGetHttpPrincipal() {
    var httpPrincipal = mock(HttpPrincipal.class);
    requestSetter.setHttpPrincipal(httpPrincipal);
    assertThat(requestSetter.getHttpPrincipal()).isSameAs(httpPrincipal);
  }

  @Test
  void setAndGetLocalAddress() {
    requestSetter.setLocalAddress(inetSocketAddress);
    assertThat(requestSetter.getLocalAddress()).isSameAs(inetSocketAddress);
  }

  @Test
  void setAndGetMethod() {
    var method = "method";
    requestSetter.setMethod(method);
    assertThat(requestSetter.getMethod()).isSameAs(method);
  }

  @Test
  void setAndGetProtocol() {
    var protocol = "protocol";
    requestSetter.setProtocol(protocol);
    assertThat(requestSetter.getProtocol()).isSameAs(protocol);
  }

  @Test
  void setAndGetRemoteAddress() {
    requestSetter.setRemoteAddress(inetSocketAddress);
    assertThat(requestSetter.getRemoteAddress()).isSameAs(inetSocketAddress);
  }

  @Test
  void setAndGetURI() {
    var uri = URI.create("");
    requestSetter.setUri(uri);
    assertThat(requestSetter.getURI()).isSameAs(uri);
  }
}
