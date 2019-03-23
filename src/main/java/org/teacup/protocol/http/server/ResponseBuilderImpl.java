package org.teacup.protocol.http.server;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

class ResponseBuilderImpl implements ResponseBuilder {
  private static final Logger LOGGER = Logger.getLogger(ResponseBuilderImpl.class.getName());
  private static final String MESSAGE = "Setting the %s";

  private final int code;
  private final long length;

  private ResponseSetter responseSetter;

  ResponseBuilderImpl(int code, long length) {
    this.code = code;
    this.length = length;

    responseSetter = new ResponseImpl(code, length);
  }

  @Override
  public Response build() {
    LOGGER.log(Level.FINE, "Building the context");

    Response response = responseSetter;
    responseSetter = new ResponseImpl(code, length);

    return response;
  }

  @Override
  public ResponseBuilder setAttributes(Map<String, Object> attributes) {
    LOGGER.log(Level.FINE, String.format(MESSAGE, "attributes"));
    responseSetter.setAttributes(attributes);
    return this;
  }

  @Override
  public ResponseBuilder setBody(byte... body) {
    LOGGER.log(Level.FINE, String.format(MESSAGE, "body"));
    responseSetter.setBody(body);
    return this;
  }

  @Override
  public ResponseBuilder setHeaders(Map<String, ? extends List<String>> headers) {
    LOGGER.log(Level.FINE, String.format(MESSAGE, "headers"));
    responseSetter.setHeaders(headers);
    return this;
  }

  @Override
  public ResponseBuilder setStreams(Streams streams) {
    LOGGER.log(Level.FINE, String.format(MESSAGE, "streams"));
    responseSetter.setStreams(streams);
    return this;
  }
}
