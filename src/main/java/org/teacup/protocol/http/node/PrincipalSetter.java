package org.teacup.protocol.http.node;

import org.teacup.core.assertion.ObjectAssert;
import org.teacup.core.assertion.StringAssert;

interface PrincipalSetter extends Principal {
  void setAssertion(ObjectAssert<? super java.security.Principal, ?> assertion);

  void setName(StringAssert name);
}
