package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericBooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericComparableAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericMapAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.Map;
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
    LOGGER.log(Level.FINE, String.format(Constants.SETTING_THE, "body publisher"));
    getImplementation().setBodyPublisher(bodyPublisher);
    return this;
  }

  @Override
  public RequestBuilder setExpectContinue(GenericBooleanAssert<?> expectContinue) {
    LOGGER.log(Level.FINE, String.format(Constants.SETTING_THE, "expect continue"));
    getImplementation().setExpectContinue(expectContinue);
    return this;
  }

  @Override
  public RequestBuilder setHeaders(
      GenericMapAssert<String, List<String>, ? super Map<String, List<String>>, ?> headers) {
    LOGGER.log(Level.FINE, String.format(Constants.SETTING_THE, "headers"));
    getImplementation().setHeaders(headers);
    return this;
  }

  @Override
  public RequestBuilder setMethod(GenericStringAssert<?> method) {
    LOGGER.log(Level.FINE, String.format(Constants.SETTING_THE, "method"));
    getImplementation().setMethod(method);
    return this;
  }

  @Override
  public RequestBuilder setTimeout(Duration timeout) {
    LOGGER.log(Level.FINE, String.format(Constants.SETTING_THE, "timeout"));
    getImplementation().setTimeout(timeout);
    return this;
  }

  @Override
  public RequestBuilder setUri(Uri uri) {
    LOGGER.log(Level.FINE, String.format(Constants.SETTING_THE, "URI"));
    getImplementation().setUri(uri);
    return this;
  }

  @Override
  public RequestBuilder setVersion(GenericComparableAssert<? super Version, ?> version) {
    LOGGER.log(Level.FINE, String.format(Constants.SETTING_THE, "version"));
    getImplementation().setVersion(version);
    return this;
  }

  @Override
  protected RequestSetter createImplementation() {
    return new RequestImpl();
  }
}
