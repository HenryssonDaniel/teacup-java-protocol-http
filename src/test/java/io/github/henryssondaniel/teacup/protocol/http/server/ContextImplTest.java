package io.github.henryssondaniel.teacup.protocol.http.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import com.sun.net.httpserver.Authenticator;
import com.sun.net.httpserver.Filter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ContextImplTest {
  private static final String PATH = "path";
  private final Response response = mock(Response.class);

  private final ContextSetter contextSetter = new ContextImpl(PATH, response);

  @Test
  void getAttributes() {
    assertThat(contextSetter.getAttributes()).isEmpty();
  }

  @Test
  void getAuthenticator() {
    assertThat(contextSetter.getAuthenticator()).isNull();
  }

  @Test
  void getFilters() {
    assertThat(contextSetter.getFilters()).isEmpty();
  }

  @Test
  void getPath() {
    assertThat(contextSetter.getPath()).isSameAs(PATH);
  }

  @Test
  void getResponse() {
    assertThat(contextSetter.getResponse()).isSameAs(response);
  }

  @Test
  void setAndGetAttributes() {
    Map<String, Object> map = Collections.emptyMap();
    contextSetter.setAttributes(map);
    assertThat(contextSetter.getAttributes()).isEqualTo(map);
  }

  @Test
  void setAndGetAuthenticator() {
    var authenticator = mock(Authenticator.class);
    contextSetter.setAuthenticator(authenticator);
    assertThat(contextSetter.getAuthenticator()).isSameAs(authenticator);
  }

  @Test
  void setAndGetFilters() {
    List<? extends Filter> filters = Collections.emptyList();
    contextSetter.setFilters(filters);
    assertThat(contextSetter.getFilters()).isEqualTo(filters);
  }
}
