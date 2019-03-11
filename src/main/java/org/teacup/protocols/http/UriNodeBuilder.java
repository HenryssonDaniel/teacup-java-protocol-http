package org.teacup.protocols.http;

import java.net.URI;
import org.teacup.core.NodeBuilder;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.StringAssert;

/**
 * URI node builder.
 *
 * @since 1.0
 */
public interface UriNodeBuilder extends NodeBuilder<URI, UriNode, UriNodeBuilder> {
  /**
   * Sets whether absolute or not.
   *
   * @param absolute whether absolute or not
   * @return the URI node builder
   */
  UriNodeBuilder setAbsolute(BooleanAssert absolute);

  /**
   * Sets the authority.
   *
   * @param authority the authority
   * @return the URI node builder
   */
  UriNodeBuilder setAuthority(StringAssert authority);

  /**
   * Sets the fragment.
   *
   * @param fragment the fragment
   * @return the URI node builder
   */
  UriNodeBuilder setFragment(StringAssert fragment);

  /**
   * Sets the host.
   *
   * @param host the host
   * @return the URI node builder
   */
  UriNodeBuilder setHost(StringAssert host);

  /**
   * Sets the opaque.
   *
   * @param opaque the opaque
   * @return the URI node builder
   */
  UriNodeBuilder setOpaque(BooleanAssert opaque);

  /**
   * Sets the path.
   *
   * @param path the path
   * @return the URI node builder
   */
  UriNodeBuilder setPath(StringAssert path);

  /**
   * Sets the port.
   *
   * @param port the port
   * @return the URI node builder
   */
  UriNodeBuilder setPort(IntegerAssert port);

  /**
   * Sets the query.
   *
   * @param query the query
   * @return the URI node builder
   */
  UriNodeBuilder setQuery(StringAssert query);

  /**
   * Sets the raw authority.
   *
   * @param rawAuthority the raw authority
   * @return the URI node builder
   */
  UriNodeBuilder setRawAuthority(StringAssert rawAuthority);

  /**
   * Sets the raw fragment.
   *
   * @param rawFragment the raw fragment
   * @return the URI node builder
   */
  UriNodeBuilder setRawFragment(StringAssert rawFragment);

  /**
   * Sets the raw path.
   *
   * @param rawPath the raw path
   * @return the URI node builder
   */
  UriNodeBuilder setRawPath(StringAssert rawPath);

  /**
   * Sets the raw query.
   *
   * @param rawQuery the raw query
   * @return the URI node builder
   */
  UriNodeBuilder setRawQuery(StringAssert rawQuery);

  /**
   * Sets the raw scheme specific part.
   *
   * @param rawSchemeSpecificPart the raw scheme specific part
   * @return the URI node builder
   */
  UriNodeBuilder setRawSchemeSpecificPart(StringAssert rawSchemeSpecificPart);

  /**
   * Sets the raw user info.
   *
   * @param rawUserInfo the raw user info
   * @return the URI node builder
   */
  UriNodeBuilder setRawUserInfo(StringAssert rawUserInfo);

  /**
   * Sets the scheme.
   *
   * @param scheme the scheme
   * @return the URI node builder
   */
  UriNodeBuilder setScheme(StringAssert scheme);

  /**
   * Sets the scheme specific part.
   *
   * @param schemeSpecificPart the scheme specific part
   * @return the URI node builder
   */
  UriNodeBuilder setSchemeSpecificPart(StringAssert schemeSpecificPart);

  /**
   * Sets the user info.
   *
   * @param userInfo the user info
   * @return the URI node builder
   */
  UriNodeBuilder setUserInfo(StringAssert userInfo);
}
