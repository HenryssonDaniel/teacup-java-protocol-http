package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericLongAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import java.net.http.HttpRequest.BodyPublisher;
import java.util.logging.Level;
import java.util.logging.Logger;

class BodyPublisherImpl extends SetterImpl<BodyPublisher> implements BodyPublisherSetter {
  private static final Logger LOGGER = Logger.getLogger(BodyPublisherImpl.class.getName());
  private GenericObjectAssert<Long, ?> contentLength;

  @Override
  public void setContentLength(GenericLongAssert<?> contentLength) {
    LOGGER.log(Level.FINE, String.format(Constants.SETTING_THE, "content length"));
    this.contentLength = contentLength;
  }

  @Override
  public void verify(BodyPublisher bodyPublisher) {
    LOGGER.log(Level.FINE, String.format(Constants.VERIFY, "body publisher"));
    verifyAssertion(bodyPublisher, getAssertion());

    if (contentLength != null) contentLength.verify(bodyPublisher.contentLength());
  }

  private static void verifyAssertion(
      BodyPublisher bodyPublisher, GenericObjectAssert<? super BodyPublisher, ?> objectAssert) {
    if (objectAssert != null) objectAssert.verify(bodyPublisher);
  }
}
