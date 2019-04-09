package io.github.henryssondaniel.teacup.protocol.http;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

class ConstantsTest {
  @Test
  void valueOf() {
    assertThatIllegalArgumentException().isThrownBy(() -> Constants.valueOf(Constants.ERROR_FETCH));
  }
}
