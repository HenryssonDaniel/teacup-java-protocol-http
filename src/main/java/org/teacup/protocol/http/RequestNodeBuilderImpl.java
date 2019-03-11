package org.teacup.protocol.http;

import static org.teacup.protocol.http.Constants.BUILD;
import static org.teacup.protocol.http.Constants.SETTING_THE;

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

class RequestNodeBuilderImpl implements RequestNodeBuilder {
  private static final Logger LOGGER = Logger.getLogger(RequestNodeBuilderImpl.class.getName());
  private RequestNodeSetter requestNodeSetter = new RequestNodeImpl();

  @Override
  public RequestNode build() {
    LOGGER.log(Level.FINE, String.format(BUILD, "request"));

    RequestNode requestNode = requestNodeSetter;
    requestNodeSetter = new RequestNodeImpl();

    return requestNode;
  }

  @Override
  public RequestNodeBuilder setAssertion(ObjectAssert<HttpRequest, ?> assertion) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "assertion"));
    requestNodeSetter.setAssertion(assertion);
    return this;
  }

  @Override
  public RequestNodeBuilder setBodyPublisher(BodyPublisherNode bodyPublisher) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "body publisher"));
    requestNodeSetter.setBodyPublisher(bodyPublisher);
    return this;
  }

  @Override
  public RequestNodeBuilder setExpectContinue(BooleanAssert expectContinue) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "expect continue"));
    requestNodeSetter.setExpectContinue(expectContinue);
    return this;
  }

  @Override
  public RequestNodeBuilder setHeaders(MapAssert<String, List<String>, ?> headers) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "headers"));
    requestNodeSetter.setHeaders(headers);
    return this;
  }

  @Override
  public RequestNodeBuilder setMethod(StringAssert method) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "method"));
    requestNodeSetter.setMethod(method);
    return this;
  }

  @Override
  public RequestNodeBuilder setTimeout(DurationNode timeout) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "timeout"));
    requestNodeSetter.setTimeout(timeout);
    return this;
  }

  @Override
  public RequestNodeBuilder setUri(UriNode uri) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "URI"));
    requestNodeSetter.setUri(uri);
    return this;
  }

  @Override
  public RequestNodeBuilder setVersion(ComparableAssert<? super Version, ?> version) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "version"));
    requestNodeSetter.setVersion(version);
    return this;
  }
}
