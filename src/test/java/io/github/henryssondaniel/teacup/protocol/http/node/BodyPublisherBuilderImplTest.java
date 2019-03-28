package io.github.henryssondaniel.teacup.protocol.http.node;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.github.henryssondaniel.teacup.core.assertion.LongAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class BodyPublisherBuilderImplTest {
  @InjectMocks
  private final BodyPublisherBuilder bodyPublisherBuilder = new BodyPublisherBuilderImpl();

  @Mock private BodyPublisherSetter implementation;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createImplementation() {
    assertThat(new BodyPublisherBuilderImpl().createImplementation())
        .isExactlyInstanceOf(BodyPublisherImpl.class);
  }

  @Test
  void setContentLength() {
    var longAssert = mock(LongAssert.class);

    assertThat(bodyPublisherBuilder.setContentLength(longAssert)).isSameAs(bodyPublisherBuilder);
    verify(implementation).setContentLength(longAssert);
  }
}
