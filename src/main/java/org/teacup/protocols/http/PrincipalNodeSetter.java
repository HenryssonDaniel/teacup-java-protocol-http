package org.teacup.protocols.http;

import java.security.Principal;
import org.teacup.core.assertion.ObjectAssert;
import org.teacup.core.assertion.StringAssert;

interface PrincipalNodeSetter extends PrincipalNode {
  void setAssertion(ObjectAssert<? super Principal, ?> assertion);

  void setName(StringAssert name);
}
