package org.teacup.protocol.http.server;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.teacup.core.DefaultBuilder;

class ResponseBuilderImpl extends DefaultBuilder<Response, ResponseSetter>
    implements ResponseBuilder {
  private static final Logger LOGGER = Logger.getLogger(ResponseBuilderImpl.class.getName());
  private static final String MESSAGE = "Setting the %s";

  private final int code;
  private final long length;

  ResponseBuilderImpl(int code, long length) {
    super(new ResponseImpl(code, length));

    this.code = code;
    this.length = length;
  }

  @Override
  public ResponseBuilder setAttributes(Map<String, Object> attributes) {
    LOGGER.log(Level.FINE, String.format(MESSAGE, "attributes"));
    getImplementation().setAttributes(attributes);
    return this;
  }

  @Override
  public ResponseBuilder setBody(byte... body) {
    LOGGER.log(Level.FINE, String.format(MESSAGE, "body"));
    getImplementation().setBody(body);
    return this;
  }

  @Override
  public ResponseBuilder setHeaders(Map<String, ? extends List<String>> headers) {
    LOGGER.log(Level.FINE, String.format(MESSAGE, "headers"));
    getImplementation().setHeaders(headers);
    return this;
  }

  @Override
  public ResponseBuilder setStreams(Streams streams) {
    LOGGER.log(Level.FINE, String.format(MESSAGE, "streams"));
    getImplementation().setStreams(streams);
    return this;
  }

  @Override
  protected ResponseSetter createImplementation() {
    return new ResponseImpl(code, length);
  }
}