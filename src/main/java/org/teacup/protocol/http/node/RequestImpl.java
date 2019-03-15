package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.SETTING_THE;
import static org.teacup.protocol.http.node.Constants.SETTING_WHETHER;
import static org.teacup.protocol.http.node.Constants.VERIFY;

import java.net.URI;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.teacup.core.Node;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.ComparableAssert;
import org.teacup.core.assertion.MapAssert;
import org.teacup.core.assertion.ObjectAssert;
import org.teacup.core.assertion.StringAssert;

class RequestImpl extends SetterImpl<HttpRequest> implements RequestSetter {
  private static final Logger LOGGER = Logger.getLogger(RequestImpl.class.getName());

  private Node<HttpRequest.BodyPublisher> bodyPublisher;
  private ObjectAssert<Boolean, ?> expectContinue;
  private ObjectAssert<Map<String, List<String>>, ?> headers;
  private ObjectAssert<String, ?> method;
  private Node<java.time.Duration> timeout;
  private Node<URI> uri;
  private ObjectAssert<? super Version, ?> version;

  @Override
  public void setBodyPublisher(BodyPublisher bodyPublisher) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "body publisher"));
    this.bodyPublisher = bodyPublisher;
  }

  @Override
  public void setExpectContinue(BooleanAssert<?> expectContinue) {
    LOGGER.log(Level.FINE, String.format(SETTING_WHETHER, "expect continue"));
    this.expectContinue = expectContinue;
  }

  @Override
  public void setHeaders(MapAssert<String, List<String>, ?> headers) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "headers"));
    this.headers = headers;
  }

  @Override
  public void setMethod(StringAssert<?> method) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "method"));
    this.method = method;
  }

  @Override
  public void setTimeout(Duration timeout) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "timeout"));
    this.timeout = timeout;
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
  public void verify(HttpRequest httpRequest) {
    LOGGER.log(Level.FINE, String.format(VERIFY, "HTTP request"));

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
      HttpRequest httpRequest, ObjectAssert<? super HttpRequest, ?> objectAssert) {
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
