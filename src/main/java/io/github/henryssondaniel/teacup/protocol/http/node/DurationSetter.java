package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericBooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericListAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericLongAssert;
import java.time.temporal.TemporalUnit;
import java.util.List;

interface DurationSetter extends Duration, Setter<java.time.Duration> {
  void setAbs(Duration abs);

  void setNano(GenericIntegerAssert<?> nano);

  void setNegated(Duration negated);

  void setNegative(GenericBooleanAssert<?> negative);

  void setSeconds(GenericLongAssert<?> seconds);

  void setToDays(GenericLongAssert<?> toDays);

  void setToDaysPart(GenericLongAssert<?> toDaysPart);

  void setToHours(GenericLongAssert<?> toHours);

  void setToHoursPart(GenericIntegerAssert<?> toHoursPart);

  void setToMillis(GenericLongAssert<?> toMillis);

  void setToMillisPart(GenericIntegerAssert<?> toMillisPart);

  void setToMinutes(GenericLongAssert<?> toMinutes);

  void setToMinutesPart(GenericIntegerAssert<?> toMinutesPart);

  void setToNanos(GenericLongAssert<?> toNanos);

  void setToNanosPart(GenericIntegerAssert<?> toNanosPart);

  void setToSeconds(GenericLongAssert<?> toSeconds);

  void setToSecondsPart(GenericIntegerAssert<?> toSecondsPart);

  void setUnits(
      GenericListAssert<? super TemporalUnit, ? super List<? extends TemporalUnit>, ?> units);

  void setZero(GenericBooleanAssert<?> zero);
}
