package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.NodeBuilder;
import io.github.henryssondaniel.teacup.core.assertion.BooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.IntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.StringAssert;
import java.net.URI;

/**
 * URI builder.
 *
 * @since 1.0
 */
public interface UriBuilder extends NodeBuilder<URI, Uri, UriBuilder> {
  /**
   * Sets whether absolute or not.
   *
   * @param absolute whether absolute or not
   * @return the URI builder
   */
  UriBuilder setAbsolute(BooleanAssert<?> absolute);

  /**
   * Sets the authority.
   *
   * @param authority the authority
   * @return the URI builder
   */
  UriBuilder setAuthority(StringAssert<?> authority);

  /**
   * Sets the fragment.
   *
   * @param fragment the fragment
   * @return the URI builder
   */
  UriBuilder setFragment(StringAssert<?> fragment);

  /**
   * Sets the host.
   *
   * @param host the host
   * @return the URI builder
   */
  UriBuilder setHost(StringAssert<?> host);

  /**
   * Sets the opaque.
   *
   * @param opaque the opaque
   * @return the URI builder
   */
  UriBuilder setOpaque(BooleanAssert<?> opaque);

  /**
   * Sets the path.
   *
   * @param path the path
   * @return the URI builder
   */
  UriBuilder setPath(StringAssert<?> path);

  /**
   * Sets the port.
   *
   * @param port the port
   * @return the URI builder
   */
  UriBuilder setPort(IntegerAssert<?> port);

  /**
   * Sets the query.
   *
   * @param query the query
   * @return the URI builder
   */
  UriBuilder setQuery(StringAssert<?> query);

  /**
   * Sets the raw authority.
   *
   * @param rawAuthority the raw authority
   * @return the URI builder
   */
  UriBuilder setRawAuthority(StringAssert<?> rawAuthority);

  /**
   * Sets the raw fragment.
   *
   * @param rawFragment the raw fragment
   * @return the URI builder
   */
  UriBuilder setRawFragment(StringAssert<?> rawFragment);

  /**
   * Sets the raw path.
   *
   * @param rawPath the raw path
   * @return the URI builder
   */
  UriBuilder setRawPath(StringAssert<?> rawPath);

  /**
   * Sets the raw query.
   *
   * @param rawQuery the raw query
   * @return the URI builder
   */
  UriBuilder setRawQuery(StringAssert<?> rawQuery);

  /**
   * Sets the raw scheme specific part.
   *
   * @param rawSchemeSpecificPart the raw scheme specific part
   * @return the URI builder
   */
  UriBuilder setRawSchemeSpecificPart(StringAssert<?> rawSchemeSpecificPart);

  /**
   * Sets the raw user info.
   *
   * @param rawUserInfo the raw user info
   * @return the URI builder
   */
  UriBuilder setRawUserInfo(StringAssert<?> rawUserInfo);

  /**
   * Sets the scheme.
   *
   * @param scheme the scheme
   * @return the URI builder
   */
  UriBuilder setScheme(StringAssert<?> scheme);

  /**
   * Sets the scheme specific part.
   *
   * @param schemeSpecificPart the scheme specific part
   * @return the URI builder
   */
  UriBuilder setSchemeSpecificPart(StringAssert<?> schemeSpecificPart);

  /**
   * Sets the user info.
   *
   * @param userInfo the user info
   * @return the URI builder
   */
  UriBuilder setUserInfo(StringAssert<?> userInfo);
}
