package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.BUILD;
import static org.teacup.protocol.http.node.Constants.SETTING_THE;

import java.net.http.HttpRequest.BodyPublisher;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.teacup.core.assertion.LongAssert;
import org.teacup.core.assertion.ObjectAssert;

class BodyPublisherNodeBuilderImpl implements BodyPublisherNodeBuilder {
  private static final Logger LOGGER =
      Logger.getLogger(BodyPublisherNodeBuilderImpl.class.getName());
  private BodyPublisherNodeSetter bodyPublisherNodeSetter = new BodyPublisherNodeImpl();

  @Override
  public BodyPublisherNode build() {
    LOGGER.log(Level.FINE, String.format(BUILD, "body publisher"));

    BodyPublisherNode bodyPublisherNode = bodyPublisherNodeSetter;
    bodyPublisherNodeSetter = new BodyPublisherNodeImpl();

    return bodyPublisherNode;
  }

  @Override
  public BodyPublisherNodeBuilder setAssertion(ObjectAssert<BodyPublisher, ?> assertion) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "assertion"));
    bodyPublisherNodeSetter.setAssertion(assertion);
    return this;
  }

  @Override
  public BodyPublisherNodeBuilder setContentLength(LongAssert contentLength) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "content length"));
    bodyPublisherNodeSetter.setContentLength(contentLength);
    return this;
  }
}
