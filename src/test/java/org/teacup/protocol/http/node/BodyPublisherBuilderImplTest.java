package org.teacup.protocol.http.node;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.teacup.core.assertion.LongAssert;

class BodyPublisherBuilderImplTest {
  @InjectMocks
  private final BodyPublisherBuilder bodyPublisherBuilder = new BodyPublisherBuilderImpl();

  @Mock private BodyPublisherSetter setter;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createSetter() {
    assertThat(new BodyPublisherBuilderImpl().createSetter())
        .isExactlyInstanceOf(BodyPublisherImpl.class);
  }

  @Test
  void setContentLength() {
    var longAssert = mock(LongAssert.class);

    assertThat(bodyPublisherBuilder.setContentLength(longAssert)).isSameAs(bodyPublisherBuilder);
    verify(setter).setContentLength(longAssert);
  }
}
