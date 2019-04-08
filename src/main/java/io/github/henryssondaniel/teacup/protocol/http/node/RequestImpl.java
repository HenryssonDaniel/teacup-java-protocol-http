package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.Node;
import io.github.henryssondaniel.teacup.core.assertion.GenericBooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericComparableAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericMapAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import java.net.URI;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

class RequestImpl extends SetterImpl<HttpRequest> implements RequestSetter {
  private static final Logger LOGGER = Logger.getLogger(RequestImpl.class.getName());

  private Node<HttpRequest.BodyPublisher> bodyPublisher;
  private GenericObjectAssert<Boolean, ?> expectContinue;
  private GenericObjectAssert<? super Map<String, List<String>>, ?> headers;
  private GenericObjectAssert<String, ?> method;
  private Node<java.time.Duration> timeout;
  private Node<URI> uri;
  private GenericObjectAssert<? super Version, ?> version;

  @Override
  public void setBodyPublisher(BodyPublisher bodyPublisher) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "body publisher");
    this.bodyPublisher = bodyPublisher;
  }

  @Override
  public void setExpectContinue(GenericBooleanAssert<?> expectContinue) {
    LOGGER.log(Level.FINE, Constants.SETTING_WHETHER, "expect continue");
    this.expectContinue = expectContinue;
  }

  @Override
  public void setHeaders(
      GenericMapAssert<String, List<String>, ? super Map<String, List<String>>, ?> headers) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "headers");
    this.headers = headers;
  }

  @Override
  public void setMethod(GenericStringAssert<?> method) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "method");
    this.method = method;
  }

  @Override
  public void setTimeout(Duration timeout) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "timeout");
    this.timeout = timeout;
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
  public void verify(HttpRequest httpRequest) {
    LOGGER.log(Level.FINE, Constants.VERIFY, "HTTP request");

    verifyAssertion(httpRequest, getAssertion());
    verifyBodyPublisher(httpRequest);
    verifyExpectContinue(httpRequest);
    verifyHeaders(httpRequest);
    verifyMethod(httpRequest);
    verifyTimeout(httpRequest);
    verifyUri(httpRequest);
    verifyVersion(httpRequest);
  }

  private static void verifyAssertion(
      HttpRequest httpRequest, GenericObjectAssert<? super HttpRequest, ?> objectAssert) {
    if (objectAssert != null) objectAssert.verify(httpRequest);
  }

  private void verifyBodyPublisher(HttpRequest httpRequest) {
    if (bodyPublisher != null) bodyPublisher.verify(httpRequest.bodyPublisher().orElse(null));
  }

  private void verifyExpectContinue(HttpRequest httpRequest) {
    if (expectContinue != null) expectContinue.verify(httpRequest.expectContinue());
  }

  private void verifyHeaders(HttpRequest httpRequest) {
    if (headers != null) headers.verify(httpRequest.headers().map());
  }

  private void verifyMethod(HttpRequest httpRequest) {
    if (method != null) method.verify(httpRequest.method());
  }

  private void verifyTimeout(HttpRequest httpRequest) {
    if (timeout != null) timeout.verify(httpRequest.timeout().orElse(null));
  }

  private void verifyUri(HttpRequest httpRequest) {
    if (uri != null) uri.verify(httpRequest.uri());
  }

  private void verifyVersion(HttpRequest httpRequest) {
    if (version != null) version.verify(httpRequest.version().orElse(null));
  }
}
