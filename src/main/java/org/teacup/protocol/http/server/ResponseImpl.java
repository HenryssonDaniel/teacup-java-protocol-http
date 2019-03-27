package org.teacup.protocol.http.server;

import com.sun.net.httpserver.Headers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

class ResponseImpl implements ResponseSetter {
  private static final Logger LOGGER = Logger.getLogger(ResponseImpl.class.getName());
  private static final String MESSAGE = "%setting the %s";

  private final Map<String, Object> attributes = new HashMap<>(0);
  private final int code;
  private final Map<String, List<String>> headers = new Headers();
  private final long length;

  private byte[] body;
  private Streams streams;

  ResponseImpl(int code, long length) {
    this.code = code;
    this.length = length;
  }

  @Override
  public Map<String, Object> getAttributes() {
    LOGGER.log(Level.FINE, String.format(MESSAGE, "G", "attributes"));
    return new HashMap<>(attributes);
  }

  @Override
  public byte[] getBody() {
    LOGGER.log(Level.FINE, String.format(MESSAGE, "G", "body"));
    return body == null ? null : body.clone();
  }

  @Override
  public int getCode() {
    return code;
  }

  @Override
  public Map<String, List<String>> getHeaders() {
    LOGGER.log(Level.FINE, String.format(MESSAGE, "G", "headers"));

    Map<String, List<String>> map = new Headers();
    map.putAll(headers);

    return map;
  }

  @Override
  public long getLength() {
    return length;
  }

  @Override
  public Streams getStreams() {
    return streams;
  }

  @Override
  public void setAttributes(Map<String, Object> attributes) {
    LOGGER.log(Level.FINE, String.format(MESSAGE, "S", "attributes"));

    this.attributes.clear();
    this.attributes.putAll(attributes);
  }

  @Override
  public void setBody(byte... body) {
    LOGGER.log(Level.FINE, String.format(MESSAGE, "S", "body"));
    this.body = body.clone();
  }

  @Override
  public void setHeaders(Map<String, ? extends List<String>> headers) {
    LOGGER.log(Level.FINE, String.format(MESSAGE, "S", "headers"));

    this.headers.clear();
    this.headers.putAll(headers);
  }

  @Override
  public void setStreams(Streams streams) {
    this.streams = streams;
  }
}
