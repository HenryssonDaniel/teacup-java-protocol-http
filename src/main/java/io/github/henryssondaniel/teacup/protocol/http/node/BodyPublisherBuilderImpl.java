package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericLongAssert;
import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.net.http.HttpRequest;
import java.util.logging.Level;
import java.util.logging.Logger;

class BodyPublisherBuilderImpl
    extends BuilderImpl<
        HttpRequest.BodyPublisher, BodyPublisher, BodyPublisherSetter, BodyPublisherBuilder>
    implements BodyPublisherBuilder {
  private static final Logger LOGGER = Factory.getLogger(BodyPublisherBuilderImpl.class);

  BodyPublisherBuilderImpl() {
    super(new BodyPublisherImpl());
  }

  @Override
  public BodyPublisherBuilder setContentLength(GenericLongAssert<?> contentLength) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "content length");
    getImplementation().setContentLength(contentLength);
    return this;
  }

  @Override
  protected BodyPublisherSetter createImplementation() {
    return new BodyPublisherImpl();
  }
}
