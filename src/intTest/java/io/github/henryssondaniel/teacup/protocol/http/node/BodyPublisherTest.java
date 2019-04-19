package io.github.henryssondaniel.teacup.protocol.http.node;

import static io.github.henryssondaniel.teacup.core.assertion.Factory.createLongAssert;

import java.net.http.HttpRequest.BodyPublishers;
import org.junit.jupiter.api.Test;

class BodyPublisherTest {
  private static final long VALUE = 4L;

  @Test
  void verify() {
    Factory.createBodyPublisherBuilder()
        .setContentLength(createLongAssert().isEqualTo(VALUE))
        .build()
        .verify(BodyPublishers.ofString("body"));
  }
}
