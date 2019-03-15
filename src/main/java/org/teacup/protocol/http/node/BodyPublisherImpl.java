package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.SETTING_THE;
import static org.teacup.protocol.http.node.Constants.VERIFY;

import java.net.http.HttpRequest.BodyPublisher;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.teacup.core.assertion.LongAssert;
import org.teacup.core.assertion.ObjectAssert;

class BodyPublisherImpl extends SetterImpl<BodyPublisher> implements BodyPublisherSetter {
  private static final Logger LOGGER = Logger.getLogger(BodyPublisherImpl.class.getName());
  private ObjectAssert<Long, ?> contentLength;

  @Override
  public void setContentLength(LongAssert<?> contentLength) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "content length"));
    this.contentLength = contentLength;
  }

  @Override
  public void verify(BodyPublisher bodyPublisher) {
    LOGGER.log(Level.FINE, String.format(VERIFY, "body publisher"));
    verifyAssertion(bodyPublisher, getAssertion());

    if (contentLength != null) contentLength.verify(bodyPublisher.contentLength());
  }

  private static void verifyAssertion(
      BodyPublisher bodyPublisher, ObjectAssert<? super BodyPublisher, ?> objectAssert) {
    if (objectAssert != null) objectAssert.verify(bodyPublisher);
  }
}
