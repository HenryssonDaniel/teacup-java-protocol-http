package org.teacup.protocol.http.server;

import java.util.List;
import java.util.Map;

interface ResponseSetter extends Response {
  void setAttributes(Map<String, Object> attributes);

  void setBody(byte... body);

  void setHeaders(Map<String, ? extends List<String>> headers);

  void setStreams(Streams streams);
}
