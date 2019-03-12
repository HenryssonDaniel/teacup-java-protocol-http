package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.SETTING_THE;

import java.net.http.HttpRequest;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.teacup.core.assertion.LongAssert;

class BodyPublisherBuilderImpl
    extends BuilderImpl<
        HttpRequest.BodyPublisher, BodyPublisher, BodyPublisherSetter, BodyPublisherBuilder>
    implements BodyPublisherBuilder {
  private static final Logger LOGGER = Logger.getLogger(BodyPublisherBuilderImpl.class.getName());

  BodyPublisherBuilderImpl() {
    super(new BodyPublisherImpl());
  }

  @Override
  public BodyPublisherBuilder setContentLength(LongAssert contentLength) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "content length"));
    getSetter().setContentLength(contentLength);
    return this;
  }

  @Override
  protected BodyPublisherSetter createSetter() {
    return new BodyPublisherImpl();
  }
}
