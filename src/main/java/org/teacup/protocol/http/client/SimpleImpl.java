package org.teacup.protocol.http.client;

import static org.teacup.protocol.http.Constants.ERROR_FETCH;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;

class SimpleImpl implements Simple {
  private static final Logger LOGGER = Logger.getLogger(SimpleImpl.class.getName());
  private static final String SEND = "Sending request%s";

  private final HttpClient httpClient;

  SimpleImpl(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  @Override
  public <T> HttpResponse<T> send(Handler<T> handler, HttpRequest httpRequest)
      throws IOException, InterruptedException {
    LOGGER.log(Level.FINE, String.format(SEND, ""));
    logRequest(httpRequest);

    try {
      var httpResponse = httpClient.send(httpRequest, handler.getBodyHandler());
      logResponse(httpResponse, null);
      return httpResponse;
    } catch (IOException | InterruptedException e) {
      LOGGER.log(Level.SEVERE, "Failed to send the request", e);
      throw e;
    }
  }

  @Override
  public <T> CompletableFuture<HttpResponse<T>> sendAsynchronously(
      Handler<T> handler, HttpRequest httpRequest) {
    LOGGER.log(Level.FINE, String.format(SEND, " asynchronously"));
    logRequest(httpRequest);

    var bodyHandler = handler.getBodyHandler();
    var pushPromiseHandler = handler.getPushPromiseHandler();

    return (pushPromiseHandler == null
            ? httpClient.sendAsync(httpRequest, bodyHandler)
            : httpClient.sendAsync(httpRequest, bodyHandler, pushPromiseHandler))
        .whenComplete(SimpleImpl::logResponse);
  }

  private static String getHttpRequest(HttpRequest httpRequest) {
    return "Request:"
        + System.lineSeparator()
        + "Body publisher: "
        + httpRequest.bodyPublisher().orElse(null)
        + System.lineSeparator()
        + "Expect continue: "
        + httpRequest.expectContinue()
        + System.lineSeparator()
        + "Headers: "
        + httpRequest.headers()
        + System.lineSeparator()
        + "Method: "
        + httpRequest.method()
        + System.lineSeparator()
        + "Timeout: "
        + httpRequest.timeout().orElse(null)
        + System.lineSeparator()
        + "URI: "
        + httpRequest.uri()
        + System.lineSeparator()
        + "Version: "
        + httpRequest.version().orElse(null);
  }

  private static <T> String getHttpResponse(HttpResponse<T> httpResponse, String response) {
    var stringBuilder = new StringBuilder(0);

    if (httpResponse != null)
      stringBuilder
          .append(response)
          .append("Body: ")
          .append(httpResponse.body())
          .append(System.lineSeparator())
          .append("Headers: ")
          .append(httpResponse.headers())
          .append(System.lineSeparator())
          .append("Previous response:")
          .append(
              getHttpResponse(httpResponse.previousResponse().orElse(null), System.lineSeparator()))
          .append(System.lineSeparator())
          .append(getHttpRequest(httpResponse.request()))
          .append(System.lineSeparator())
          .append(getSslSession(httpResponse.sslSession().orElse(null)))
          .append(System.lineSeparator())
          .append("Status code: ")
          .append(httpResponse.statusCode())
          .append(System.lineSeparator())
          .append("URI: ")
          .append(httpResponse.uri())
          .append(System.lineSeparator())
          .append("Version: ")
          .append(httpResponse.version());

    return stringBuilder.toString();
  }

  private static String getPeerPrincipal(SSLSession sslSession) {
    var peerPrincipal = new StringBuilder(System.lineSeparator() + "Peer principal: ");

    try {
      peerPrincipal.append(sslSession.getPeerPrincipal());
    } catch (SSLPeerUnverifiedException e) {
      LOGGER.log(Level.SEVERE, String.format(ERROR_FETCH, "principal"), e);
    }

    return peerPrincipal.toString();
  }

  private static String getSessionContext(SSLSessionContext sslSessionContext) {
    return System.lineSeparator()
        + "Session context:"
        + System.lineSeparator()
        + "Session cache size: "
        + sslSessionContext.getSessionCacheSize()
        + System.lineSeparator()
        + "Session timeout: "
        + sslSessionContext.getSessionTimeout();
  }

  private static String getSslSession(SSLSession sslSession) {
    var stringBuilder = new StringBuilder("SSL session:" + System.lineSeparator());

    if (sslSession != null)
      stringBuilder
          .append("Application bufferSize: ")
          .append(sslSession.getApplicationBufferSize())
          .append(System.lineSeparator())
          .append("Cipher suite: ")
          .append(sslSession.getCipherSuite())
          .append(System.lineSeparator())
          .append("Creation time: ")
          .append(sslSession.getCreationTime())
          .append(System.lineSeparator())
          .append("ID: ")
          .append(Arrays.toString(sslSession.getId()))
          .append(System.lineSeparator())
          .append("Last accessed time: ")
          .append(sslSession.getLastAccessedTime())
          .append(System.lineSeparator())
          .append("Local certificates: ")
          .append(Arrays.toString(sslSession.getLocalCertificates()))
          .append(System.lineSeparator())
          .append("Local principal: ")
          .append(sslSession.getLocalPrincipal())
          .append(System.lineSeparator())
          .append("Packed buffer size: ")
          .append(sslSession.getPacketBufferSize())
          .append(System.lineSeparator())
          .append("Peer host: ")
          .append(sslSession.getPeerHost())
          .append(System.lineSeparator())
          .append("Peer port: ")
          .append(sslSession.getPeerPort())
          .append(getPeerPrincipal(sslSession))
          .append(System.lineSeparator())
          .append("Protocol: ")
          .append(sslSession.getProtocol())
          .append(getSessionContext(sslSession.getSessionContext()))
          .append(getValues(sslSession))
          .append(System.lineSeparator())
          .append("Valid: ")
          .append(sslSession.isValid());

    return stringBuilder.toString();
  }

  private static String getValues(SSLSession sslSession) {
    var stringBuilder = new StringBuilder(System.lineSeparator() + "Values: ");
    Arrays.stream(sslSession.getValueNames())
        .forEach(
            name ->
                stringBuilder
                    .append(System.lineSeparator())
                    .append("Value: ")
                    .append(sslSession.getValue(name)));

    return stringBuilder.toString();
  }

  private static void logRequest(HttpRequest httpRequest) {
    LOGGER.log(Level.INFO, getHttpRequest(httpRequest));
  }

  private static <T> void logResponse(HttpResponse<T> httpResponse, Throwable throwable) {
    if (throwable == null) LOGGER.log(Level.INFO, getHttpResponse(httpResponse, ""));
    else LOGGER.log(Level.SEVERE, "An exception occurred while sending the request", throwable);
  }
}
