package org.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.BooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.IntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.ListAssert;
import io.github.henryssondaniel.teacup.core.assertion.LongAssert;
import java.time.temporal.TemporalUnit;

interface DurationSetter extends Duration, Setter<java.time.Duration> {
  void setAbs(Duration abs);

  void setNano(IntegerAssert<?> nano);

  void setNegated(Duration negated);

  void setNegative(BooleanAssert<?> negative);

  void setSeconds(LongAssert<?> seconds);

  void setToDays(LongAssert<?> toDays);

  void setToDaysPart(LongAssert<?> toDaysPart);

  void setToHours(LongAssert<?> toHours);

  void setToHoursPart(IntegerAssert<?> toHoursPart);

  void setToMillis(LongAssert<?> toMillis);

  void setToMillisPart(IntegerAssert<?> toMillisPart);

  void setToMinutes(LongAssert<?> toMinutes);

  void setToMinutesPart(IntegerAssert<?> toMinutesPart);

  void setToNanos(LongAssert<?> toNanos);

  void setToNanosPart(IntegerAssert<?> toNanosPart);

  void setToSeconds(LongAssert<?> toSeconds);

  void setToSecondsPart(IntegerAssert<?> toSecondsPart);

  void setUnits(ListAssert<? super TemporalUnit, ?> units);

  void setZero(BooleanAssert<?> zero);
}
