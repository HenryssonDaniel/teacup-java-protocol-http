package io.github.henryssondaniel.teacup.protocol.http.node;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.github.henryssondaniel.teacup.core.assertion.GenericBooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericListAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericLongAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class DurationImplTest {
  private final Duration duration = Duration.ofDays(1L);
  private final DurationSetter durationSetter = new DurationImpl();
  private final GenericBooleanAssert<?> genericBooleanAssert = mock(GenericBooleanAssert.class);
  private final GenericIntegerAssert<?> genericIntegerAssert = mock(GenericIntegerAssert.class);
  private final GenericLongAssert<?> genericLongAssert = mock(GenericLongAssert.class);
  private final io.github.henryssondaniel.teacup.protocol.http.node.Duration newDuration =
      mock(io.github.henryssondaniel.teacup.protocol.http.node.Duration.class);

  @Mock
  private GenericListAssert<? super TemporalUnit, ? super List<? extends TemporalUnit>, ?>
      genericListAssert;

  @Mock private GenericObjectAssert<? super Duration, ?> genericObjectAssert;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void setAbs() {
    durationSetter.setAbs(newDuration);
    durationSetter.verify(duration);

    verify(newDuration).verify(duration);
  }

  @Test
  void setAssertion() {
    durationSetter.setAssertion(genericObjectAssert);
    durationSetter.verify(duration);

    verify(genericObjectAssert).verify(duration);
  }

  @Test
  void setNano() {
    durationSetter.setNano(genericIntegerAssert);
    durationSetter.verify(duration);

    verify(genericIntegerAssert).verify(duration.getNano());
  }

  @Test
  void setNegated() {
    durationSetter.setNegated(newDuration);
    durationSetter.verify(duration);

    verify(newDuration).verify(duration.negated());
  }

  @Test
  void setNegative() {
    durationSetter.setNegative(genericBooleanAssert);
    durationSetter.verify(duration);

    verify(genericBooleanAssert).verify(duration.isNegative());
  }

  @Test
  void setSeconds() {
    durationSetter.setSeconds(genericLongAssert);
    durationSetter.verify(duration);

    verify(genericLongAssert).verify(duration.getSeconds());
  }

  @Test
  void setToDays() {
    durationSetter.setToDays(genericLongAssert);
    durationSetter.verify(duration);

    verify(genericLongAssert).verify(duration.toDays());
  }

  @Test
  void setToDaysPart() {
    durationSetter.setToDaysPart(genericLongAssert);
    durationSetter.verify(duration);

    verify(genericLongAssert).verify(duration.toDaysPart());
  }

  @Test
  void setToHours() {
    durationSetter.setToHours(genericLongAssert);
    durationSetter.verify(duration);

    verify(genericLongAssert).verify(duration.toHours());
  }

  @Test
  void setToHoursPart() {
    durationSetter.setToHoursPart(genericIntegerAssert);
    durationSetter.verify(duration);

    verify(genericIntegerAssert).verify(duration.toHoursPart());
  }

  @Test
  void setToMillis() {
    durationSetter.setToMillis(genericLongAssert);
    durationSetter.verify(duration);

    verify(genericLongAssert).verify(duration.toMillis());
  }

  @Test
  void setToMillisPart() {
    durationSetter.setToMillisPart(genericIntegerAssert);
    durationSetter.verify(duration);

    verify(genericIntegerAssert).verify(duration.toMillisPart());
  }

  @Test
  void setToMinutes() {
    durationSetter.setToMinutes(genericLongAssert);
    durationSetter.verify(duration);

    verify(genericLongAssert).verify(duration.toMinutes());
  }

  @Test
  void setToMinutesPart() {
    durationSetter.setToMinutesPart(genericIntegerAssert);
    durationSetter.verify(duration);

    verify(genericIntegerAssert).verify(duration.toMinutesPart());
  }

  @Test
  void setToNanos() {
    durationSetter.setToNanos(genericLongAssert);
    durationSetter.verify(duration);

    verify(genericLongAssert).verify(duration.toNanos());
  }

  @Test
  void setToNanosPart() {
    durationSetter.setToNanosPart(genericIntegerAssert);
    durationSetter.verify(duration);

    verify(genericIntegerAssert).verify(duration.toNanosPart());
  }

  @Test
  void setToSeconds() {
    durationSetter.setToSeconds(genericLongAssert);
    durationSetter.verify(duration);

    verify(genericLongAssert).verify(duration.toSeconds());
  }

  @Test
  void setToSecondsPart() {
    durationSetter.setToSecondsPart(genericIntegerAssert);
    durationSetter.verify(duration);

    verify(genericIntegerAssert).verify(duration.toSecondsPart());
  }

  @Test
  void setUnits() {
    durationSetter.setUnits(genericListAssert);
    durationSetter.verify(duration);

    verify(genericListAssert).verify(duration.getUnits());
  }

  @Test
  void setZero() {
    durationSetter.setZero(genericBooleanAssert);
    durationSetter.verify(duration);

    verify(genericBooleanAssert).verify(duration.isZero());
  }
}
