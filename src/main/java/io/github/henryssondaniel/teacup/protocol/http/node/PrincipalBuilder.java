package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.NodeBuilder;
import io.github.henryssondaniel.teacup.core.assertion.StringAssert;

/**
 * Principal builder.
 *
 * @since 1.0
 */
public interface PrincipalBuilder
    extends NodeBuilder<java.security.Principal, Principal, PrincipalBuilder> {
  /**
   * Sets the name.
   *
   * @param name the name
   * @return the principal builder
   */
  PrincipalBuilder setName(StringAssert<?> name);
}
