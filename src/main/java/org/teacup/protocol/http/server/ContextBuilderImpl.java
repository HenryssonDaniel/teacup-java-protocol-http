package org.teacup.protocol.http.server;

import com.sun.net.httpserver.Authenticator;
import com.sun.net.httpserver.Filter;
import io.github.henryssondaniel.teacup.core.DefaultBuilder;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

class ContextBuilderImpl extends DefaultBuilder<Context, ContextSetter> implements ContextBuilder {
  private static final Logger LOGGER = Logger.getLogger(ContextBuilderImpl.class.getName());

  private final String path;
  private final Response response;

  ContextBuilderImpl(String path, Response response) {
    super(new ContextImpl(path, response));

    this.path = path;
    this.response = response;
  }

  @Override
  public ContextBuilder setAttributes(Map<String, Object> attributes) {
    LOGGER.log(Level.FINE, "Setting the attributes");
    getImplementation().setAttributes(attributes);

    return this;
  }

  @Override
  public ContextBuilder setAuthenticator(Authenticator authenticator) {
    LOGGER.log(Level.FINE, "Setting the authenticator");
    getImplementation().setAuthenticator(authenticator);

    return this;
  }

  @Override
  public ContextBuilder setFilters(List<? extends Filter> filters) {
    LOGGER.log(Level.FINE, "Setting the filters");
    getImplementation().setFilters(filters);

    return this;
  }

  @Override
  protected ContextSetter createImplementation() {
    return new ContextImpl(path, response);
  }
}
