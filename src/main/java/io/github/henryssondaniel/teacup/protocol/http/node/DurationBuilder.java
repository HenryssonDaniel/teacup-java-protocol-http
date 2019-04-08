package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.NodeBuilder;
import io.github.henryssondaniel.teacup.core.assertion.GenericBooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericListAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericLongAssert;
import java.time.temporal.TemporalUnit;
import java.util.List;

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
  DurationBuilder setNano(GenericIntegerAssert<?> nano);

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
  DurationBuilder setNegative(GenericBooleanAssert<?> negative);

  /**
   * Sets the seconds.
   *
   * @param seconds the seconds
   * @return the duration builder
   */
  DurationBuilder setSeconds(GenericLongAssert<?> seconds);

  /**
   * Sets the to days.
   *
   * @param toDays the to days
   * @return the duration builder
   */
  DurationBuilder setToDays(GenericLongAssert<?> toDays);

  /**
   * Sets the to days part.
   *
   * @param toDaysPart the to days part
   * @return the duration builder
   */
  DurationBuilder setToDaysPart(GenericLongAssert<?> toDaysPart);

  /**
   * Sets the to hours.
   *
   * @param toHours the to hours
   * @return the duration builder
   */
  DurationBuilder setToHours(GenericLongAssert<?> toHours);

  /**
   * Sets the to hours part.
   *
   * @param toHoursPart the to hours part
   * @return the duration builder
   */
  DurationBuilder setToHoursPart(GenericIntegerAssert<?> toHoursPart);

  /**
   * Sets the to millis.
   *
   * @param toMillis the to millis
   * @return the duration builder
   */
  DurationBuilder setToMillis(GenericLongAssert<?> toMillis);

  /**
   * Sets the to millis part.
   *
   * @param toMillisPart the to millis part
   * @return the duration builder
   */
  DurationBuilder setToMillisPart(GenericIntegerAssert<?> toMillisPart);

  /**
   * Sets the to minutes.
   *
   * @param toMinutes the to minutes
   * @return the duration builder
   */
  DurationBuilder setToMinutes(GenericLongAssert<?> toMinutes);

  /**
   * Sets the to minutes part.
   *
   * @param toMinutesPart the to minutes part
   * @return the duration builder
   */
  DurationBuilder setToMinutesPart(GenericIntegerAssert<?> toMinutesPart);

  /**
   * Sets the to nanos.
   *
   * @param toNanos the to nanos
   * @return the duration builder
   */
  DurationBuilder setToNanos(GenericLongAssert<?> toNanos);

  /**
   * Sets the to nanos part.
   *
   * @param toNanosPart the to nanos part
   * @return the duration builder
   */
  DurationBuilder setToNanosPart(GenericIntegerAssert<?> toNanosPart);

  /**
   * Sets the to seconds.
   *
   * @param toSeconds the to seconds
   * @return the duration builder
   */
  DurationBuilder setToSeconds(GenericLongAssert<?> toSeconds);

  /**
   * Sets the to seconds part.
   *
   * @param toSecondsPart the to seconds part
   * @return the duration builder
   */
  DurationBuilder setToSecondsPart(GenericIntegerAssert<?> toSecondsPart);

  /**
   * Sets the units.
   *
   * @param units the units
   * @return the duration builder
   */
  DurationBuilder setUnits(
      GenericListAssert<? super TemporalUnit, ? super List<? extends TemporalUnit>, ?> units);

  /**
   * Sets whether zero or not.
   *
   * @param zero whether zero or not
   * @return the duration builder
   */
  DurationBuilder setZero(GenericBooleanAssert<?> zero);
}
