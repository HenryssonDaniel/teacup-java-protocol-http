package io.github.henryssondaniel.teacup.protocol.http.server;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import io.github.henryssondaniel.teacup.core.logging.Factory;
import io.github.henryssondaniel.teacup.protocol.server.Base;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

class SimpleImpl extends Base<Context, HttpContext, Request> {
  private static final Logger LOGGER = Factory.getLogger(SimpleImpl.class);
  private final HttpServer httpServer;

  SimpleImpl(HttpServer httpServer) {
    this.httpServer = httpServer;
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

  @Override
  protected HttpContext createProtocolContext(
      Context context, io.github.henryssondaniel.teacup.protocol.server.Handler<Request> handler) {
    var httpContext =
        httpServer.createContext(
            context.getPath(), new HandlerImpl(handler, context.getResponse()));
    httpContext.getAttributes().putAll(context.getAttributes());
    httpContext.setAuthenticator(context.getAuthenticator());
    httpContext.getFilters().addAll(context.getFilters());

    return httpContext;
  }

  @Override
  protected String getKey(Context context) {
    return context.getPath();
  }

  @Override
  protected boolean isEquals(Context context, HttpContext protocolContext) {
    return equals(context, protocolContext)
        && context.getFilters().equals(protocolContext.getFilters())
        && context.getResponse().equals(((Handler) protocolContext.getHandler()).getResponse());
  }

  @Override
  protected void serverCleanup(HttpContext protocolContext) {
    httpServer.removeContext(protocolContext);
  }

  private static boolean equals(Context context, HttpContext httpContext) {
    return context.getAttributes().equals(httpContext.getAttributes())
        && Objects.equals(context.getAuthenticator(), httpContext.getAuthenticator());
  }
}
