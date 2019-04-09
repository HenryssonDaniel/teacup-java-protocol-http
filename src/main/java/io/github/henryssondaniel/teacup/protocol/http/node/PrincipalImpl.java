package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

class PrincipalImpl extends SetterImpl<Principal, GenericObjectAssert<Principal, ?>>
    implements PrincipalSetter {
  private static final Logger LOGGER = Logger.getLogger(PrincipalImpl.class.getName());
  private GenericObjectAssert<String, ?> name;

  @Override
  public void setName(GenericStringAssert<?> name) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "name");
    this.name = name;
  }

  @Override
  public void verify(Principal principal) {
    LOGGER.log(Level.FINE, Constants.VERIFY, "principal");
    verifyAssertion(getAssertion(), principal);

    if (name != null) name.verify(principal.getName());
  }

  private static void verifyAssertion(
      GenericObjectAssert<? super Principal, ?> objectAssert, Principal principal) {
    if (objectAssert != null) objectAssert.verify(principal);
  }
}
