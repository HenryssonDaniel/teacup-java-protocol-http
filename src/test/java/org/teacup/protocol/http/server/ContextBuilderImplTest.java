package org.teacup.protocol.http.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.sun.net.httpserver.Authenticator;
import com.sun.net.httpserver.Filter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ContextBuilderImplTest {
  @InjectMocks private final ContextBuilder contextBuilder = new ContextBuilderImpl(null, null);
  @Mock private ContextSetter implementation;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createImplementation() {
    assertThat(new ContextBuilderImpl(null, null).createImplementation())
        .isExactlyInstanceOf(ContextImpl.class);
  }

  @Test
  void setAttributes() {
    Map<String, Object> map = Collections.emptyMap();
    contextBuilder.setAttributes(map);
    verify(implementation).setAttributes(map);
  }

  @Test
  void setAuthenticator() {
    var authenticator = mock(Authenticator.class);
    contextBuilder.setAuthenticator(authenticator);
    verify(implementation).setAuthenticator(authenticator);
  }

  @Test
  void setFilters() {
    List<? extends Filter> filters = Collections.emptyList();
    contextBuilder.setFilters(filters);
    verify(implementation).setFilters(filters);
  }
}
