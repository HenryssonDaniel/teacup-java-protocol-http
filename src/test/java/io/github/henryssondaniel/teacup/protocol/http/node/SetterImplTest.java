package io.github.henryssondaniel.teacup.protocol.http.node;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.henryssondaniel.teacup.core.assertion.ObjectAssert;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class SetterImplTest {
  private static final Logger LOGGER = Logger.getLogger(SetterImplTest.class.getName());
  private final Setter<String> setter = new TestSetterImpl();
  @Mock private ObjectAssert<? super String, ?> objectAssert;

  @Test
  void getAndSetAssertion() {
    setter.setAssertion(objectAssert);
    assertThat(setter.getAssertion()).isSameAs(objectAssert);
  }

  @Test
  void getAssertion() {
    assertThat(setter.getAssertion()).isNull();
  }

  private static final class TestSetterImpl extends SetterImpl<String> {
    @Override
    public void verify(String actual) {
      LOGGER.log(Level.FINE, String.format(Constants.VERIFY, "test"));
    }
  }
}
