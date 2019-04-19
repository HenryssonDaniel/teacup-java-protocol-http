package io.github.henryssondaniel.teacup.protocol.http.node;

import static io.github.henryssondaniel.teacup.core.assertion.Factory.createStringAssert;

import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

class PrincipalTest {
  private static final String NAME = "name";

  @Test
  void verify() {
    Factory.createPrincipalBuilder()
        .setName(createStringAssert().isEqualTo(NAME))
        .build()
        .verify(new TestPrincipal());
  }

  private static final class TestPrincipal implements Principal {
    private static final Logger LOGGER = Logger.getLogger(TestPrincipal.class.getName());

    @Override
    public String getName() {
      LOGGER.log(Level.FINE, "Get name");
      return NAME;
    }
  }
}
