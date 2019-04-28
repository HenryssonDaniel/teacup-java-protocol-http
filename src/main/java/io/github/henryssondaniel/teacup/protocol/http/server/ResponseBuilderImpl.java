package io.github.henryssondaniel.teacup.protocol.http.server;

import io.github.henryssondaniel.teacup.core.DefaultBuilder;
import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

class ResponseBuilderImpl extends DefaultBuilder<Response, ResponseSetter>
    implements ResponseBuilder {
  private static final Logger LOGGER = Factory.getLogger(ResponseBuilderImpl.class);
  private static final String MESSAGE = "Setting the {0}";

  private final int code;
  private final long length;

  ResponseBuilderImpl(int code, long length) {
    super(new ResponseImpl(code, length));

    this.code = code;
    this.length = length;
  }

  @Override
  public ResponseBuilder setAttributes(Map<String, Object> attributes) {
    LOGGER.log(Level.FINE, MESSAGE, "attributes");
    getImplementation().setAttributes(attributes);
    return this;
  }

  @Override
  public ResponseBuilder setBody(byte... body) {
    LOGGER.log(Level.FINE, MESSAGE, "body");
    getImplementation().setBody(body);
    return this;
  }

  @Override
  public ResponseBuilder setHeaders(Map<String, ? extends List<String>> headers) {
    LOGGER.log(Level.FINE, MESSAGE, "headers");
    getImplementation().setHeaders(headers);
    return this;
  }

  @Override
  public ResponseBuilder setStreams(Streams streams) {
    LOGGER.log(Level.FINE, MESSAGE, "streams");
    getImplementation().setStreams(streams);
    return this;
  }

  @Override
  protected ResponseSetter createImplementation() {
    return new ResponseImpl(code, length);
  }
}
