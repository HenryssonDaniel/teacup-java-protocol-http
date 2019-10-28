package io.github.henryssondaniel.teacup.protocol.http.server;

import com.sun.net.httpserver.Authenticator;
import com.sun.net.httpserver.Filter;
import java.util.List;
import java.util.Map;

/**
 * Context to be used by a server.
 *
 * @since 1.0
 */
public interface Context extends io.github.henryssondaniel.teacup.protocol.server.Context {
  /**
   * Returns the attributes.
   *
   * @return the attributes
   */
  Map<String, Object> getAttributes();

  /**
   * Returns the authenticator.
   *
   * @return the authenticator
   */
  Authenticator getAuthenticator();

  /**
   * Returns the filters.
   *
   * @return the filters
   */
  List<Filter> getFilters();

  /**
   * Returns the path.
   *
   * @return the path
   */
  String getPath();

  /**
   * Returns the response.
   *
   * @return the response
   */
  Response getResponse();
}
