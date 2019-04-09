package io.github.henryssondaniel.teacup.protocol.http.node;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ConstantsTest {
  @Test
  void settingThe() {
    assertThat(Constants.SETTING_THE).isEqualTo("Setting the {0}");
  }

  @Test
  void settingWhether() {
    assertThat(Constants.SETTING_WHETHER).isEqualTo("Setting whether {0} or not");
  }

  @Test
  void verify() {
    assertThat(Constants.VERIFY).isEqualTo("Verify the {0}");
  }
}
