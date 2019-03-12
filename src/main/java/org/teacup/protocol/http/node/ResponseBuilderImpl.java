package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.SETTING_THE;

import java.net.http.HttpClient.Version;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.teacup.core.assertion.ComparableAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.MapAssert;
import org.teacup.core.assertion.ObjectAssert;

class ResponseBuilderImpl<T>
    extends BuilderImpl<HttpResponse<T>, Response<T>, ResponseSetter<T>, ResponseBuilder<T>>
    implements ResponseBuilder<T> {
  private static final Logger LOGGER = Logger.getLogger(ResponseBuilderImpl.class.getName());

  ResponseBuilderImpl() {
    super(new ResponseImpl<>());
  }

  @Override
  public ResponseBuilder<T> setBody(ObjectAssert<? super T, ?> body) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "body"));
    getSetter().setBody(body);
    return this;
  }

  @Override
  public ResponseBuilder<T> setHeaders(MapAssert<String, List<String>, ?> headers) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "headers"));
    getSetter().setHeaders(headers);
    return this;
  }

  @Override
  public ResponseBuilder<T> setPreviousResponse(Response<T> previousResponse) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "previous response"));
    getSetter().setPreviousResponse(previousResponse);
    return this;
  }

  @Override
  public ResponseBuilder<T> setRequest(Request request) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "request"));
    getSetter().setRequest(request);
    return this;
  }

  @Override
  public ResponseBuilder<T> setSslSession(SslSession sslSession) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "SSL session"));
    getSetter().setSslSession(sslSession);
    return this;
  }

  @Override
  public ResponseBuilder<T> setStatusCode(IntegerAssert statusCode) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "status code"));
    getSetter().setStatusCode(statusCode);
    return this;
  }

  @Override
  public ResponseBuilder<T> setUri(Uri uri) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "URI"));
    getSetter().setUri(uri);
    return this;
  }

  @Override
  public ResponseBuilder<T> setVersion(ComparableAssert<? super Version, ?> version) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "version"));
    getSetter().setVersion(version);
    return this;
  }

  @Override
  protected ResponseSetter<T> createSetter() {
    return new ResponseImpl<>();
  }
}
