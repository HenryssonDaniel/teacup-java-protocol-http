package io.github.henryssondaniel.teacup.protocol.http.server;

import com.sun.net.httpserver.Authenticator;
import com.sun.net.httpserver.Filter;
import io.github.henryssondaniel.teacup.protocol.Builder;
import java.util.List;
import java.util.Map;

/**
 * Context builder.
 *
 * @since 1.0
 */
public interface ContextBuilder extends Builder<Context> {
  /**
   * Sets the attributes.
   *
   * @param attributes the attributes
   * @return the context builder
   */
  ContextBuilder setAttributes(Map<String, Object> attributes);

  /**
   * Sets the authenticator.
   *
   * @param authenticator the authenticator
   * @return the context builder
   */
  ContextBuilder setAuthenticator(Authenticator authenticator);

  /**
   * Sets the filters.
   *
   * @param filters the filters
   * @return the context builder
   */
  ContextBuilder setFilters(List<? extends Filter> filters);
}
