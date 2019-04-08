package io.github.henryssondaniel.teacup.protocol.http.node;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import java.security.Principal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class PrincipalImplTest {
  private final Principal principal = mock(Principal.class);
  private final PrincipalSetter principalSetter = new PrincipalImpl();

  @Mock private GenericObjectAssert<Principal, ?> genericObjectAssert;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void setAssertion() {
    principalSetter.setAssertion(genericObjectAssert);
    principalSetter.verify(principal);

    verify(genericObjectAssert).verify(principal);
    verify(principal, never()).getName();
  }

  @Test
  void setName() {
    GenericStringAssert<?> genericStringAssert = mock(GenericStringAssert.class);

    principalSetter.setName(genericStringAssert);
    principalSetter.verify(principal);

    verify(principal).getName();
    verify(genericStringAssert).verify(principal.getName());
  }
}
