package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.Node;
import io.github.henryssondaniel.teacup.core.assertion.GenericBooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericListAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericLongAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class DurationImpl
    extends SetterImpl<java.time.Duration, GenericObjectAssert<java.time.Duration, ?>>
    implements DurationSetter {
  private static final Logger LOGGER = Logger.getLogger(DurationImpl.class.getName());

  private Node<java.time.Duration> abs;
  private GenericObjectAssert<Integer, ?> nano;
  private Node<java.time.Duration> negated;
  private GenericObjectAssert<Boolean, ?> negative;
  private GenericObjectAssert<Long, ?> seconds;
  private GenericObjectAssert<Long, ?> toDays;
  private GenericObjectAssert<Long, ?> toDaysPart;
  private GenericObjectAssert<Long, ?> toHours;
  private GenericObjectAssert<Integer, ?> toHoursPart;
  private GenericObjectAssert<Long, ?> toMillis;
  private GenericObjectAssert<Integer, ?> toMillisPart;
  private GenericObjectAssert<Long, ?> toMinutes;
  private GenericObjectAssert<Integer, ?> toMinutesPart;
  private GenericObjectAssert<Long, ?> toNanos;
  private GenericObjectAssert<Integer, ?> toNanosPart;
  private GenericObjectAssert<Long, ?> toSeconds;
  private GenericObjectAssert<Integer, ?> toSecondsPart;
  private GenericObjectAssert<? super List<? extends TemporalUnit>, ?> units;
  private GenericObjectAssert<Boolean, ?> zero;

  @Override
  public void setAbs(Duration abs) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "abs");
    this.abs = abs;
  }

  @Override
  public void setNano(GenericIntegerAssert<?> nano) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "nano");
    this.nano = nano;
  }

  @Override
  public void setNegated(Duration negated) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "negated");
    this.negated = negated;
  }

  @Override
  public void setNegative(GenericBooleanAssert<?> negative) {
    LOGGER.log(Level.FINE, Constants.SETTING_WHETHER, "negative");
    this.negative = negative;
  }

  @Override
  public void setSeconds(GenericLongAssert<?> seconds) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "seconds");
    this.seconds = seconds;
  }

  @Override
  public void setToDays(GenericLongAssert<?> toDays) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "to days");
    this.toDays = toDays;
  }

  @Override
  public void setToDaysPart(GenericLongAssert<?> toDaysPart) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "to days part");
    this.toDaysPart = toDaysPart;
  }

  @Override
  public void setToHours(GenericLongAssert<?> toHours) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "to hours");
    this.toHours = toHours;
  }

  @Override
  public void setToHoursPart(GenericIntegerAssert<?> toHoursPart) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "to hours part");
    this.toHoursPart = toHoursPart;
  }

  @Override
  public void setToMillis(GenericLongAssert<?> toMillis) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "to millis");
    this.toMillis = toMillis;
  }

  @Override
  public void setToMillisPart(GenericIntegerAssert<?> toMillisPart) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "to millis part");
    this.toMillisPart = toMillisPart;
  }

  @Override
  public void setToMinutes(GenericLongAssert<?> toMinutes) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "to minutes");
    this.toMinutes = toMinutes;
  }

  @Override
  public void setToMinutesPart(GenericIntegerAssert<?> toMinutesPart) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "to minutes part");
    this.toMinutesPart = toMinutesPart;
  }

  @Override
  public void setToNanos(GenericLongAssert<?> toNanos) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "to nanos");
    this.toNanos = toNanos;
  }

  @Override
  public void setToNanosPart(GenericIntegerAssert<?> toNanosPart) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "to nanos part");
    this.toNanosPart = toNanosPart;
  }

  @Override
  public void setToSeconds(GenericLongAssert<?> toSeconds) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "to seconds");
    this.toSeconds = toSeconds;
  }

  @Override
  public void setToSecondsPart(GenericIntegerAssert<?> toSecondsPart) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "to seconds part");
    this.toSecondsPart = toSecondsPart;
  }

  @Override
  public void setUnits(
      GenericListAssert<? super TemporalUnit, ? super List<? extends TemporalUnit>, ?> units) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "units");
    this.units = units;
  }

  @Override
  public void setZero(GenericBooleanAssert<?> zero) {
    LOGGER.log(Level.FINE, Constants.SETTING_WHETHER, "zero");
    this.zero = zero;
  }

  @Override
  public void verify(java.time.Duration duration) {
    LOGGER.log(Level.FINE, Constants.VERIFY, "duration");

    verifyAssertion(duration, getAssertion());
    verifyAbs(duration);
    verifyNano(duration);
    verifySeconds(duration);
    verifyUnits(duration);
    verifyNegative(duration);
    verifyZero(duration);
    verifyNegated(duration);
    verifyToDays(duration);
    verifyToDaysPart(duration);
    verifyToHours(duration);
    verifyToHoursPart(duration);
    verifyToMillis(duration);
    verifyToMillisPart(duration);
    verifyToMinutes(duration);
    verifyToMinutesPart(duration);
    verifyToNanos(duration);
    verifyToNanosPart(duration);
    verifyToSeconds(duration);
    verifyToSecondsPart(duration);
  }

  private void verifyAbs(java.time.Duration duration) {
    if (abs != null) abs.verify(duration.abs());
  }

  private static void verifyAssertion(
      java.time.Duration duration,
      GenericObjectAssert<? super java.time.Duration, ?> objectAssert) {
    if (objectAssert != null) objectAssert.verify(duration);
  }

  private void verifyNano(java.time.Duration duration) {
    if (nano != null) nano.verify(duration.getNano());
  }

  private void verifyNegated(java.time.Duration duration) {
    if (negated != null) negated.verify(duration.negated());
  }

  private void verifyNegative(java.time.Duration duration) {
    if (negative != null) negative.verify(duration.isNegative());
  }

  private void verifySeconds(java.time.Duration duration) {
    if (seconds != null) seconds.verify(duration.getSeconds());
  }

  private void verifyToDays(java.time.Duration duration) {
    if (toDays != null) toDays.verify(duration.toDays());
  }

  private void verifyToDaysPart(java.time.Duration duration) {
    if (toDaysPart != null) toDaysPart.verify(duration.toDaysPart());
  }

  private void verifyToHours(java.time.Duration duration) {
    if (toHours != null) toHours.verify(duration.toHours());
  }

  private void verifyToHoursPart(java.time.Duration duration) {
    if (toHoursPart != null) toHoursPart.verify(duration.toHoursPart());
  }

  private void verifyToMillis(java.time.Duration duration) {
    if (toMillis != null) toMillis.verify(duration.toMillis());
  }

  private void verifyToMillisPart(java.time.Duration duration) {
    if (toMillisPart != null) toMillisPart.verify(duration.toMillisPart());
  }

  private void verifyToMinutes(java.time.Duration duration) {
    if (toMinutes != null) toMinutes.verify(duration.toMinutes());
  }

  private void verifyToMinutesPart(java.time.Duration duration) {
    if (toMinutesPart != null) toMinutesPart.verify(duration.toMinutesPart());
  }

  private void verifyToNanos(java.time.Duration duration) {
    if (toNanos != null) toNanos.verify(duration.toNanos());
  }

  private void verifyToNanosPart(java.time.Duration duration) {
    if (toNanosPart != null) toNanosPart.verify(duration.toNanosPart());
  }

  private void verifyToSeconds(java.time.Duration duration) {
    if (toSeconds != null) toSeconds.verify(duration.toSeconds());
  }

  private void verifyToSecondsPart(java.time.Duration duration) {
    if (toSecondsPart != null) toSecondsPart.verify(duration.toSecondsPart());
  }

  private void verifyUnits(TemporalAmount temporalAmount) {
    if (units != null) units.verify(temporalAmount.getUnits());
  }

  private void verifyZero(java.time.Duration duration) {
    if (zero != null) zero.verify(duration.isZero());
  }
}
