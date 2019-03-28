package org.teacup.protocol.http.node;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.github.henryssondaniel.teacup.core.assertion.LongAssert;
import io.github.henryssondaniel.teacup.core.assertion.ObjectAssert;
import java.net.http.HttpRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class BodyPublisherImplTest {
  private final HttpRequest.BodyPublisher bodyPublisher = mock(HttpRequest.BodyPublisher.class);
  private final BodyPublisherSetter bodyPublisherSetter = new BodyPublisherImpl();

  @Mock private ObjectAssert<? super HttpRequest.BodyPublisher, ?> objectAssert;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void setAssertion() {
    bodyPublisherSetter.setAssertion(objectAssert);
    bodyPublisherSetter.verify(bodyPublisher);

    verify(bodyPublisher, never()).contentLength();
    verify(objectAssert).verify(bodyPublisher);
  }

  @Test
  void setContentLength() {
    LongAssert<?> longAssert = mock(LongAssert.class);
    bodyPublisherSetter.setContentLength(longAssert);

    var contentLength = 1L;
    when(bodyPublisher.contentLength()).thenReturn(contentLength);

    bodyPublisherSetter.verify(bodyPublisher);

    verify(bodyPublisher).contentLength();
    verify(longAssert).verify(contentLength);
  }
}
