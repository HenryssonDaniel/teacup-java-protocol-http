package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.LongAssert;
import io.github.henryssondaniel.teacup.core.assertion.ObjectAssert;
import java.net.http.HttpRequest.BodyPublisher;
import java.util.logging.Level;
import java.util.logging.Logger;

class BodyPublisherImpl extends SetterImpl<BodyPublisher> implements BodyPublisherSetter {
  private static final Logger LOGGER = Logger.getLogger(BodyPublisherImpl.class.getName());
  private ObjectAssert<Long, ?> contentLength;

  @Override
  public void setContentLength(LongAssert<?> contentLength) {
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
      BodyPublisher bodyPublisher, ObjectAssert<? super BodyPublisher, ?> objectAssert) {
    if (objectAssert != null) objectAssert.verify(bodyPublisher);
  }
}
