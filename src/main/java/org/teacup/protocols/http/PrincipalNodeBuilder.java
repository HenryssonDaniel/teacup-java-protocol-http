package org.teacup.protocols.http;

import java.security.Principal;
import org.teacup.core.NodeBuilder;
import org.teacup.core.assertion.StringAssert;

/**
 * Principal node builder.
 *
 * @since 1.0
 */
public interface PrincipalNodeBuilder
    extends NodeBuilder<Principal, PrincipalNode, PrincipalNodeBuilder> {
  /**
   * Sets the name.
   *
   * @param name the name
   * @return the principal node builder
   */
  PrincipalNodeBuilder setName(StringAssert name);
}
