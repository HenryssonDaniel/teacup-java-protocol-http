package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.SETTING_THE;
import static org.teacup.protocol.http.node.Constants.VERIFY;

import java.net.http.HttpRequest.BodyPublisher;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.teacup.core.assertion.LongAssert;
import org.teacup.core.assertion.ObjectAssert;

class BodyPublisherNodeImpl implements BodyPublisherNodeSetter {
  private static final Logger LOGGER = Logger.getLogger(BodyPublisherNodeImpl.class.getName());

  private ObjectAssert<? super BodyPublisher, ?> assertion;
  private ObjectAssert<Long, LongAssert> contentLength;

  @Override
  public void setAssertion(ObjectAssert<? super BodyPublisher, ?> assertion) {
    this.assertion = assertion;
  }

  @Override
  public void setContentLength(LongAssert contentLength) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "content length"));
    this.contentLength = contentLength;
  }

  @Override
  public void verify(BodyPublisher bodyPublisher) {
    LOGGER.log(Level.FINE, String.format(VERIFY, "body publisher"));

    if (assertion != null) assertion.verify(bodyPublisher);
    if (contentLength != null) contentLength.verify(bodyPublisher.contentLength());
  }
}
