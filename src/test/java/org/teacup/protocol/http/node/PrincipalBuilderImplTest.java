package org.teacup.protocol.http.node;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.teacup.core.DefaultNodeBuilder;
import org.teacup.core.Utils;
import org.teacup.core.assertion.StringAssert;

class PrincipalBuilderImplTest {
  @Test
  void createSetter() {
    assertThat(new PrincipalBuilderImpl().createSetter()).isExactlyInstanceOf(PrincipalImpl.class);
  }

  @Test
  void setName() throws IllegalAccessException, NoSuchFieldException {
    var principalSetter = mock(PrincipalSetter.class);

    PrincipalBuilder principalBuilder = new PrincipalBuilderImpl();
    Utils.setField(DefaultNodeBuilder.class, principalBuilder, "setter", principalSetter);

    var stringAssert = mock(StringAssert.class);

    assertThat(principalBuilder.setName(stringAssert)).isSameAs(principalBuilder);
    verify(principalSetter).setName(stringAssert);
  }
}
