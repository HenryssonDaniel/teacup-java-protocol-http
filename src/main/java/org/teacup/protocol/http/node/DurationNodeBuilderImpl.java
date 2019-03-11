package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.BUILD;
import static org.teacup.protocol.http.node.Constants.SETTING_THE;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.ListAssert;
import org.teacup.core.assertion.LongAssert;
import org.teacup.core.assertion.ObjectAssert;

class DurationNodeBuilderImpl implements DurationNodeBuilder {
  private static final Logger LOGGER = Logger.getLogger(DurationNodeBuilderImpl.class.getName());
  private DurationNodeSetter durationNodeSetter = new DurationNodeImpl();

  @Override
  public DurationNode build() {
    LOGGER.log(Level.FINE, String.format(BUILD, "duration"));

    DurationNode durationNode = durationNodeSetter;
    durationNodeSetter = new DurationNodeImpl();

    return durationNode;
  }

  @Override
  public DurationNodeBuilder setAbs(DurationNode abs) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "abs"));
    durationNodeSetter.setAbs(abs);
    return this;
  }

  @Override
  public DurationNodeBuilder setAssertion(ObjectAssert<Duration, ?> assertion) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "assertion"));
    durationNodeSetter.setAssertion(assertion);
    return this;
  }

  @Override
  public DurationNodeBuilder setNano(IntegerAssert nano) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "nano"));
    durationNodeSetter.setNano(nano);
    return this;
  }

  @Override
  public DurationNodeBuilder setNegated(DurationNode negated) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "negated"));
    durationNodeSetter.setNegated(negated);
    return this;
  }

  @Override
  public DurationNodeBuilder setNegative(BooleanAssert negative) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "negative"));
    durationNodeSetter.setNegative(negative);
    return this;
  }

  @Override
  public DurationNodeBuilder setSeconds(LongAssert seconds) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "seconds"));
    durationNodeSetter.setSeconds(seconds);
    return this;
  }

  @Override
  public DurationNodeBuilder setToDays(LongAssert toDays) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to days"));
    durationNodeSetter.setToDays(toDays);
    return this;
  }

  @Override
  public DurationNodeBuilder setToDaysPart(LongAssert toDaysPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to days part"));
    durationNodeSetter.setToDaysPart(toDaysPart);
    return this;
  }

  @Override
  public DurationNodeBuilder setToHours(LongAssert toHours) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to hours"));
    durationNodeSetter.setToHours(toHours);
    return this;
  }

  @Override
  public DurationNodeBuilder setToHoursPart(IntegerAssert toHoursPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to hours part"));
    durationNodeSetter.setToHoursPart(toHoursPart);
    return this;
  }

  @Override
  public DurationNodeBuilder setToMillis(LongAssert toMillis) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to millis"));
    durationNodeSetter.setToMillis(toMillis);
    return this;
  }

  @Override
  public DurationNodeBuilder setToMillisPart(IntegerAssert toMillisPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to millis part"));
    durationNodeSetter.setToMillisPart(toMillisPart);
    return this;
  }

  @Override
  public DurationNodeBuilder setToMinutes(LongAssert toMinutes) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to minutes"));
    durationNodeSetter.setToMinutes(toMinutes);
    return this;
  }

  @Override
  public DurationNodeBuilder setToMinutesPart(IntegerAssert toMinutesPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to minutes part"));
    durationNodeSetter.setToMinutesPart(toMinutesPart);
    return this;
  }

  @Override
  public DurationNodeBuilder setToNanos(LongAssert toNanos) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to nanos"));
    durationNodeSetter.setToNanos(toNanos);
    return this;
  }

  @Override
  public DurationNodeBuilder setToNanosPart(IntegerAssert toNanosPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to nanos part"));
    durationNodeSetter.setToNanosPart(toNanosPart);
    return this;
  }

  @Override
  public DurationNodeBuilder setToSeconds(LongAssert toSeconds) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to seconds"));
    durationNodeSetter.setToSeconds(toSeconds);
    return this;
  }

  @Override
  public DurationNodeBuilder setToSecondsPart(IntegerAssert toSecondsPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to seconds part"));
    durationNodeSetter.setToSecondsPart(toSecondsPart);
    return this;
  }

  @Override
  public DurationNodeBuilder setUnits(ListAssert<? super TemporalUnit, ?> units) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "units"));
    durationNodeSetter.setUnits(units);
    return this;
  }

  @Override
  public DurationNodeBuilder setZero(BooleanAssert zero) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "zero"));
    durationNodeSetter.setZero(zero);
    return this;
  }
}
