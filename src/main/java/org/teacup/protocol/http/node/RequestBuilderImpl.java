package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.BUILD;
import static org.teacup.protocol.http.node.Constants.SETTING_THE;

import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.ComparableAssert;
import org.teacup.core.assertion.MapAssert;
import org.teacup.core.assertion.ObjectAssert;
import org.teacup.core.assertion.StringAssert;

class RequestBuilderImpl implements RequestBuilder {
  private static final Logger LOGGER = Logger.getLogger(RequestBuilderImpl.class.getName());
  private RequestSetter requestSetter = new RequestImpl();

  @Override
  public Request build() {
    LOGGER.log(Level.FINE, String.format(BUILD, "request"));

    Request request = requestSetter;
    requestSetter = new RequestImpl();

    return request;
  }

  @Override
  public RequestBuilder setAssertion(ObjectAssert<HttpRequest, ?> assertion) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "assertion"));
    requestSetter.setAssertion(assertion);
    return this;
  }

  @Override
  public RequestBuilder setBodyPublisher(BodyPublisher bodyPublisher) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "body publisher"));
    requestSetter.setBodyPublisher(bodyPublisher);
    return this;
  }

  @Override
  public RequestBuilder setExpectContinue(BooleanAssert expectContinue) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "expect continue"));
    requestSetter.setExpectContinue(expectContinue);
    return this;
  }

  @Override
  public RequestBuilder setHeaders(MapAssert<String, List<String>, ?> headers) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "headers"));
    requestSetter.setHeaders(headers);
    return this;
  }

  @Override
  public RequestBuilder setMethod(StringAssert method) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "method"));
    requestSetter.setMethod(method);
    return this;
  }

  @Override
  public RequestBuilder setTimeout(Duration timeout) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "timeout"));
    requestSetter.setTimeout(timeout);
    return this;
  }

  @Override
  public RequestBuilder setUri(Uri uri) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "URI"));
    requestSetter.setUri(uri);
    return this;
  }

  @Override
  public RequestBuilder setVersion(ComparableAssert<? super Version, ?> version) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "version"));
    requestSetter.setVersion(version);
    return this;
  }
}
