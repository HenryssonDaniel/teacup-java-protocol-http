package org.teacup.protocol.http.node;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.teacup.core.DefaultNodeBuilder;
import org.teacup.core.Utils;
import org.teacup.core.assertion.LongAssert;

class BodyPublisherBuilderImplTest {
  @Test
  void createSetter() {
    assertThat(new BodyPublisherBuilderImpl().createSetter())
        .isExactlyInstanceOf(BodyPublisherImpl.class);
  }

  @Test
  void setContentLength() throws IllegalAccessException, NoSuchFieldException {
    var bodyPublisherSetter = mock(BodyPublisherSetter.class);

    BodyPublisherBuilder bodyPublisherBuilder = new BodyPublisherBuilderImpl();
    Utils.setField(DefaultNodeBuilder.class, bodyPublisherBuilder, "setter", bodyPublisherSetter);

    var longAssert = mock(LongAssert.class);

    assertThat(bodyPublisherBuilder.setContentLength(longAssert)).isSameAs(bodyPublisherBuilder);
    verify(bodyPublisherSetter).setContentLength(longAssert);
  }
}
