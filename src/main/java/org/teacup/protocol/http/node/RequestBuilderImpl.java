package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.SETTING_THE;

import io.github.henryssondaniel.teacup.core.assertion.BooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.ComparableAssert;
import io.github.henryssondaniel.teacup.core.assertion.MapAssert;
import io.github.henryssondaniel.teacup.core.assertion.StringAssert;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class RequestBuilderImpl extends BuilderImpl<HttpRequest, Request, RequestSetter, RequestBuilder>
    implements RequestBuilder {
  private static final Logger LOGGER = Logger.getLogger(RequestBuilderImpl.class.getName());

  RequestBuilderImpl() {
    super(new RequestImpl());
  }

  @Override
  public RequestBuilder setBodyPublisher(BodyPublisher bodyPublisher) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "body publisher"));
    getImplementation().setBodyPublisher(bodyPublisher);
    return this;
  }

  @Override
  public RequestBuilder setExpectContinue(BooleanAssert<?> expectContinue) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "expect continue"));
    getImplementation().setExpectContinue(expectContinue);
    return this;
  }

  @Override
  public RequestBuilder setHeaders(MapAssert<String, List<String>, ?> headers) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "headers"));
    getImplementation().setHeaders(headers);
    return this;
  }

  @Override
  public RequestBuilder setMethod(StringAssert<?> method) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "method"));
    getImplementation().setMethod(method);
    return this;
  }

  @Override
  public RequestBuilder setTimeout(Duration timeout) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "timeout"));
    getImplementation().setTimeout(timeout);
    return this;
  }

  @Override
  public RequestBuilder setUri(Uri uri) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "URI"));
    getImplementation().setUri(uri);
    return this;
  }

  @Override
  public RequestBuilder setVersion(ComparableAssert<? super Version, ?> version) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "version"));
    getImplementation().setVersion(version);
    return this;
  }

  @Override
  protected RequestSetter createImplementation() {
    return new RequestImpl();
  }
}
