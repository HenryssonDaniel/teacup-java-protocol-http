package io.github.henryssondaniel.teacup.protocol.http.node;

import static io.github.henryssondaniel.teacup.core.assertion.Factory.createIntegerAssert;
import static io.github.henryssondaniel.teacup.core.assertion.Factory.createObjectAssert;

import java.util.Collections;
import org.junit.jupiter.api.Test;

class SslSessionContextTest {
  @Test
  void verify() {
    Factory.createSslSessionContextBuilder()
        .setIds(createObjectAssert().isEqualTo(Collections.emptyEnumeration()))
        .setSessionCacheSize(createIntegerAssert().isEqualTo(0))
        .setSessionTimeout(createIntegerAssert().isEqualTo(0))
        .build()
        .verify(new TestSslSessionContext());
  }
}
