package io.github.henryssondaniel.teacup.protocol.http.node;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

class ConstantsTest {
  @Test
  void valueOf() {
    assertThatIllegalArgumentException().isThrownBy(() -> Constants.valueOf(Constants.SETTING_THE));
  }
}
