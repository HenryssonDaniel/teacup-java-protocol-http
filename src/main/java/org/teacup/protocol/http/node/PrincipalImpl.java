package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.SETTING_THE;
import static org.teacup.protocol.http.node.Constants.VERIFY;

import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.teacup.core.assertion.ObjectAssert;
import org.teacup.core.assertion.StringAssert;

class PrincipalImpl extends SetterImpl<Principal> implements PrincipalSetter {
  private static final Logger LOGGER = Logger.getLogger(PrincipalImpl.class.getName());
  private ObjectAssert<String, StringAssert> name;

  @Override
  public void setName(StringAssert name) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "name"));
    this.name = name;
  }

  @Override
  public void verify(Principal principal) {
    LOGGER.log(Level.FINE, String.format(VERIFY, "principal"));
    verifyAssertion(getAssertion(), principal);

    if (name != null) name.verify(principal.getName());
  }

  private static void verifyAssertion(
      ObjectAssert<? super Principal, ?> objectAssert, Principal principal) {
    if (objectAssert != null) objectAssert.verify(principal);
  }
}
