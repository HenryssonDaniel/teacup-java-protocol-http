package org.teacup.protocol.http.server;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

class SimpleImpl implements Simple {
  private static final Logger LOGGER = Logger.getLogger(SimpleImpl.class.getName());

  private final Object lock = new Object();
  private final Map<String, HttpContext> map = new HashMap<>(0);

  private HttpServer httpServer;
  private boolean waiting;

  SimpleImpl(int backlog, String host, int port) {
    try {
      httpServer = HttpServer.create(new InetSocketAddress(host, port), backlog);
    } catch (IOException e) {
      LOGGER.log(Level.SEVERE, "Could not create the server", e);
    }
  }

  @Override
  public void removeSupplier(Supplier<List<Request>> supplier) {
    LOGGER.log(Level.FINE, "Remove supplier");
    if (supplier instanceof TimeoutSupplier) ((TimeoutSupplier) supplier).stop();
  }

  @Override
  public Supplier<List<Request>> setContext(Context context) {
    TimeoutSupplier timeoutSupplier = new TimeoutSupplierImpl();

    try {
      var httpContext = addSupplier(context, timeoutSupplier);
      timeoutSupplier.whenStopped(consumer -> cleanup(httpContext, timeoutSupplier));
    } catch (InterruptedException e) {
      LOGGER.log(Level.SEVERE, "The server got interrupted", e);
    }

    return timeoutSupplier;
  }

  @Override
  public void setUp() {
    LOGGER.log(Level.FINE, "Set up");

    synchronized (lock) {
      httpServer.start();
    }
  }

  @Override
  public void tearDown() {
    LOGGER.log(Level.FINE, "Tear down");

    synchronized (lock) {
      httpServer.stop(0);
    }
  }

  private HttpContext addSupplier(Context context, TimeoutSupplier timeoutSupplier)
      throws InterruptedException {
    HttpContext httpContext;

    var path = context.getPath();
    synchronized (lock) {
      httpContext =
          map.containsKey(path)
              ? tryAddSupplier(context, timeoutSupplier)
              : createHttpContext(context, timeoutSupplier);
    }

    return httpContext;
  }

  private void cleanup(HttpContext httpContext, TimeoutSupplier timeoutSupplier) {
    var handler = (Handler) httpContext.getHandler();
    handler.removeTimeoutSupplier(timeoutSupplier);

    if (handler.getTimeoutSuppliers().isEmpty())
      synchronized (lock) {
        httpServer.removeContext(httpContext);
        map.remove(httpContext.getPath());
        waiting = false;
        lock.notifyAll();
      }
  }

  private HttpContext createHttpContext(Context context, TimeoutSupplier timeoutSupplier) {
    var path = context.getPath();

    var httpContext =
        httpServer.createContext(path, new HandlerImpl(context.getResponse(), timeoutSupplier));
    setupHttpContext(context, httpContext);

    map.put(path, httpContext);

    return httpContext;
  }

  private static boolean isEquals(Context context, HttpContext httpContext) {
    return context.getAttributes().equals(httpContext.getAttributes())
        && context.getAuthenticator().equals(httpContext.getAuthenticator());
  }

  private static boolean isEquals(Context context, HttpContext httpContext, Response response) {
    return isEquals(context, httpContext)
        && context.getFilters().equals(httpContext.getFilters())
        && context.getResponse().equals(response);
  }

  private HttpContext retryAddSupplier(Context context, TimeoutSupplier timeoutSupplier)
      throws InterruptedException {
    HttpContext httpContext;

    synchronized (lock) {
      while (waiting) lock.wait(1L);

      httpContext = addSupplier(context, timeoutSupplier);
      waiting = true;
    }

    return httpContext;
  }

  private static void setFilters(Context context, HttpContext httpContext) {
    httpContext.getFilters().addAll(context.getFilters());
  }

  private static void setupHttpContext(Context context, HttpContext httpContext) {
    httpContext.getAttributes().putAll(context.getAttributes());
    httpContext.setAuthenticator(context.getAuthenticator());
    setFilters(context, httpContext);
  }

  private HttpContext tryAddSupplier(Context context, TimeoutSupplier timeoutSupplier)
      throws InterruptedException {
    var httpContext = map.get(context.getPath());

    var handler = (Handler) httpContext.getHandler();
    if (isEquals(context, httpContext, handler.getResponse()))
      handler.addTimeoutSupplier(timeoutSupplier);
    else httpContext = retryAddSupplier(context, timeoutSupplier);

    return httpContext;
  }
}
