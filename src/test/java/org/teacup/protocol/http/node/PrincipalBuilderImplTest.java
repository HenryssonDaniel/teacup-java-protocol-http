package org.teacup.protocol.http.node;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.teacup.core.assertion.StringAssert;

class PrincipalBuilderImplTest {
  @InjectMocks private final PrincipalBuilder principalBuilder = new PrincipalBuilderImpl();

  @Mock private PrincipalSetter implementation;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createImplementation() {
    assertThat(new PrincipalBuilderImpl().createImplementation())
        .isExactlyInstanceOf(PrincipalImpl.class);
  }

  @Test
  void setName() {
    var stringAssert = mock(StringAssert.class);

    assertThat(principalBuilder.setName(stringAssert)).isSameAs(principalBuilder);
    verify(implementation).setName(stringAssert);
  }
}
