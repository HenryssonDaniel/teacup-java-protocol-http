package io.github.henryssondaniel.teacup.protocol.http.server;

import com.sun.net.httpserver.Authenticator;
import com.sun.net.httpserver.Filter;
import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

class ContextImpl implements ContextSetter {
  private static final Logger LOGGER = Factory.getLogger(ContextImpl.class);

  private final Map<String, Object> attributes = new HashMap<>(0);
  private final Collection<Filter> filters = new LinkedList<>();
  private final String path;
  private final Response response;

  private Authenticator authenticator;

  ContextImpl(String path, Response response) {
    this.path = path;
    this.response = response;
  }

  @Override
  public Map<String, Object> getAttributes() {
    LOGGER.log(Level.FINE, "Returns the attributes");
    return new HashMap<>(attributes);
  }

  @Override
  public Authenticator getAuthenticator() {
    return authenticator;
  }

  @Override
  public List<Filter> getFilters() {
    LOGGER.log(Level.FINE, "Returns the filters");
    return new ArrayList<>(filters);
  }

  @Override
  public String getPath() {
    return path;
  }

  @Override
  public Response getResponse() {
    return response;
  }

  @Override
  public void setAttributes(Map<String, Object> attributes) {
    LOGGER.log(Level.FINE, "Setting the attributes");

    this.attributes.clear();
    this.attributes.putAll(attributes);
  }

  @Override
  public void setAuthenticator(Authenticator authenticator) {
    this.authenticator = authenticator;
  }

  @Override
  public void setFilters(List<? extends Filter> filters) {
    LOGGER.log(Level.FINE, "Setting the filters");

    this.filters.clear();
    this.filters.addAll(filters);
  }
}
