package org.teacup.protocol.http.server;

import com.sun.net.httpserver.Authenticator;
import com.sun.net.httpserver.Filter;
import java.util.List;
import java.util.Map;

interface ContextSetter extends Context {
  void setAttributes(Map<String, Object> attributes);

  void setAuthenticator(Authenticator authenticator);

  void setFilters(List<? extends Filter> filters);
}
