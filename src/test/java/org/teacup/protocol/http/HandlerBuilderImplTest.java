package org.teacup.protocol.http;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import java.net.http.HttpResponse.PushPromiseHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class HandlerBuilderImplTest {
  @InjectMocks private final HandlerBuilder<String> handlerBuilder = new HandlerBuilderImpl<>(null);

  @Mock private HandlerSetter<String> implementation;
  @Mock private PushPromiseHandler<String> pushPromiseHandler;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createImplementation() {
    assertThat(new HandlerBuilderImpl<>(null).createImplementation())
        .isExactlyInstanceOf(HandlerImpl.class);
  }

  @Test
  void setPushPromiseHandler() {
    assertThat(handlerBuilder.setPushPromiseHandler(pushPromiseHandler)).isSameAs(handlerBuilder);
    verify(implementation).setPushPromiseHandler(pushPromiseHandler);
  }
}
