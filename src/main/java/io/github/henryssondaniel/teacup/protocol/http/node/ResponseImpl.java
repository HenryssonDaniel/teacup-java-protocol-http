package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.Node;
import io.github.henryssondaniel.teacup.core.assertion.GenericComparableAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericMapAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import java.net.URI;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSession;

class ResponseImpl<T> extends SetterImpl<HttpResponse<T>> implements ResponseSetter<T> {
  private static final Logger LOGGER = Logger.getLogger(ResponseImpl.class.getName());

  private GenericObjectAssert<? super T, ?> body;
  private GenericObjectAssert<? super Map<String, List<String>>, ?> headers;
  private Node<HttpResponse<T>> previousResponse;
  private Node<HttpRequest> request;
  private Node<SSLSession> sslSession;
  private GenericObjectAssert<Integer, ?> statusCode;
  private Node<URI> uri;
  private GenericObjectAssert<? super Version, ?> version;

  @Override
  public void setBody(GenericObjectAssert<? super T, ?> body) {
    this.body = body;
  }

  @Override
  public void setHeaders(
      GenericMapAssert<String, List<String>, ? super Map<String, List<String>>, ?> headers) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "headers");
    this.headers = headers;
  }

  @Override
  public void setPreviousResponse(Response<T> previousResponse) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "previous response");
    this.previousResponse = previousResponse;
  }

  @Override
  public void setRequest(Request request) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "request");
    this.request = request;
  }

  @Override
  public void setSslSession(SslSession sslSession) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "SSL session");
    this.sslSession = sslSession;
  }

  @Override
  public void setStatusCode(GenericIntegerAssert<?> statusCode) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "status code");
    this.statusCode = statusCode;
  }

  @Override
  public void setUri(Uri uri) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "URI");
    this.uri = uri;
  }

  @Override
  public void setVersion(GenericComparableAssert<? super Version, ?> version) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "version");
    this.version = version;
  }

  @Override
  public void verify(HttpResponse<T> httpResponse) {
    LOGGER.log(Level.FINE, Constants.VERIFY, "HTTP response");

    verifyAssertion(httpResponse, getAssertion());
    verifyBody(httpResponse);
    verifyHeaders(httpResponse);
    verifyRequest(httpResponse);
    verifyPreviousResponse(httpResponse);
    verifySslSession(httpResponse);
    verifyStatusCode(httpResponse);
    verifyUri(httpResponse);
    verifyVersion(httpResponse);
  }

  private void verifyAssertion(
      HttpResponse<T> httpResponse, GenericObjectAssert<? super HttpResponse<T>, ?> objectAssert) {
    if (objectAssert != null) objectAssert.verify(httpResponse);
  }

  private void verifyBody(HttpResponse<? extends T> httpResponse) {
    if (body != null) body.verify(httpResponse.body());
  }

  private void verifyHeaders(HttpResponse<T> httpResponse) {
    if (headers != null) headers.verify(httpResponse.headers().map());
  }

  private void verifyPreviousResponse(HttpResponse<T> httpResponse) {
    if (previousResponse != null)
      previousResponse.verify(httpResponse.previousResponse().orElse(null));
  }

  private void verifyRequest(HttpResponse<T> httpResponse) {
    if (request != null) request.verify(httpResponse.request());
  }

  private void verifySslSession(HttpResponse<T> httpResponse) {
    if (sslSession != null) sslSession.verify(httpResponse.sslSession().orElse(null));
  }

  private void verifyStatusCode(HttpResponse<T> httpResponse) {
    if (statusCode != null) statusCode.verify(httpResponse.statusCode());
  }

  private void verifyUri(HttpResponse<T> httpResponse) {
    if (uri != null) uri.verify(httpResponse.uri());
  }

  private void verifyVersion(HttpResponse<T> httpResponse) {
    if (version != null) version.verify(httpResponse.version());
  }
}
