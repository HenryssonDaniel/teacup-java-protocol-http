package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;

interface PrincipalSetter
    extends Principal,
        Setter<java.security.Principal, GenericObjectAssert<java.security.Principal, ?>> {
  void setName(GenericStringAssert<?> name);
}
