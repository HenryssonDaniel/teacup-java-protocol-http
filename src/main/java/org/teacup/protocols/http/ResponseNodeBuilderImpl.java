package org.teacup.protocols.http;

import static org.teacup.protocols.http.Constants.BUILD;
import static org.teacup.protocols.http.Constants.SETTING_THE;

import java.net.http.HttpClient.Version;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.teacup.core.assertion.ComparableAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.MapAssert;
import org.teacup.core.assertion.ObjectAssert;

class ResponseNodeBuilderImpl<T> implements ResponseNodeBuilder<T> {
  private static final Logger LOGGER = Logger.getLogger(ResponseNodeBuilderImpl.class.getName());
  private ResponseNodeSetter<T> responseNodeSetter = new ResponseNodeImpl<>();

  @Override
  public ResponseNode<T> build() {
    LOGGER.log(Level.FINE, String.format(BUILD, "response"));

    ResponseNode<T> responseNode = responseNodeSetter;
    responseNodeSetter = new ResponseNodeImpl<>();

    return responseNode;
  }

  @Override
  public ResponseNodeBuilder<T> setAssertion(ObjectAssert<HttpResponse<T>, ?> assertion) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "assertion"));
    responseNodeSetter.setAssertion(assertion);
    return this;
  }

  @Override
  public ResponseNodeBuilder<T> setBody(ObjectAssert<? super T, ?> body) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "body"));
    responseNodeSetter.setBody(body);
    return this;
  }

  @Override
  public ResponseNodeBuilder<T> setHeaders(MapAssert<String, List<String>, ?> headers) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "headers"));
    responseNodeSetter.setHeaders(headers);
    return this;
  }

  @Override
  public ResponseNodeBuilder<T> setPreviousResponse(ResponseNode<T> previousResponse) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "previous response"));
    responseNodeSetter.setPreviousResponse(previousResponse);
    return this;
  }

  @Override
  public ResponseNodeBuilder<T> setRequest(RequestNode request) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "request"));
    responseNodeSetter.setRequest(request);
    return this;
  }

  @Override
  public ResponseNodeBuilder<T> setSslSession(SslSessionNode sslSession) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "SSL session"));
    responseNodeSetter.setSslSession(sslSession);
    return this;
  }

  @Override
  public ResponseNodeBuilder<T> setStatusCode(IntegerAssert statusCode) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "status code"));
    responseNodeSetter.setStatusCode(statusCode);
    return this;
  }

  @Override
  public ResponseNodeBuilder<T> setUri(UriNode node) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "URI"));
    responseNodeSetter.setUri(node);
    return this;
  }

  @Override
  public ResponseNodeBuilder<T> setVersion(ComparableAssert<? super Version, ?> version) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "version"));
    responseNodeSetter.setVersion(version);
    return this;
  }
}
