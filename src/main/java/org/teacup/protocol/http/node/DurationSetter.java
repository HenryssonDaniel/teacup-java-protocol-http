package org.teacup.protocol.http.node;

import java.time.temporal.TemporalUnit;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.ListAssert;
import org.teacup.core.assertion.LongAssert;
import org.teacup.core.assertion.ObjectAssert;

interface DurationSetter extends Duration {
  void setAbs(Duration abs);

  void setAssertion(ObjectAssert<? super java.time.Duration, ?> assertion);

  void setNano(IntegerAssert nano);

  void setNegated(Duration negated);

  void setNegative(BooleanAssert negative);

  void setSeconds(LongAssert seconds);

  void setToDays(LongAssert toDays);

  void setToDaysPart(LongAssert toDaysPart);

  void setToHours(LongAssert toHours);

  void setToHoursPart(IntegerAssert toHoursPart);

  void setToMillis(LongAssert toMillis);

  void setToMillisPart(IntegerAssert toMillisPart);

  void setToMinutes(LongAssert toMinutes);

  void setToMinutesPart(IntegerAssert toMinutesPart);

  void setToNanos(LongAssert toNanos);

  void setToNanosPart(IntegerAssert toNanosPart);

  void setToSeconds(LongAssert toSeconds);

  void setToSecondsPart(IntegerAssert toSecondsPart);

  void setUnits(ListAssert<? super TemporalUnit, ?> units);

  void setZero(BooleanAssert zero);
}