package io.github.henryssondaniel.teacup.protocol.http.client;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.PushPromiseHandler;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

class TestPushPromiseHandler implements PushPromiseHandler<String> {
  private static final Logger LOGGER = Logger.getLogger(TestPushPromiseHandler.class.getName());

  @Override
  public void applyPushPromise(
      HttpRequest initiatingRequest,
      HttpRequest pushPromiseRequest,
      Function<BodyHandler<String>, CompletableFuture<HttpResponse<String>>> acceptor) {
    LOGGER.log(Level.FINE, "Apply push promise");
  }
}
