package org.teacup.protocol.http.server;

import com.sun.net.httpserver.Authenticator;
import com.sun.net.httpserver.Filter;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

class ContextBuilderImpl implements ContextBuilder {
  private static final Logger LOGGER = Logger.getLogger(ContextBuilderImpl.class.getName());

  private final String path;
  private final Response response;

  private ContextSetter contextSetter;

  ContextBuilderImpl(String path, Response response) {
    this.path = path;
    this.response = response;

    contextSetter = new ContextImpl(path, response);
  }

  @Override
  public Context build() {
    LOGGER.log(Level.FINE, "Building the context");

    Context context = contextSetter;
    contextSetter = new ContextImpl(path, response);

    return context;
  }

  @Override
  public ContextBuilder setAttributes(Map<String, Object> attributes) {
    LOGGER.log(Level.FINE, "Setting the attributes");
    contextSetter.setAttributes(attributes);

    return this;
  }

  @Override
  public ContextBuilder setAuthenticator(Authenticator authenticator) {
    LOGGER.log(Level.FINE, "Setting the authenticator");
    contextSetter.setAuthenticator(authenticator);

    return this;
  }

  @Override
  public ContextBuilder setFilters(List<? extends Filter> filters) {
    LOGGER.log(Level.FINE, "Setting the filters");
    contextSetter.setFilters(filters);

    return this;
  }
}
