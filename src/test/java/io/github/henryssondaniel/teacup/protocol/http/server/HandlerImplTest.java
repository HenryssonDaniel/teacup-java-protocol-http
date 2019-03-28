package io.github.henryssondaniel.teacup.protocol.http.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import org.junit.jupiter.api.Test;

class HandlerImplTest {
  private final Headers headers = mock(Headers.class);
  private final HttpExchange httpExchange = mock(HttpExchange.class);
  private final Response response = mock(Response.class);
  private final TimeoutSupplier timeoutSupplier = mock(TimeoutSupplier.class);
  private final Handler handler = new HandlerImpl(response, timeoutSupplier);

  @Test
  void addAndGetTimeoutSupplier() {
    handler.addTimeoutSupplier(timeoutSupplier);
    assertThat(handler.getTimeoutSuppliers()).containsExactly(timeoutSupplier, timeoutSupplier);
  }

  @Test
  void getResponse() {
    assertThat(handler.getResponse()).isSameAs(response);
  }

  @Test
  void getTimeoutSuppliers() {
    assertThat(handler.getTimeoutSuppliers()).containsExactly(timeoutSupplier);
  }

  @Test
  void handle() throws IOException {
    var streams = mock(Streams.class);

    try (InputStream inputStream =
        new ByteArrayInputStream("test".getBytes(Charset.defaultCharset()))) {
      setupResponse(streams);

      setupHttpExchange(inputStream);
      when(httpExchange.getResponseHeaders()).thenReturn(headers);

      handler.handle(httpExchange);
    }

    verify(httpExchange).getResponseHeaders();
    verify(httpExchange).setStreams(streams.getInputStream(), streams.getOutputStream());
    verify(response, never()).getBody();

    verifyHandle();
  }

  @Test
  void handleWhenMinimal() throws IOException {
    var inputStream = mock(InputStream.class);
    setupHttpExchange(inputStream);
    handler.handle(httpExchange);

    verify(httpExchange, never()).getResponseHeaders();
    verify(httpExchange, never()).setStreams(any(), any());
    verify(response).getBody();

    verifyHandle();
  }

  @Test
  void removeAndGetTimeoutSupplier() {
    handler.removeTimeoutSupplier(timeoutSupplier);
    assertThat(handler.getTimeoutSuppliers()).isEmpty();
  }

  private void setupHttpExchange(InputStream inputStream) {
    var httpServer = mock(HttpServer.class);

    var httpContext = mock(HttpContext.class);
    when(httpContext.getServer()).thenReturn(httpServer);

    when(httpExchange.getHttpContext()).thenReturn(httpContext);
    when(httpExchange.getRequestHeaders()).thenReturn(headers);

    var outputStream = mock(OutputStream.class);

    try (var input = httpExchange.getRequestBody()) {
      when(input).thenReturn(inputStream);
    } catch (IOException e) {
      fail(e);
    }

    try (var output = httpExchange.getResponseBody()) {
      when(output).thenReturn(outputStream);
    } catch (IOException e) {
      fail(e);
    }
  }

  private void setupResponse(Streams streams) {
    when(response.getHeaders()).thenReturn(headers);
    when(response.getLength()).thenReturn(-1L);
    when(response.getStreams()).thenReturn(streams);
  }

  private void verifyHandle() throws IOException {
    verify(timeoutSupplier).addRequest(any());
    verify(httpExchange).sendResponseHeaders(response.getCode(), response.getLength());
    verify(httpExchange).close();
  }
}
