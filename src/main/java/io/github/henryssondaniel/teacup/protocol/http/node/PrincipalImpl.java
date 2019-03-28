package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.ObjectAssert;
import io.github.henryssondaniel.teacup.core.assertion.StringAssert;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

class PrincipalImpl extends SetterImpl<Principal> implements PrincipalSetter {
  private static final Logger LOGGER = Logger.getLogger(PrincipalImpl.class.getName());
  private ObjectAssert<String, ?> name;

  @Override
  public void setName(StringAssert<?> name) {
    LOGGER.log(Level.FINE, String.format(Constants.SETTING_THE, "name"));
    this.name = name;
  }

  @Override
  public void verify(Principal principal) {
    LOGGER.log(Level.FINE, String.format(Constants.VERIFY, "principal"));
    verifyAssertion(getAssertion(), principal);

    if (name != null) name.verify(principal.getName());
  }

  private static void verifyAssertion(
      ObjectAssert<? super Principal, ?> objectAssert, Principal principal) {
    if (objectAssert != null) objectAssert.verify(principal);
  }
}
