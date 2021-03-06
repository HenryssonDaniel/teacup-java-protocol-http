package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericLongAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.net.http.HttpRequest.BodyPublisher;
import java.util.logging.Level;
import java.util.logging.Logger;

class BodyPublisherImpl extends SetterImpl<BodyPublisher, GenericObjectAssert<BodyPublisher, ?>>
    implements BodyPublisherSetter {
  private static final Logger LOGGER = Factory.getLogger(BodyPublisherImpl.class);
  private GenericObjectAssert<Long, ?> contentLength;

  @Override
  public void setContentLength(GenericLongAssert<?> contentLength) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "content length");
    this.contentLength = contentLength;
  }

  @Override
  public void verify(BodyPublisher bodyPublisher) {
    LOGGER.log(Level.FINE, Constants.VERIFY, "body publisher");
    verifyAssertion(bodyPublisher, getAssertion());

    if (contentLength != null) contentLength.verify(bodyPublisher.contentLength());
  }

  private static void verifyAssertion(
      BodyPublisher bodyPublisher, GenericObjectAssert<? super BodyPublisher, ?> objectAssert) {
    if (objectAssert != null) objectAssert.verify(bodyPublisher);
  }
}
