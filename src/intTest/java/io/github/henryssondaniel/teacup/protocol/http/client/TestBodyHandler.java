package io.github.henryssondaniel.teacup.protocol.http.client;

import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodySubscriber;
import java.net.http.HttpResponse.BodySubscribers;
import java.net.http.HttpResponse.ResponseInfo;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

class TestBodyHandler implements BodyHandler<String> {
  private static final Logger LOGGER = Logger.getLogger(TestBodyHandler.class.getName());

  @Override
  public BodySubscriber<String> apply(ResponseInfo responseInfo) {
    LOGGER.log(Level.FINE, "Apply");
    return BodySubscribers.ofString(Charset.defaultCharset());
  }
}
