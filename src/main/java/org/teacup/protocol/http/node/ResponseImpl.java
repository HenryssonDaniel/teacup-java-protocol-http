package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.SETTING_THE;
import static org.teacup.protocol.http.node.Constants.VERIFY;

import java.net.URI;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSession;
import org.teacup.core.Node;
import org.teacup.core.assertion.ComparableAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.MapAssert;
import org.teacup.core.assertion.ObjectAssert;

class ResponseImpl<T> extends SetterImpl<HttpResponse<T>> implements ResponseSetter<T> {
  private static final Logger LOGGER = Logger.getLogger(ResponseImpl.class.getName());

  private ObjectAssert<? super T, ?> body;
  private ObjectAssert<Map<String, List<String>>, ?> headers;
  private Node<HttpResponse<T>> previousResponse;
  private Node<HttpRequest> request;
  private Node<SSLSession> sslSession;
  private ObjectAssert<Integer, IntegerAssert> statusCode;
  private Node<URI> uri;
  private ObjectAssert<? super Version, ?> version;

  @Override
  public void setBody(ObjectAssert<? super T, ?> body) {
    this.body = body;
  }

  @Override
  public void setHeaders(MapAssert<String, List<String>, ?> headers) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "headers"));
    this.headers = headers;
  }

  @Override
  public void setPreviousResponse(Response<T> previousResponse) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "previous response"));
    this.previousResponse = previousResponse;
  }

  @Override
  public void setRequest(Request request) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "request"));
    this.request = request;
  }

  @Override
  public void setSslSession(SslSession sslSession) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "SSL session"));
    this.sslSession = sslSession;
  }

  @Override
  public void setStatusCode(IntegerAssert statusCode) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "status code"));
    this.statusCode = statusCode;
  }

  @Override
  public void setUri(Uri uri) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "URI"));
    this.uri = uri;
  }

  @Override
  public void setVersion(ComparableAssert<? super Version, ?> version) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "version"));
    this.version = version;
  }

  @Override
  public void verify(HttpResponse<T> httpResponse) {
    LOGGER.log(Level.FINE, String.format(VERIFY, "HTTP response"));

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
      HttpResponse<T> httpResponse, ObjectAssert<? super HttpResponse<T>, ?> objectAssert) {
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
