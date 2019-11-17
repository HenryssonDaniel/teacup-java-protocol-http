package io.github.henryssondaniel.teacup.protocol.http.server;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import io.github.henryssondaniel.teacup.core.logging.Factory;
import io.github.henryssondaniel.teacup.protocol.server.Base;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

class SimpleImpl extends Base<Context, HttpContext, Request> implements SimpleBase {
  private static final Logger LOGGER = Factory.getLogger(SimpleImpl.class);
  private final HttpServer httpServer;

  SimpleImpl(HttpServer httpServer) {
    this.httpServer = httpServer;
  }

  @Override
  public HttpContext createProtocolContext(
      Context context, io.github.henryssondaniel.teacup.protocol.server.Handler<Request> handler) {
    LOGGER.log(Level.FINE, "Create protocol context");

    var httpContext =
        httpServer.createContext(
            context.getPath(), new HandlerImpl(handler, context.getResponse()));
    httpContext.getAttributes().putAll(context.getAttributes());
    httpContext.setAuthenticator(context.getAuthenticator());
    httpContext.getFilters().addAll(context.getFilters());

    return httpContext;
  }

  @Override
  public String getKey(Context context) {
    LOGGER.log(Level.FINE, "Get key");
    return context.getPath();
  }

  @Override
  public boolean isEquals(Context context, HttpContext protocolContext) {
    LOGGER.log(Level.FINE, "Is equals");
    return equals(context, protocolContext)
        && context.getFilters().equals(protocolContext.getFilters())
        && context.getResponse().equals(((Handler) protocolContext.getHandler()).getResponse());
  }

  @Override
  public void serverCleanup(HttpContext protocolContext) {
    LOGGER.log(Level.FINE, "Server cleanup");
    httpServer.removeContext(protocolContext);
  }

  @Override
  public void setUp() {
    LOGGER.log(Level.FINE, "Set up");
    httpServer.start();
  }

  @Override
  public void tearDown() {
    LOGGER.log(Level.FINE, "Tear down");
    httpServer.stop(0);
  }

  private static boolean equals(Context context, HttpContext httpContext) {
    return context.getAttributes().equals(httpContext.getAttributes())
        && Objects.equals(context.getAuthenticator(), httpContext.getAuthenticator());
  }
}
