package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericComparableAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericMapAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import java.net.http.HttpClient.Version;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

class ResponseBuilderImpl<T>
    extends BuilderImpl<HttpResponse<T>, Response<T>, ResponseSetter<T>, ResponseBuilder<T>>
    implements ResponseBuilder<T> {
  private static final Logger LOGGER = Logger.getLogger(ResponseBuilderImpl.class.getName());

  ResponseBuilderImpl() {
    super(new ResponseImpl<>());
  }

  @Override
  public ResponseBuilder<T> setBody(GenericObjectAssert<? super T, ?> body) {
    LOGGER.log(Level.FINE, String.format(Constants.SETTING_THE, "body"));
    getImplementation().setBody(body);
    return this;
  }

  @Override
  public ResponseBuilder<T> setHeaders(
      GenericMapAssert<String, List<String>, ? super Map<String, List<String>>, ?> headers) {
    LOGGER.log(Level.FINE, String.format(Constants.SETTING_THE, "headers"));
    getImplementation().setHeaders(headers);
    return this;
  }

  @Override
  public ResponseBuilder<T> setPreviousResponse(Response<T> previousResponse) {
    LOGGER.log(Level.FINE, String.format(Constants.SETTING_THE, "previous response"));
    getImplementation().setPreviousResponse(previousResponse);
    return this;
  }

  @Override
  public ResponseBuilder<T> setRequest(Request request) {
    LOGGER.log(Level.FINE, String.format(Constants.SETTING_THE, "request"));
    getImplementation().setRequest(request);
    return this;
  }

  @Override
  public ResponseBuilder<T> setSslSession(SslSession sslSession) {
    LOGGER.log(Level.FINE, String.format(Constants.SETTING_THE, "SSL session"));
    getImplementation().setSslSession(sslSession);
    return this;
  }

  @Override
  public ResponseBuilder<T> setStatusCode(GenericIntegerAssert<?> statusCode) {
    LOGGER.log(Level.FINE, String.format(Constants.SETTING_THE, "status code"));
    getImplementation().setStatusCode(statusCode);
    return this;
  }

  @Override
  public ResponseBuilder<T> setUri(Uri uri) {
    LOGGER.log(Level.FINE, String.format(Constants.SETTING_THE, "URI"));
    getImplementation().setUri(uri);
    return this;
  }

  @Override
  public ResponseBuilder<T> setVersion(GenericComparableAssert<? super Version, ?> version) {
    LOGGER.log(Level.FINE, String.format(Constants.SETTING_THE, "version"));
    getImplementation().setVersion(version);
    return this;
  }

  @Override
  protected ResponseSetter<T> createImplementation() {
    return new ResponseImpl<>();
  }
}
