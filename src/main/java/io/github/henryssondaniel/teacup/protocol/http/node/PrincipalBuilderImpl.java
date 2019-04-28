package io.github.henryssondaniel.teacup.protocol.http.node;

import static io.github.henryssondaniel.teacup.protocol.http.node.Constants.SETTING_THE;

import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.util.logging.Level;
import java.util.logging.Logger;

class PrincipalBuilderImpl
    extends BuilderImpl<java.security.Principal, Principal, PrincipalSetter, PrincipalBuilder>
    implements PrincipalBuilder {
  private static final Logger LOGGER = Factory.getLogger(PrincipalBuilderImpl.class);

  PrincipalBuilderImpl() {
    super(new PrincipalImpl());
  }

  @Override
  public PrincipalBuilder setName(GenericStringAssert<?> name) {
    LOGGER.log(Level.FINE, SETTING_THE, "name");
    getImplementation().setName(name);
    return this;
  }

  @Override
  protected PrincipalSetter createImplementation() {
    return new PrincipalImpl();
  }
}
