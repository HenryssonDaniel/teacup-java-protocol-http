package io.github.henryssondaniel.teacup.protocol.http.server;

import static org.assertj.core.api.Assertions.assertThat;

import com.sun.net.httpserver.Authenticator;
import com.sun.net.httpserver.BasicAuthenticator;
import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.HttpExchange;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

class ContextTest {
  private static final int CODE = 200;

  @Test
  void createContextBuilder() {
    Map<String, Object> attributes = Collections.singletonMap("key", "value");
    Authenticator authenticator = new TestBasicAuthenticator();
    List<? extends Filter> filters = Collections.singletonList(new TestFilter());
    var path = "path";
    var response = Factory.createResponseBuilder(CODE, 0L).build();

    var context =
        Factory.createContextBuilder(path, response)
            .setAttributes(attributes)
            .setAuthenticator(authenticator)
            .setFilters(filters)
            .build();
    assertThat(context.getAttributes()).isEqualTo(attributes);
    assertThat(context.getAuthenticator()).isSameAs(authenticator);
    assertThat(context.getFilters()).isEqualTo(filters);
    assertThat(context.getPath()).isSameAs(path);
    assertThat(context.getResponse()).isSameAs(response);
  }

  private static final class TestBasicAuthenticator extends BasicAuthenticator {
    private static final Logger LOGGER = Logger.getLogger(TestBasicAuthenticator.class.getName());

    private TestBasicAuthenticator() {
      super("realm");
    }

    @Override
    public boolean checkCredentials(String username, String password) {
      LOGGER.log(Level.FINE, "Check credentials");
      return false;
    }
  }

  private static final class TestFilter extends Filter {
    private static final Logger LOGGER = Logger.getLogger(TestFilter.class.getName());

    @Override
    public String description() {
      LOGGER.log(Level.FINE, "Description");
      return "description";
    }

    @Override
    public void doFilter(HttpExchange exchange, Chain chain) {
      LOGGER.log(Level.FINE, "Do filter");
    }
  }
}
