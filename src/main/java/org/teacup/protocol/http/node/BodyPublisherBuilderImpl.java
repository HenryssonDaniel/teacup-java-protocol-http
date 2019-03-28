package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.SETTING_THE;

import io.github.henryssondaniel.teacup.core.assertion.LongAssert;
import java.net.http.HttpRequest;
import java.util.logging.Level;
import java.util.logging.Logger;

class BodyPublisherBuilderImpl
    extends BuilderImpl<
        HttpRequest.BodyPublisher, BodyPublisher, BodyPublisherSetter, BodyPublisherBuilder>
    implements BodyPublisherBuilder {
  private static final Logger LOGGER = Logger.getLogger(BodyPublisherBuilderImpl.class.getName());

  BodyPublisherBuilderImpl() {
    super(new BodyPublisherImpl());
  }

  @Override
  public BodyPublisherBuilder setContentLength(LongAssert<?> contentLength) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "content length"));
    getImplementation().setContentLength(contentLength);
    return this;
  }

  @Override
  protected BodyPublisherSetter createImplementation() {
    return new BodyPublisherImpl();
  }
}
