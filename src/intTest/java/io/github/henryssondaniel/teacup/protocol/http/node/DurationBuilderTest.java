package io.github.henryssondaniel.teacup.protocol.http.node;

import static io.github.henryssondaniel.teacup.core.assertion.Factory.createBooleanAssert;
import static io.github.henryssondaniel.teacup.core.assertion.Factory.createIntegerAssert;
import static io.github.henryssondaniel.teacup.core.assertion.Factory.createListAssert;
import static io.github.henryssondaniel.teacup.core.assertion.Factory.createLongAssert;

import io.github.henryssondaniel.teacup.core.assertion.BooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericBooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericLongAssert;
import io.github.henryssondaniel.teacup.core.assertion.IntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.LongAssert;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.Test;

class DurationBuilderTest {
  private static final long MILLIS = 1000L;
  private static final long NANOS = 1000000000L;

  @Test
  void verify() {
    GenericBooleanAssert<BooleanAssert> booleanAssert = createBooleanAssert().isFalse();
    var duration = Duration.of(1L, ChronoUnit.SECONDS);
    GenericIntegerAssert<IntegerAssert> integerAssert = createIntegerAssert().isEqualTo(0);
    GenericLongAssert<LongAssert> longAssert = createLongAssert().isEqualTo(0L);
    GenericLongAssert<LongAssert> longAssertOne = createLongAssert().isEqualTo(1L);

    Factory.createDurationBuilder()
        .setAbs(createDuration(duration))
        .setNano(integerAssert)
        .setNegated(createDuration(duration.negated()))
        .setNegative(booleanAssert)
        .setSeconds(longAssertOne)
        .setToDays(longAssert)
        .setToDaysPart(longAssert)
        .setToHours(longAssert)
        .setToHoursPart(integerAssert)
        .setToMillis(createLongAssert().isEqualTo(MILLIS))
        .setToMillisPart(integerAssert)
        .setToMinutes(longAssert)
        .setToMinutesPart(integerAssert)
        .setToNanos(createLongAssert().isEqualTo(NANOS))
        .setToNanosPart(integerAssert)
        .setToSeconds(longAssertOne)
        .setToSecondsPart(createIntegerAssert().isEqualTo(1))
        .setUnits(createListAssert())
        .setZero(booleanAssert)
        .build()
        .verify(duration);
  }

  private static io.github.henryssondaniel.teacup.protocol.http.node.Duration createDuration(
      Duration actual) {
    return Factory.createDurationBuilder()
        .setAssertion(
            io.github.henryssondaniel.teacup.core.assertion.Factory.<Duration>createObjectAssert()
                .isEqualTo(actual))
        .build();
  }
}
