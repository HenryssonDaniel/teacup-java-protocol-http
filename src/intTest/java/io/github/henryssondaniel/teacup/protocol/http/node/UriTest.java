package io.github.henryssondaniel.teacup.protocol.http.node;

import static io.github.henryssondaniel.teacup.core.assertion.Factory.createBooleanAssert;
import static io.github.henryssondaniel.teacup.core.assertion.Factory.createIntegerAssert;
import static io.github.henryssondaniel.teacup.core.assertion.Factory.createStringAssert;

import java.net.URI;
import org.junit.jupiter.api.Test;

class UriTest {
  private static final String LOCALHOST = "localhost";
  private static final String LOCALHOST_SCHEMA = "//localhost";

  @Test
  void verify() {
    Factory.createUriBuilder()
        .setAbsolute(createBooleanAssert().isTrue())
        .setAuthority(createStringAssert().isEqualTo(LOCALHOST))
        .setFragment(createStringAssert().isEqualTo(null))
        .setHost(createStringAssert().isEqualTo(LOCALHOST))
        .setOpaque(createBooleanAssert().isFalse())
        .setPath(createStringAssert().isEmpty())
        .setPort(createIntegerAssert().isEqualTo(-1))
        .setQuery(createStringAssert().isEqualTo(null))
        .setRawAuthority(createStringAssert().isEqualTo(LOCALHOST))
        .setRawFragment(createStringAssert().isEqualTo(null))
        .setRawPath(createStringAssert().isEmpty())
        .setRawQuery(createStringAssert().isEqualTo(null))
        .setRawSchemeSpecificPart(createStringAssert().isEqualTo(LOCALHOST_SCHEMA))
        .setRawUserInfo(createStringAssert().isEqualTo(null))
        .setScheme(createStringAssert().isEqualTo("http"))
        .setSchemeSpecificPart(createStringAssert().isEqualTo(LOCALHOST_SCHEMA))
        .setUserInfo(createStringAssert().isEqualTo(null))
        .build()
        .verify(URI.create("http://localhost"));
  }
}
