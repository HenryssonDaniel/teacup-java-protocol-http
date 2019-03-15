package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.SETTING_THE;

import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.ComparableAssert;
import org.teacup.core.assertion.MapAssert;
import org.teacup.core.assertion.StringAssert;

class RequestBuilderImpl extends BuilderImpl<HttpRequest, Request, RequestSetter, RequestBuilder>
    implements RequestBuilder {
  private static final Logger LOGGER = Logger.getLogger(RequestBuilderImpl.class.getName());

  RequestBuilderImpl() {
    super(new RequestImpl());
  }

  @Override
  public RequestBuilder setBodyPublisher(BodyPublisher bodyPublisher) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "body publisher"));
    getSetter().setBodyPublisher(bodyPublisher);
    return this;
  }

  @Override
  public RequestBuilder setExpectContinue(BooleanAssert<?> expectContinue) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "expect continue"));
    getSetter().setExpectContinue(expectContinue);
    return this;
  }

  @Override
  public RequestBuilder setHeaders(MapAssert<String, List<String>, ?> headers) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "headers"));
    getSetter().setHeaders(headers);
    return this;
  }

  @Override
  public RequestBuilder setMethod(StringAssert<?> method) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "method"));
    getSetter().setMethod(method);
    return this;
  }

  @Override
  public RequestBuilder setTimeout(Duration timeout) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "timeout"));
    getSetter().setTimeout(timeout);
    return this;
  }

  @Override
  public RequestBuilder setUri(Uri uri) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "URI"));
    getSetter().setUri(uri);
    return this;
  }

  @Override
  public RequestBuilder setVersion(ComparableAssert<? super Version, ?> version) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "version"));
    getSetter().setVersion(version);
    return this;
  }

  @Override
  protected RequestSetter createSetter() {
    return new RequestImpl();
  }
}
