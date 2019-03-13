package org.teacup.protocol.http.node;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.ListAssert;
import org.teacup.core.assertion.LongAssert;
import org.teacup.core.assertion.ObjectAssert;

class DurationImplTest {
  private final BooleanAssert booleanAssert = mock(BooleanAssert.class);
  private final Duration duration = Duration.ofDays(1L);
  private final DurationSetter durationSetter = new DurationImpl();
  private final IntegerAssert integerAssert = mock(IntegerAssert.class);
  private final LongAssert longAssert = mock(LongAssert.class);
  private final org.teacup.protocol.http.node.Duration newDuration =
      mock(org.teacup.protocol.http.node.Duration.class);

  @Mock private ListAssert<? super TemporalUnit, ?> listAssert;
  @Mock private ObjectAssert<? super Duration, ?> objectAssert;

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
    durationSetter.setAssertion(objectAssert);
    durationSetter.verify(duration);

    verify(objectAssert).verify(duration);
  }

  @Test
  void setNano() {
    durationSetter.setNano(integerAssert);
    durationSetter.verify(duration);

    verify(integerAssert).verify(duration.getNano());
  }

  @Test
  void setNegated() {
    durationSetter.setNegated(newDuration);
    durationSetter.verify(duration);

    verify(newDuration).verify(duration.negated());
  }

  @Test
  void setNegative() {
    durationSetter.setNegative(booleanAssert);
    durationSetter.verify(duration);

    verify(booleanAssert).verify(duration.isNegative());
  }

  @Test
  void setSeconds() {
    durationSetter.setSeconds(longAssert);
    durationSetter.verify(duration);

    verify(longAssert).verify(duration.getSeconds());
  }

  @Test
  void setToDays() {
    durationSetter.setToDays(longAssert);
    durationSetter.verify(duration);

    verify(longAssert).verify(duration.toDays());
  }

  @Test
  void setToDaysPart() {
    durationSetter.setToDaysPart(longAssert);
    durationSetter.verify(duration);

    verify(longAssert).verify(duration.toDaysPart());
  }

  @Test
  void setToHours() {
    durationSetter.setToHours(longAssert);
    durationSetter.verify(duration);

    verify(longAssert).verify(duration.toHours());
  }

  @Test
  void setToHoursPart() {
    durationSetter.setToHoursPart(integerAssert);
    durationSetter.verify(duration);

    verify(integerAssert).verify(duration.toHoursPart());
  }

  @Test
  void setToMillis() {
    durationSetter.setToMillis(longAssert);
    durationSetter.verify(duration);

    verify(longAssert).verify(duration.toMillis());
  }

  @Test
  void setToMillisPart() {
    durationSetter.setToMillisPart(integerAssert);
    durationSetter.verify(duration);

    verify(integerAssert).verify(duration.toMillisPart());
  }

  @Test
  void setToMinutes() {
    durationSetter.setToMinutes(longAssert);
    durationSetter.verify(duration);

    verify(longAssert).verify(duration.toMinutes());
  }

  @Test
  void setToMinutesPart() {
    durationSetter.setToMinutesPart(integerAssert);
    durationSetter.verify(duration);

    verify(integerAssert).verify(duration.toMinutesPart());
  }

  @Test
  void setToNanos() {
    durationSetter.setToNanos(longAssert);
    durationSetter.verify(duration);

    verify(longAssert).verify(duration.toNanos());
  }

  @Test
  void setToNanosPart() {
    durationSetter.setToNanosPart(integerAssert);
    durationSetter.verify(duration);

    verify(integerAssert).verify(duration.toNanosPart());
  }

  @Test
  void setToSeconds() {
    durationSetter.setToSeconds(longAssert);
    durationSetter.verify(duration);

    verify(longAssert).verify(duration.toSeconds());
  }

  @Test
  void setToSecondsPart() {
    durationSetter.setToSecondsPart(integerAssert);
    durationSetter.verify(duration);

    verify(integerAssert).verify(duration.toSecondsPart());
  }

  @Test
  void setUnits() {
    durationSetter.setUnits(listAssert);
    durationSetter.verify(duration);

    verify(listAssert).verify(duration.getUnits());
  }

  @Test
  void setZero() {
    durationSetter.setZero(booleanAssert);
    durationSetter.verify(duration);

    verify(booleanAssert).verify(duration.isZero());
  }
}
