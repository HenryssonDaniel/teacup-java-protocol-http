package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.SETTING_THE;
import static org.teacup.protocol.http.node.Constants.SETTING_WHETHER;
import static org.teacup.protocol.http.node.Constants.VERIFY;

import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.teacup.core.Node;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.ListAssert;
import org.teacup.core.assertion.LongAssert;
import org.teacup.core.assertion.ObjectAssert;

class DurationImpl extends SetterImpl<java.time.Duration> implements DurationSetter {
  private static final Logger LOGGER = Logger.getLogger(DurationImpl.class.getName());

  private Node<java.time.Duration> abs;
  private ObjectAssert<Integer, IntegerAssert> nano;
  private Node<java.time.Duration> negated;
  private ObjectAssert<Boolean, BooleanAssert> negative;
  private ObjectAssert<Long, LongAssert> seconds;
  private ObjectAssert<Long, LongAssert> toDays;
  private ObjectAssert<Long, LongAssert> toDaysPart;
  private ObjectAssert<Long, LongAssert> toHours;
  private ObjectAssert<Integer, IntegerAssert> toHoursPart;
  private ObjectAssert<Long, LongAssert> toMillis;
  private ObjectAssert<Integer, IntegerAssert> toMillisPart;
  private ObjectAssert<Long, LongAssert> toMinutes;
  private ObjectAssert<Integer, IntegerAssert> toMinutesPart;
  private ObjectAssert<Long, LongAssert> toNanos;
  private ObjectAssert<Integer, IntegerAssert> toNanosPart;
  private ObjectAssert<Long, LongAssert> toSeconds;
  private ObjectAssert<Integer, IntegerAssert> toSecondsPart;
  private ObjectAssert<? super List<TemporalUnit>, ?> units;
  private ObjectAssert<Boolean, BooleanAssert> zero;

  @Override
  public void setAbs(Duration abs) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "abs"));
    this.abs = abs;
  }

  @Override
  public void setNano(IntegerAssert nano) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "nano"));
    this.nano = nano;
  }

  @Override
  public void setNegated(Duration negated) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "negated"));
    this.negated = negated;
  }

  @Override
  public void setNegative(BooleanAssert negative) {
    LOGGER.log(Level.FINE, String.format(SETTING_WHETHER, "negative"));
    this.negative = negative;
  }

  @Override
  public void setSeconds(LongAssert seconds) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "seconds"));
    this.seconds = seconds;
  }

  @Override
  public void setToDays(LongAssert toDays) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to days"));
    this.toDays = toDays;
  }

  @Override
  public void setToDaysPart(LongAssert toDaysPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to days part"));
    this.toDaysPart = toDaysPart;
  }

  @Override
  public void setToHours(LongAssert toHours) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to hours"));
    this.toHours = toHours;
  }

  @Override
  public void setToHoursPart(IntegerAssert toHoursPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to hours part"));
    this.toHoursPart = toHoursPart;
  }

  @Override
  public void setToMillis(LongAssert toMillis) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to millis"));
    this.toMillis = toMillis;
  }

  @Override
  public void setToMillisPart(IntegerAssert toMillisPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to millis part"));
    this.toMillisPart = toMillisPart;
  }

  @Override
  public void setToMinutes(LongAssert toMinutes) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to minutes"));
    this.toMinutes = toMinutes;
  }

  @Override
  public void setToMinutesPart(IntegerAssert toMinutesPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to minutes part"));
    this.toMinutesPart = toMinutesPart;
  }

  @Override
  public void setToNanos(LongAssert toNanos) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to nanos"));
    this.toNanos = toNanos;
  }

  @Override
  public void setToNanosPart(IntegerAssert toNanosPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to nanos part"));
    this.toNanosPart = toNanosPart;
  }

  @Override
  public void setToSeconds(LongAssert toSeconds) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to seconds"));
    this.toSeconds = toSeconds;
  }

  @Override
  public void setToSecondsPart(IntegerAssert toSecondsPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to seconds part"));
    this.toSecondsPart = toSecondsPart;
  }

  @Override
  public void setUnits(ListAssert<? super TemporalUnit, ?> units) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "units"));
    this.units = units;
  }

  @Override
  public void setZero(BooleanAssert zero) {
    LOGGER.log(Level.FINE, String.format(SETTING_WHETHER, "zero"));
    this.zero = zero;
  }

  @Override
  public void verify(java.time.Duration duration) {
    LOGGER.log(Level.FINE, String.format(VERIFY, "duration"));

    verifyAssertion(duration, getAssertion());
    verifyDuration(abs, duration.abs());
    verifyInteger(nano, duration.getNano());
    verifyLong(seconds, duration.getSeconds());
    verifyUnits(duration);
    verifyBoolean(negative, duration.isNegative());
    verifyBoolean(zero, duration.isZero());
    verifyDuration(negated, duration.negated());
    verifyLong(toDays, duration.toDays());
    verifyLong(toDaysPart, duration.toDaysPart());
    verifyLong(toHours, duration.toHours());
    verifyInteger(toHoursPart, duration.toHoursPart());
    verifyLong(toMillis, duration.toMillis());
    verifyInteger(toMillisPart, duration.toMillisPart());
    verifyLong(toMinutes, duration.toMinutes());
    verifyInteger(toMinutesPart, duration.toMinutesPart());
    verifyLong(toNanos, duration.toNanos());
    verifyInteger(toNanosPart, duration.toNanosPart());
    verifyLong(toSeconds, duration.toSeconds());
    verifyInteger(toSecondsPart, duration.toSecondsPart());
  }

  private static void verifyAssertion(
      java.time.Duration duration, ObjectAssert<? super java.time.Duration, ?> objectAssert) {
    if (objectAssert != null) objectAssert.verify(duration);
  }

  private static void verifyBoolean(
      ObjectAssert<? super Boolean, BooleanAssert> objectAssert, boolean actual) {
    if (objectAssert != null) objectAssert.verify(actual);
  }

  private static void verifyDuration(
      Node<? super java.time.Duration> node, java.time.Duration duration) {
    if (node != null) node.verify(duration);
  }

  private static void verifyInteger(
      ObjectAssert<? super Integer, IntegerAssert> objectAssert, int actual) {
    if (objectAssert != null) objectAssert.verify(actual);
  }

  private static void verifyLong(ObjectAssert<? super Long, LongAssert> objectAssert, long actual) {
    if (objectAssert != null) objectAssert.verify(actual);
  }

  private void verifyUnits(TemporalAmount temporalAmount) {
    if (units != null) units.verify(temporalAmount.getUnits());
  }
}
