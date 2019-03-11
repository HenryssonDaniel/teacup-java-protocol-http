package org.teacup.protocol.http;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import org.teacup.core.NodeBuilder;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.ListAssert;
import org.teacup.core.assertion.LongAssert;

/**
 * Duration node builder.
 *
 * @since 1.0
 */
public interface DurationNodeBuilder
    extends NodeBuilder<Duration, DurationNode, DurationNodeBuilder> {
  /**
   * Sets the abs.
   *
   * @param abs the abs
   * @return the duration node builder
   */
  DurationNodeBuilder setAbs(DurationNode abs);

  /**
   * Sets the nano.
   *
   * @param nano the nano
   * @return the duration node builder
   */
  DurationNodeBuilder setNano(IntegerAssert nano);

  /**
   * Sets whether negated or not.
   *
   * @param negated whether negated or not
   * @return the duration node builder
   */
  DurationNodeBuilder setNegated(DurationNode negated);

  /**
   * Wets whether negative or not.
   *
   * @param negative whether negative or not
   * @return the duration node builder
   */
  DurationNodeBuilder setNegative(BooleanAssert negative);

  /**
   * Sets the seconds.
   *
   * @param seconds the seconds
   * @return the duration node builder
   */
  DurationNodeBuilder setSeconds(LongAssert seconds);

  /**
   * Sets the to days.
   *
   * @param toDays the to days
   * @return the duration node builder
   */
  DurationNodeBuilder setToDays(LongAssert toDays);

  /**
   * Sets the to days part.
   *
   * @param toDaysPart the to days part
   * @return the duration node builder
   */
  DurationNodeBuilder setToDaysPart(LongAssert toDaysPart);

  /**
   * Sets the to hours.
   *
   * @param toHours the to hours
   * @return the duration node builder
   */
  DurationNodeBuilder setToHours(LongAssert toHours);

  /**
   * Sets the to hours part.
   *
   * @param toHoursPart the to hours part
   * @return the duration node builder
   */
  DurationNodeBuilder setToHoursPart(IntegerAssert toHoursPart);

  /**
   * Sets the to millis.
   *
   * @param toMillis the to millis
   * @return the duration node builder
   */
  DurationNodeBuilder setToMillis(LongAssert toMillis);

  /**
   * Sets the to millis part.
   *
   * @param toMillisPart the to millis part
   * @return the duration node builder
   */
  DurationNodeBuilder setToMillisPart(IntegerAssert toMillisPart);

  /**
   * Sets the to minutes.
   *
   * @param toMinutes the to minutes
   * @return the duration node builder
   */
  DurationNodeBuilder setToMinutes(LongAssert toMinutes);

  /**
   * Sets the to minutes part.
   *
   * @param toMinutesPart the to minutes part
   * @return the duration node builder
   */
  DurationNodeBuilder setToMinutesPart(IntegerAssert toMinutesPart);

  /**
   * Sets the to nanos.
   *
   * @param toNanos the to nanos
   * @return the duration node builder
   */
  DurationNodeBuilder setToNanos(LongAssert toNanos);

  /**
   * Sets the to nanos part.
   *
   * @param toNanosPart the to nanos part
   * @return the duration node builder
   */
  DurationNodeBuilder setToNanosPart(IntegerAssert toNanosPart);

  /**
   * Sets the to seconds.
   *
   * @param toSeconds the to seconds
   * @return the duration node builder
   */
  DurationNodeBuilder setToSeconds(LongAssert toSeconds);

  /**
   * Sets the to seconds part.
   *
   * @param toSecondsPart the to seconds part
   * @return the duration node builder
   */
  DurationNodeBuilder setToSecondsPart(IntegerAssert toSecondsPart);

  /**
   * Sets the units.
   *
   * @param units the units
   * @return the duration node builder
   */
  DurationNodeBuilder setUnits(ListAssert<? super TemporalUnit, ?> units);

  /**
   * Sets whether zero or not.
   *
   * @param zero whether zero or not
   * @return the duration node builder
   */
  DurationNodeBuilder setZero(BooleanAssert zero);
}
