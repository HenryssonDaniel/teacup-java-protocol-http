package org.teacup.protocol.http;

import static org.teacup.protocol.http.Constants.BUILD;
import static org.teacup.protocol.http.Constants.SETTING_THE;

import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.teacup.core.assertion.ObjectAssert;
import org.teacup.core.assertion.StringAssert;

class PrincipalNodeBuilderImpl implements PrincipalNodeBuilder {
  private static final Logger LOGGER = Logger.getLogger(PrincipalNodeBuilderImpl.class.getName());
  private PrincipalNodeSetter principalNodeSetter = new PrincipalNodeImpl();

  @Override
  public PrincipalNode build() {
    LOGGER.log(Level.FINE, String.format(BUILD, "principal"));

    PrincipalNode principalNode = principalNodeSetter;
    principalNodeSetter = new PrincipalNodeImpl();

    return principalNode;
  }

  @Override
  public PrincipalNodeBuilder setAssertion(ObjectAssert<Principal, ?> assertion) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "assertion"));
    principalNodeSetter.setAssertion(assertion);
    return this;
  }

  @Override
  public PrincipalNodeBuilder setName(StringAssert name) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "name"));
    principalNodeSetter.setName(name);
    return this;
  }
}
