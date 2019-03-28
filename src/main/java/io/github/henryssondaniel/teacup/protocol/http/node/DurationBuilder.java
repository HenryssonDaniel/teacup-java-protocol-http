package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.NodeBuilder;
import io.github.henryssondaniel.teacup.core.assertion.BooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.IntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.ListAssert;
import io.github.henryssondaniel.teacup.core.assertion.LongAssert;
import java.time.temporal.TemporalUnit;

/**
 * Duration builder.
 *
 * @since 1.0
 */
public interface DurationBuilder
    extends NodeBuilder<java.time.Duration, Duration, DurationBuilder> {
  /**
   * Sets the abs.
   *
   * @param abs the abs
   * @return the duration builder
   */
  DurationBuilder setAbs(Duration abs);

  /**
   * Sets the nano.
   *
   * @param nano the nano
   * @return the duration builder
   */
  DurationBuilder setNano(IntegerAssert<?> nano);

  /**
   * Sets whether negated or not.
   *
   * @param negated whether negated or not
   * @return the duration builder
   */
  DurationBuilder setNegated(Duration negated);

  /**
   * Wets whether negative or not.
   *
   * @param negative whether negative or not
   * @return the duration builder
   */
  DurationBuilder setNegative(BooleanAssert<?> negative);

  /**
   * Sets the seconds.
   *
   * @param seconds the seconds
   * @return the duration builder
   */
  DurationBuilder setSeconds(LongAssert<?> seconds);

  /**
   * Sets the to days.
   *
   * @param toDays the to days
   * @return the duration builder
   */
  DurationBuilder setToDays(LongAssert<?> toDays);

  /**
   * Sets the to days part.
   *
   * @param toDaysPart the to days part
   * @return the duration builder
   */
  DurationBuilder setToDaysPart(LongAssert<?> toDaysPart);

  /**
   * Sets the to hours.
   *
   * @param toHours the to hours
   * @return the duration builder
   */
  DurationBuilder setToHours(LongAssert<?> toHours);

  /**
   * Sets the to hours part.
   *
   * @param toHoursPart the to hours part
   * @return the duration builder
   */
  DurationBuilder setToHoursPart(IntegerAssert<?> toHoursPart);

  /**
   * Sets the to millis.
   *
   * @param toMillis the to millis
   * @return the duration builder
   */
  DurationBuilder setToMillis(LongAssert<?> toMillis);

  /**
   * Sets the to millis part.
   *
   * @param toMillisPart the to millis part
   * @return the duration builder
   */
  DurationBuilder setToMillisPart(IntegerAssert<?> toMillisPart);

  /**
   * Sets the to minutes.
   *
   * @param toMinutes the to minutes
   * @return the duration builder
   */
  DurationBuilder setToMinutes(LongAssert<?> toMinutes);

  /**
   * Sets the to minutes part.
   *
   * @param toMinutesPart the to minutes part
   * @return the duration builder
   */
  DurationBuilder setToMinutesPart(IntegerAssert<?> toMinutesPart);

  /**
   * Sets the to nanos.
   *
   * @param toNanos the to nanos
   * @return the duration builder
   */
  DurationBuilder setToNanos(LongAssert<?> toNanos);

  /**
   * Sets the to nanos part.
   *
   * @param toNanosPart the to nanos part
   * @return the duration builder
   */
  DurationBuilder setToNanosPart(IntegerAssert<?> toNanosPart);

  /**
   * Sets the to seconds.
   *
   * @param toSeconds the to seconds
   * @return the duration builder
   */
  DurationBuilder setToSeconds(LongAssert<?> toSeconds);

  /**
   * Sets the to seconds part.
   *
   * @param toSecondsPart the to seconds part
   * @return the duration builder
   */
  DurationBuilder setToSecondsPart(IntegerAssert<?> toSecondsPart);

  /**
   * Sets the units.
   *
   * @param units the units
   * @return the duration builder
   */
  DurationBuilder setUnits(ListAssert<? super TemporalUnit, ?> units);

  /**
   * Sets whether zero or not.
   *
   * @param zero whether zero or not
   * @return the duration builder
   */
  DurationBuilder setZero(BooleanAssert<?> zero);
}
