package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.BUILD;
import static org.teacup.protocol.http.node.Constants.SETTING_THE;

import java.net.http.HttpRequest;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.teacup.core.assertion.LongAssert;
import org.teacup.core.assertion.ObjectAssert;

class BodyPublisherBuilderImpl implements BodyPublisherBuilder {
  private static final Logger LOGGER = Logger.getLogger(BodyPublisherBuilderImpl.class.getName());
  private BodyPublisherSetter bodyPublisherSetter = new BodyPublisherImpl();

  @Override
  public BodyPublisher build() {
    LOGGER.log(Level.FINE, String.format(BUILD, "body publisher"));

    BodyPublisher bodyPublisher = bodyPublisherSetter;
    bodyPublisherSetter = new BodyPublisherImpl();

    return bodyPublisher;
  }

  @Override
  public BodyPublisherBuilder setAssertion(ObjectAssert<HttpRequest.BodyPublisher, ?> assertion) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "assertion"));
    bodyPublisherSetter.setAssertion(assertion);
    return this;
  }

  @Override
  public BodyPublisherBuilder setContentLength(LongAssert contentLength) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "content length"));
    bodyPublisherSetter.setContentLength(contentLength);
    return this;
  }
}
