package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.BUILD;
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

class ResponseBuilderImpl<T> implements ResponseBuilder<T> {
  private static final Logger LOGGER = Logger.getLogger(ResponseBuilderImpl.class.getName());
  private ResponseSetter<T> responseSetter = new ResponseImpl<>();

  @Override
  public Response<T> build() {
    LOGGER.log(Level.FINE, String.format(BUILD, "response"));

    Response<T> response = responseSetter;
    responseSetter = new ResponseImpl<>();

    return response;
  }

  @Override
  public ResponseBuilder<T> setAssertion(ObjectAssert<HttpResponse<T>, ?> assertion) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "assertion"));
    responseSetter.setAssertion(assertion);
    return this;
  }

  @Override
  public ResponseBuilder<T> setBody(ObjectAssert<? super T, ?> body) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "body"));
    responseSetter.setBody(body);
    return this;
  }

  @Override
  public ResponseBuilder<T> setHeaders(MapAssert<String, List<String>, ?> headers) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "headers"));
    responseSetter.setHeaders(headers);
    return this;
  }

  @Override
  public ResponseBuilder<T> setPreviousResponse(Response<T> previousResponse) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "previous response"));
    responseSetter.setPreviousResponse(previousResponse);
    return this;
  }

  @Override
  public ResponseBuilder<T> setRequest(Request request) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "request"));
    responseSetter.setRequest(request);
    return this;
  }

  @Override
  public ResponseBuilder<T> setSslSession(SslSession sslSession) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "SSL session"));
    responseSetter.setSslSession(sslSession);
    return this;
  }

  @Override
  public ResponseBuilder<T> setStatusCode(IntegerAssert statusCode) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "status code"));
    responseSetter.setStatusCode(statusCode);
    return this;
  }

  @Override
  public ResponseBuilder<T> setUri(Uri uri) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "URI"));
    responseSetter.setUri(uri);
    return this;
  }

  @Override
  public ResponseBuilder<T> setVersion(ComparableAssert<? super Version, ?> version) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "version"));
    responseSetter.setVersion(version);
    return this;
  }
}
