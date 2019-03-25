package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.SETTING_THE;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.teacup.core.assertion.StringAssert;

class PrincipalBuilderImpl
    extends BuilderImpl<java.security.Principal, Principal, PrincipalSetter, PrincipalBuilder>
    implements PrincipalBuilder {
  private static final Logger LOGGER = Logger.getLogger(PrincipalBuilderImpl.class.getName());

  PrincipalBuilderImpl() {
    super(new PrincipalImpl());
  }

  @Override
  public PrincipalBuilder setName(StringAssert<?> name) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "name"));
    getImplementation().setName(name);
    return this;
  }

  @Override
  protected PrincipalSetter createImplementation() {
    return new PrincipalImpl();
  }
}
