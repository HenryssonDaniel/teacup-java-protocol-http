package io.github.henryssondaniel.teacup.protocol.http.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import com.sun.net.httpserver.Authenticator;
import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class SimpleImplTest {
  private final Context context = mock(Context.class);
  private final Handler handler = mock(Handler.class);
  private final HttpContext httpContext = mock(HttpContext.class);
  private final HttpServer httpServer = mock(HttpServer.class);
  private final Response response = mock(Response.class);
  private final SimpleImpl simpleImpl = new SimpleImpl(httpServer);

  @Mock private io.github.henryssondaniel.teacup.protocol.server.Handler<Request> requestHandler;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);

    when(context.getResponse()).thenReturn(response);
    when(httpContext.getHandler()).thenReturn(handler);
  }

  @Test
  void createProtocolContext() {
    when(httpServer.createContext(isNull(), any(HandlerImpl.class))).thenReturn(httpContext);

    assertThat(simpleImpl.createProtocolContext(context, requestHandler)).isNotNull();

    verify(context).getAttributes();
    verify(context).getAuthenticator();
    verify(context).getFilters();
    verify(context).getPath();
    verify(context).getResponse();
    verifyNoMoreInteractions(context);

    verify(httpContext).getAttributes();
    verify(httpContext).getFilters();
    verify(httpContext).setAuthenticator(null);
    verifyNoMoreInteractions(httpContext);

    verifyNoInteractions(requestHandler);

    verify(httpServer).createContext(isNull(), any(HandlerImpl.class));
    verifyNoMoreInteractions(httpServer);
  }

  @Test
  void getKey() {
    assertThat(simpleImpl.getKey(context)).isNull();

    verify(context).getPath();
    verifyNoMoreInteractions(context);

    verifyNoInteractions(httpServer);
  }

  @Test
  void isEquals() {
    when(handler.getResponse()).thenReturn(response);

    assertThat(simpleImpl.isEquals(context, httpContext)).isTrue();

    verify(context).getAttributes();
    verify(context).getAuthenticator();
    verify(context).getFilters();
    verify(context).getResponse();
    verifyNoMoreInteractions(context);

    verify(httpContext).getAttributes();
    verify(httpContext).getAuthenticator();
    verify(httpContext).getFilters();
    verify(httpContext).getHandler();
    verifyNoMoreInteractions(httpContext);

    verify(handler).getResponse();
    verifyNoMoreInteractions(handler);

    verifyNoInteractions(httpServer);
    verifyNoInteractions(response);
  }

  @Test
  void isEqualsWhenAttributesNotEqual() {
    when(context.getAttributes()).thenReturn(Collections.singletonMap("key", "value"));

    assertThat(simpleImpl.isEquals(context, httpContext)).isFalse();

    verify(context).getAttributes();
    verifyNoMoreInteractions(context);

    verify(httpContext).getAttributes();
    verifyNoMoreInteractions(httpContext);

    verifyNoInteractions(handler);
    verifyNoInteractions(httpServer);
  }

  @Test
  void isEqualsWhenAuthenticatorNotEqual() {
    var authenticator = mock(Authenticator.class);
    when(context.getAuthenticator()).thenReturn(authenticator);

    assertThat(simpleImpl.isEquals(context, httpContext)).isFalse();

    verify(context).getAttributes();
    verify(context).getAuthenticator();
    verifyNoMoreInteractions(context);

    verify(httpContext).getAttributes();
    verify(httpContext).getAuthenticator();
    verifyNoMoreInteractions(httpContext);

    verifyNoInteractions(handler);
    verifyNoInteractions(httpServer);
  }

  @Test
  void isEqualsWhenFiltersNotEqual() {
    var filter = mock(Filter.class);
    when(context.getFilters()).thenReturn(Collections.singletonList(filter));

    assertThat(simpleImpl.isEquals(context, httpContext)).isFalse();

    verify(context).getAttributes();
    verify(context).getAuthenticator();
    verify(context).getFilters();
    verifyNoMoreInteractions(context);

    verifyNoInteractions(filter);

    verify(httpContext).getAttributes();
    verify(httpContext).getAuthenticator();
    verify(httpContext).getFilters();
    verifyNoMoreInteractions(httpContext);

    verifyNoInteractions(handler);
    verifyNoInteractions(httpServer);
  }

  @Test
  void isEqualsWhenResponseNotEqual() {
    assertThat(simpleImpl.isEquals(context, httpContext)).isFalse();

    verify(context).getAttributes();
    verify(context).getAuthenticator();
    verify(context).getFilters();
    verify(context).getResponse();
    verifyNoMoreInteractions(context);

    verify(httpContext).getAttributes();
    verify(httpContext).getAuthenticator();
    verify(httpContext).getFilters();
    verify(httpContext).getHandler();
    verifyNoMoreInteractions(httpContext);

    verify(handler).getResponse();
    verifyNoMoreInteractions(handler);

    verifyNoInteractions(httpServer);
    verifyNoInteractions(response);
  }

  @Test
  void serverCleanup() {
    simpleImpl.serverCleanup(httpContext);

    verifyNoInteractions(httpContext);

    verify(httpServer).removeContext(httpContext);
    verifyNoMoreInteractions(httpServer);
  }

  @Test
  void setUp() {
    simpleImpl.setUp();

    verify(httpServer).start();
    verifyNoMoreInteractions(httpServer);
  }

  @Test
  void tearDown() {
    simpleImpl.tearDown();

    verify(httpServer).stop(0);
    verifyNoMoreInteractions(httpServer);
  }
}
