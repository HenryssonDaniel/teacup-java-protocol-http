package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.BUILD;
import static org.teacup.protocol.http.node.Constants.SETTING_THE;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.teacup.core.assertion.ObjectAssert;
import org.teacup.core.assertion.StringAssert;

class PrincipalBuilderImpl implements PrincipalBuilder {
  private static final Logger LOGGER = Logger.getLogger(PrincipalBuilderImpl.class.getName());
  private PrincipalSetter principalSetter = new PrincipalImpl();

  @Override
  public Principal build() {
    LOGGER.log(Level.FINE, String.format(BUILD, "principal"));

    Principal principal = principalSetter;
    principalSetter = new PrincipalImpl();

    return principal;
  }

  @Override
  public PrincipalBuilder setAssertion(ObjectAssert<java.security.Principal, ?> assertion) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "assertion"));
    principalSetter.setAssertion(assertion);
    return this;
  }

  @Override
  public PrincipalBuilder setName(StringAssert name) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "name"));
    principalSetter.setName(name);
    return this;
  }
}
