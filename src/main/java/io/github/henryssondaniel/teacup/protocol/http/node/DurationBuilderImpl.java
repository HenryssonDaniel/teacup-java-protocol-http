package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericBooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericListAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericLongAssert;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class DurationBuilderImpl
    extends BuilderImpl<java.time.Duration, Duration, DurationSetter, DurationBuilder>
    implements DurationBuilder {
  private static final Logger LOGGER = Logger.getLogger(DurationBuilderImpl.class.getName());

  DurationBuilderImpl() {
    super(new DurationImpl());
  }

  @Override
  public DurationBuilder setAbs(Duration abs) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "abs");
    getImplementation().setAbs(abs);
    return this;
  }

  @Override
  public DurationBuilder setNano(GenericIntegerAssert<?> nano) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "nano");
    getImplementation().setNano(nano);
    return this;
  }

  @Override
  public DurationBuilder setNegated(Duration negated) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "negated");
    getImplementation().setNegated(negated);
    return this;
  }

  @Override
  public DurationBuilder setNegative(GenericBooleanAssert<?> negative) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "negative");
    getImplementation().setNegative(negative);
    return this;
  }

  @Override
  public DurationBuilder setSeconds(GenericLongAssert<?> seconds) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "seconds");
    getImplementation().setSeconds(seconds);
    return this;
  }

  @Override
  public DurationBuilder setToDays(GenericLongAssert<?> toDays) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "to days");
    getImplementation().setToDays(toDays);
    return this;
  }

  @Override
  public DurationBuilder setToDaysPart(GenericLongAssert<?> toDaysPart) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "to days part");
    getImplementation().setToDaysPart(toDaysPart);
    return this;
  }

  @Override
  public DurationBuilder setToHours(GenericLongAssert<?> toHours) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "to hours");
    getImplementation().setToHours(toHours);
    return this;
  }

  @Override
  public DurationBuilder setToHoursPart(GenericIntegerAssert<?> toHoursPart) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "to hours part");
    getImplementation().setToHoursPart(toHoursPart);
    return this;
  }

  @Override
  public DurationBuilder setToMillis(GenericLongAssert<?> toMillis) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "to millis");
    getImplementation().setToMillis(toMillis);
    return this;
  }

  @Override
  public DurationBuilder setToMillisPart(GenericIntegerAssert<?> toMillisPart) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "to millis part");
    getImplementation().setToMillisPart(toMillisPart);
    return this;
  }

  @Override
  public DurationBuilder setToMinutes(GenericLongAssert<?> toMinutes) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "to minutes");
    getImplementation().setToMinutes(toMinutes);
    return this;
  }

  @Override
  public DurationBuilder setToMinutesPart(GenericIntegerAssert<?> toMinutesPart) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "to minutes part");
    getImplementation().setToMinutesPart(toMinutesPart);
    return this;
  }

  @Override
  public DurationBuilder setToNanos(GenericLongAssert<?> toNanos) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "to nanos");
    getImplementation().setToNanos(toNanos);
    return this;
  }

  @Override
  public DurationBuilder setToNanosPart(GenericIntegerAssert<?> toNanosPart) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "to nanos part");
    getImplementation().setToNanosPart(toNanosPart);
    return this;
  }

  @Override
  public DurationBuilder setToSeconds(GenericLongAssert<?> toSeconds) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "to seconds");
    getImplementation().setToSeconds(toSeconds);
    return this;
  }

  @Override
  public DurationBuilder setToSecondsPart(GenericIntegerAssert<?> toSecondsPart) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "to seconds part");
    getImplementation().setToSecondsPart(toSecondsPart);
    return this;
  }

  @Override
  public DurationBuilder setUnits(
      GenericListAssert<? super TemporalUnit, ? super List<? extends TemporalUnit>, ?> units) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "units");
    getImplementation().setUnits(units);
    return this;
  }

  @Override
  public DurationBuilder setZero(GenericBooleanAssert<?> zero) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "zero");
    getImplementation().setZero(zero);
    return this;
  }

  @Override
  protected DurationSetter createImplementation() {
    return new DurationImpl();
  }
}
