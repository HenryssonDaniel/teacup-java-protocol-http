package org.teacup.protocol.http.server;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import com.sun.net.httpserver.Authenticator;
import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class SimpleImplTest {
  private final Authenticator authenticator = mock(Authenticator.class);
  private final Context context = mock(Context.class);
  private final Handler handler = mock(Handler.class);
  private final HttpContext httpContext = mock(HttpContext.class);
  private final HttpServer httpServer = mock(HttpServer.class);
  private final Object lock = new Object();
  private final Simple simple = new SimpleImpl(httpServer);
  private final TimeoutSupplier timeoutSupplier = mock(TimeoutSupplier.class);
  private final Object verifyLock = new Object();

  @Mock private Supplier<List<Request>> supplierNonExisting;
  private boolean waitVerify = true;
  private boolean waiting = true;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void removeSupplier() {
    simple.removeSupplier(supplierNonExisting);
    verifyZeroInteractions(supplierNonExisting);
  }

  @Test
  void removeSupplierWhenTimeoutSupplier() {
    simple.removeSupplier(timeoutSupplier);
    verify(timeoutSupplier).stop();
  }

  @Test
  void setContext() {
    setFirstContext();

    synchronized (lock) {
      verify(httpServer).createContext(isNull(), any(HttpHandler.class));
    }
  }

  @Test
  void setContextWhenDuplicateContext() {
    setFirstContext();
    simple.setContext(context);

    synchronized (verifyLock) {
      verify(handler, never()).removeTimeoutSupplier(any(TimeoutSupplier.class));
      verify(httpServer).createContext(isNull(), any(HttpHandler.class));
      verify(httpServer, never()).removeContext(httpContext);
    }
  }

  @Test
  void setContextWhenInterrupted() throws InterruptedException {
    var supplier = setFirstContext();
    var thread = createThread();

    doAnswer(invocationOnMock -> waiting(Collections.singletonList(timeoutSupplier)))
        .when(handler)
        .getTimeoutSuppliers();
    removeSupplier(supplier);
    interrupt(thread);

    synchronized (verifyLock) {
      while (waitVerify) verifyLock.wait(1L);

      verify(handler).removeTimeoutSupplier(any(TimeoutSupplier.class));
      verify(httpServer).createContext(isNull(), any(HttpHandler.class));
      verify(httpServer, never()).removeContext(httpContext);
    }
  }

  @Test
  void setContextWhenUnequalAttributes() throws InterruptedException {
    Map<String, Object> map = new HashMap<>(1);
    map.put("", "");

    var supplier = setFirstContext();

    var thread =
        new Thread(
            () -> {
              doAnswer(invocationOnMock -> waiting(map)).when(httpContext).getAttributes();

              setSecondContext();
            });
    thread.start();

    removeSupplier(supplier);

    verifyMocks();
  }

  @Test
  void setContextWhenUnequalAuthenticator() throws InterruptedException {
    var supplier = setFirstContext();

    createThread();
    removeSupplier(supplier);
    verifyMocks();
  }

  @Test
  void setContextWhenUnequalFilters() throws InterruptedException {
    var filter = mock(Filter.class);

    Collection<Filter> filters = new ArrayList<>(1);
    filters.add(filter);

    var supplier = setFirstContext();

    var thread =
        new Thread(
            () -> {
              doAnswer(invocationOnMock -> waiting(filters)).when(httpContext).getFilters();
              setSecondContext();
            });
    thread.start();

    removeSupplier(supplier);

    verifyMocks();
  }

  @Test
  void setContextWhenUnequalResponse() throws InterruptedException {
    var response = mock(Response.class);
    var supplier = setFirstContext();

    var thread =
        new Thread(
            () -> {
              doAnswer(invocationOnMock -> waiting(response)).when(context).getResponse();
              setSecondContext();
            });
    thread.start();

    removeSupplier(supplier);

    verifyMocks();
  }

  @Test
  void setUp() {
    simple.setUp();

    synchronized (lock) {
      verify(httpServer).start();
    }
  }

  @Test
  void tearDown() {
    simple.tearDown();

    synchronized (lock) {
      verify(httpServer).stop(0);
    }
  }

  private Thread createThread() {
    var thread =
        new Thread(
            () -> {
              doAnswer(invocationOnMock -> waiting(null)).when(httpContext).getAuthenticator();
              setSecondContext();
            });
    thread.start();

    return thread;
  }

  private void interrupt(Thread thread) throws InterruptedException {
    synchronized (lock) {
      while (waiting) lock.wait(1L);

      thread.interrupt();
    }
  }

  private void removeSupplier(Supplier<List<Request>> supplier) throws InterruptedException {
    synchronized (lock) {
      while (waiting) lock.wait(1L);

      simple.removeSupplier(supplier);
    }
  }

  private Supplier<List<Request>> setFirstContext() {
    var response = mock(Response.class);

    when(context.getResponse()).thenReturn(response);
    when(context.getAuthenticator()).thenReturn(authenticator);

    when(handler.getResponse()).thenReturn(response);

    when(httpContext.getAuthenticator()).thenReturn(authenticator);
    when(httpContext.getHandler()).thenReturn(handler);

    synchronized (lock) {
      when(httpServer.createContext(eq(context.getPath()), any(HandlerImpl.class)))
          .thenReturn(httpContext);
    }

    return simple.setContext(context);
  }

  private void setSecondContext() {
    synchronized (verifyLock) {
      simple.setContext(context);
      waitVerify = false;
      verifyLock.notifyAll();
    }
  }

  private void verifyMocks() throws InterruptedException {
    synchronized (verifyLock) {
      while (waitVerify) verifyLock.wait(1L);

      verify(handler).removeTimeoutSupplier(any(TimeoutSupplier.class));
      verify(httpServer, times(2)).createContext(isNull(), any(HttpHandler.class));
      verify(httpServer).removeContext(httpContext);
    }
  }

  private Object waiting(Object object) {
    synchronized (lock) {
      waiting = false;
      lock.notifyAll();
    }

    return object;
  }
}
