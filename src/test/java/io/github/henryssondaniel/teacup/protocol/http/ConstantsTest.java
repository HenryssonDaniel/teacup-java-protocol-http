package io.github.henryssondaniel.teacup.protocol.http;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ConstantsTest {
  @Test
  void errorFetch() {
    assertThat(Constants.ERROR_FETCH).isEqualTo("Could not fetch the peer %s");
  }
}
