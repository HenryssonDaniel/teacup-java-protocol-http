package org.teacup.protocols.http;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIOException;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.PushPromiseHandler;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ClientImplTest {
  private static final String MESSAGE = "test";
  private static final String NAME = "name";

  private final HttpClient httpClient = mock(HttpClient.class);
  private final HttpRequest httpRequest = mock(HttpRequest.class);
  private final SSLSession sslSession = mock(SSLSession.class);

  @Mock private BodyHandler<String> bodyHandler;
  private Client client;
  private CompletableFuture<HttpResponse<String>> completableFuture;
  @Mock private Handler<String> handler;
  @Mock private HttpResponse<String> httpResponse;
  @Mock private PushPromiseHandler<String> pushPromiseHandler;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);

    when(handler.getBodyHandler()).thenReturn(bodyHandler);
    when(httpResponse.request()).thenReturn(httpRequest);

    setupSslSession();

    completableFuture = CompletableFuture.supplyAsync(() -> httpResponse);
    client = new ClientImpl(httpClient);
  }

  @Test
  void send() throws IOException, InterruptedException {
    when(httpClient.send(httpRequest, bodyHandler)).thenReturn(httpResponse);
    assertThat(client.send(handler, httpRequest)).isSameAs(httpResponse);
  }

  @Test
  void sendAsynchronously() {
    when(httpClient.sendAsync(httpRequest, bodyHandler)).thenReturn(completableFuture);
    assertThat(client.sendAsynchronously(handler, httpRequest)).isCompletedWithValue(httpResponse);
  }

  @Test
  void sendAsynchronouslyWhenError() throws InterruptedException {
    completableFuture =
        CompletableFuture.supplyAsync(
            () -> {
              throw new ArithmeticException(MESSAGE);
            });
    when(httpClient.sendAsync(httpRequest, bodyHandler)).thenReturn(completableFuture);

    var future = client.sendAsynchronously(handler, httpRequest);

    try {
      future.get();
      fail("The expected exception was not thrown.");
    } catch (ExecutionException ignore) {
      assertThat(future).isCompletedExceptionally();
    }
  }

  @Test
  void sendAsynchronouslyWithPushPromiseHandler() {
    when(handler.getPushPromiseHandler()).thenReturn(pushPromiseHandler);
    when(httpClient.sendAsync(httpRequest, bodyHandler, pushPromiseHandler))
        .thenReturn(completableFuture);

    assertThat(client.sendAsynchronously(handler, httpRequest)).isCompletedWithValue(httpResponse);
  }

  @Test
  void sendAsynchronouslyWithSsl() {
    when(httpClient.sendAsync(httpRequest, bodyHandler)).thenReturn(completableFuture);
    when(httpResponse.sslSession()).thenReturn(Optional.of(sslSession));

    assertThat(client.sendAsynchronously(handler, httpRequest)).isCompletedWithValue(httpResponse);
  }

  @Test
  void sendAsynchronouslyWithSslError() throws SSLPeerUnverifiedException {
    when(httpClient.sendAsync(httpRequest, bodyHandler)).thenReturn(completableFuture);
    when(httpResponse.sslSession()).thenReturn(Optional.of(sslSession));
    when(sslSession.getPeerPrincipal()).thenThrow(new SSLPeerUnverifiedException(MESSAGE));

    assertThat(client.sendAsynchronously(handler, httpRequest)).isCompletedWithValue(httpResponse);
  }

  @Test
  void sendWhenIOException() throws IOException, InterruptedException {
    when(httpClient.send(httpRequest, bodyHandler)).thenThrow(new IOException(MESSAGE));
    assertThatIOException()
        .isThrownBy(() -> client.send(handler, httpRequest))
        .withMessage(MESSAGE);
  }

  private void setupSslSession() {
    var sslSessionContext = mock(SSLSessionContext.class);

    when(sslSession.getSessionContext()).thenReturn(sslSessionContext);
    when(sslSession.getValue(NAME)).thenReturn("value");
    when(sslSession.getValueNames()).thenReturn(new String[] {NAME});
  }
}
