package org.teacup.protocol.http.node;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.security.Principal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.teacup.core.assertion.ObjectAssert;
import org.teacup.core.assertion.StringAssert;

class PrincipalImplTest {
  private final Principal principal = mock(Principal.class);
  private final PrincipalSetter principalSetter = new PrincipalImpl();

  @Mock private ObjectAssert<? super Principal, ?> objectAssert;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void setAssertion() {
    principalSetter.setAssertion(objectAssert);
    principalSetter.verify(principal);

    verify(objectAssert).verify(principal);
    verify(principal, never()).getName();
  }

  @Test
  void setName() {
    var stringAssert = mock(StringAssert.class);

    principalSetter.setName(stringAssert);
    principalSetter.verify(principal);

    verify(principal).getName();
    verify(stringAssert).verify(principal.getName());
  }
}
