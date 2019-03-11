package org.teacup.protocol.http;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

/**
 * An HTTP Client.
 *
 * @since 1.0
 */
public interface Client {
  /**
   * Send an HTTP request.
   *
   * @param handler the handler
   * @param httpRequest the HTTP request
   * @param <T> the response body type
   * @return the HTTP response
   * @throws IOException if an IO problem occur
   * @throws InterruptedException if interrupted
   */
  <T> HttpResponse<T> send(Handler<T> handler, HttpRequest httpRequest)
      throws IOException, InterruptedException;

  /**
   * Send an HTTP request asynchronously.
   *
   * @param handler the handler
   * @param httpRequest the HTTP request
   * @param <T> the response body type
   * @return the HTTP response
   */
  <T> CompletableFuture<HttpResponse<T>> sendAsynchronously(
      Handler<T> handler, HttpRequest httpRequest);
}
