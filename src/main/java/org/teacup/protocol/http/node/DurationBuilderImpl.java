package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.SETTING_THE;

import java.time.temporal.TemporalUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.ListAssert;
import org.teacup.core.assertion.LongAssert;

class DurationBuilderImpl
    extends BuilderImpl<java.time.Duration, Duration, DurationSetter, DurationBuilder>
    implements DurationBuilder {
  private static final Logger LOGGER = Logger.getLogger(DurationBuilderImpl.class.getName());

  DurationBuilderImpl() {
    super(new DurationImpl());
  }

  @Override
  public DurationBuilder setAbs(Duration abs) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "abs"));
    getImplementation().setAbs(abs);
    return this;
  }

  @Override
  public DurationBuilder setNano(IntegerAssert<?> nano) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "nano"));
    getImplementation().setNano(nano);
    return this;
  }

  @Override
  public DurationBuilder setNegated(Duration negated) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "negated"));
    getImplementation().setNegated(negated);
    return this;
  }

  @Override
  public DurationBuilder setNegative(BooleanAssert<?> negative) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "negative"));
    getImplementation().setNegative(negative);
    return this;
  }

  @Override
  public DurationBuilder setSeconds(LongAssert<?> seconds) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "seconds"));
    getImplementation().setSeconds(seconds);
    return this;
  }

  @Override
  public DurationBuilder setToDays(LongAssert<?> toDays) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to days"));
    getImplementation().setToDays(toDays);
    return this;
  }

  @Override
  public DurationBuilder setToDaysPart(LongAssert<?> toDaysPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to days part"));
    getImplementation().setToDaysPart(toDaysPart);
    return this;
  }

  @Override
  public DurationBuilder setToHours(LongAssert<?> toHours) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to hours"));
    getImplementation().setToHours(toHours);
    return this;
  }

  @Override
  public DurationBuilder setToHoursPart(IntegerAssert<?> toHoursPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to hours part"));
    getImplementation().setToHoursPart(toHoursPart);
    return this;
  }

  @Override
  public DurationBuilder setToMillis(LongAssert<?> toMillis) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to millis"));
    getImplementation().setToMillis(toMillis);
    return this;
  }

  @Override
  public DurationBuilder setToMillisPart(IntegerAssert<?> toMillisPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to millis part"));
    getImplementation().setToMillisPart(toMillisPart);
    return this;
  }

  @Override
  public DurationBuilder setToMinutes(LongAssert<?> toMinutes) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to minutes"));
    getImplementation().setToMinutes(toMinutes);
    return this;
  }

  @Override
  public DurationBuilder setToMinutesPart(IntegerAssert<?> toMinutesPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to minutes part"));
    getImplementation().setToMinutesPart(toMinutesPart);
    return this;
  }

  @Override
  public DurationBuilder setToNanos(LongAssert<?> toNanos) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to nanos"));
    getImplementation().setToNanos(toNanos);
    return this;
  }

  @Override
  public DurationBuilder setToNanosPart(IntegerAssert<?> toNanosPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to nanos part"));
    getImplementation().setToNanosPart(toNanosPart);
    return this;
  }

  @Override
  public DurationBuilder setToSeconds(LongAssert<?> toSeconds) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to seconds"));
    getImplementation().setToSeconds(toSeconds);
    return this;
  }

  @Override
  public DurationBuilder setToSecondsPart(IntegerAssert<?> toSecondsPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "to seconds part"));
    getImplementation().setToSecondsPart(toSecondsPart);
    return this;
  }

  @Override
  public DurationBuilder setUnits(ListAssert<? super TemporalUnit, ?> units) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "units"));
    getImplementation().setUnits(units);
    return this;
  }

  @Override
  public DurationBuilder setZero(BooleanAssert<?> zero) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "zero"));
    getImplementation().setZero(zero);
    return this;
  }

  @Override
  protected DurationSetter createImplementation() {
    return new DurationImpl();
  }
}
