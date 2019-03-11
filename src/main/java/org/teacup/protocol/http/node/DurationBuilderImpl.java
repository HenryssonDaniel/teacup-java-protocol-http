package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.BUILD;
import static org.teacup.protocol.http.node.Constants.SETTING_THE;

import java.time.temporal.TemporalUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.ListAssert;
import org.teacup.core.assertion.LongAssert;
import org.teacup.core.assertion.ObjectAssert;

class DurationBuilderImpl implements DurationBuilder {
  private static final Logger LOGGER = Logger.getLogger(DurationBuilderImpl.class.getName());
  private DurationSetter durationSetter = new DurationImpl();

  @Override
  public Duration build() {
    LOGGER.log(Level.FINE, String.format(BUILD, "duration"));

    Duration duration = durationSetter;
    durationSetter = new DurationImpl();

    return duration;
  }

  @Override
  public DurationBuilder setAbs(Duration abs) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "abs"));
    durationSetter.setAbs(abs);
    return this;
  }

  @Override
  public DurationBuilder setAssertion(ObjectAssert<java.time.Duration, ?> assertion) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "assertion"));
    durationSetter.setAssertion(assertion);
    return this;
  }

  @Override
  public DurationBuilder setNano(IntegerAssert nano) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "nano"));
    durationSetter.setNano(nano);
    return this;
  }

  @Override
  public DurationBuilder setNegated(Duration negated) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "negated"));
    durationSetter.setNegated(negated);
    return this;
  }

  @Override
  public DurationBuilder setNegative(BooleanAssert negative) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "negative"));
    durationSetter.setNegative(negative);
    return this;
  }

  @Override
  public DurationBuilder setSeconds(LongAssert seconds) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "seconds"));
    durationSetter.setSeconds(seconds);
    return this;
  }

  @Override
  public DurationBuilder setToDays(LongAssert toDays) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to days"));
    durationSetter.setToDays(toDays);
    return this;
  }

  @Override
  public DurationBuilder setToDaysPart(LongAssert toDaysPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to days part"));
    durationSetter.setToDaysPart(toDaysPart);
    return this;
  }

  @Override
  public DurationBuilder setToHours(LongAssert toHours) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to hours"));
    durationSetter.setToHours(toHours);
    return this;
  }

  @Override
  public DurationBuilder setToHoursPart(IntegerAssert toHoursPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to hours part"));
    durationSetter.setToHoursPart(toHoursPart);
    return this;
  }

  @Override
  public DurationBuilder setToMillis(LongAssert toMillis) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to millis"));
    durationSetter.setToMillis(toMillis);
    return this;
  }

  @Override
  public DurationBuilder setToMillisPart(IntegerAssert toMillisPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to millis part"));
    durationSetter.setToMillisPart(toMillisPart);
    return this;
  }

  @Override
  public DurationBuilder setToMinutes(LongAssert toMinutes) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to minutes"));
    durationSetter.setToMinutes(toMinutes);
    return this;
  }

  @Override
  public DurationBuilder setToMinutesPart(IntegerAssert toMinutesPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to minutes part"));
    durationSetter.setToMinutesPart(toMinutesPart);
    return this;
  }

  @Override
  public DurationBuilder setToNanos(LongAssert toNanos) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to nanos"));
    durationSetter.setToNanos(toNanos);
    return this;
  }

  @Override
  public DurationBuilder setToNanosPart(IntegerAssert toNanosPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to nanos part"));
    durationSetter.setToNanosPart(toNanosPart);
    return this;
  }

  @Override
  public DurationBuilder setToSeconds(LongAssert toSeconds) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to seconds"));
    durationSetter.setToSeconds(toSeconds);
    return this;
  }

  @Override
  public DurationBuilder setToSecondsPart(IntegerAssert toSecondsPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to seconds part"));
    durationSetter.setToSecondsPart(toSecondsPart);
    return this;
  }

  @Override
  public DurationBuilder setUnits(ListAssert<? super TemporalUnit, ?> units) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "units"));
    durationSetter.setUnits(units);
    return this;
  }

  @Override
  public DurationBuilder setZero(BooleanAssert zero) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "zero"));
    durationSetter.setZero(zero);
    return this;
  }
}
