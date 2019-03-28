package org.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.StringAssert;

interface PrincipalSetter extends Principal, Setter<java.security.Principal> {
  void setName(StringAssert<?> name);
}
