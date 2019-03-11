package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.SETTING_THE;
import static org.teacup.protocol.http.node.Constants.VERIFY;

import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.teacup.core.assertion.ObjectAssert;
import org.teacup.core.assertion.StringAssert;

class PrincipalNodeImpl implements PrincipalNodeSetter {
  private static final Logger LOGGER = Logger.getLogger(PrincipalNodeImpl.class.getName());

  private ObjectAssert<? super Principal, ?> assertion;
  private ObjectAssert<String, StringAssert> name;

  @Override
  public void setAssertion(ObjectAssert<? super Principal, ?> assertion) {
    this.assertion = assertion;
  }

  @Override
  public void setName(StringAssert name) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "name"));
    this.name = name;
  }

  @Override
  public void verify(Principal principal) {
    LOGGER.log(Level.FINE, String.format(VERIFY, "principal"));
    if (assertion != null) assertion.verify(principal);

    if (name != null) name.verify(principal.getName());
  }
}
