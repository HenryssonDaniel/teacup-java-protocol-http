package io.github.henryssondaniel.teacup.protocol.http.node;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
    var genericStringAssert = mock(GenericStringAssert.class);

    assertThat(principalBuilder.setName(genericStringAssert)).isSameAs(principalBuilder);
    verify(implementation).setName(genericStringAssert);
  }
}
