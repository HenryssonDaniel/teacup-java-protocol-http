package org.teacup.protocol.http.node;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.github.henryssondaniel.teacup.core.assertion.BooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.IntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.ListAssert;
import io.github.henryssondaniel.teacup.core.assertion.LongAssert;
import java.time.temporal.TemporalUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class DurationBuilderImplTest {
  private final BooleanAssert<?> booleanAssert = mock(BooleanAssert.class);
  private final Duration duration = mock(Duration.class);
  @InjectMocks private final DurationBuilder durationBuilder = new DurationBuilderImpl();
  private final IntegerAssert<?> integerAssert = mock(IntegerAssert.class);
  private final LongAssert<?> longAssert = mock(LongAssert.class);

  @Mock private DurationSetter implementation;
  @Mock private ListAssert<? super TemporalUnit, ?> listAssert;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createImplementation() {
    assertThat(new DurationBuilderImpl().createImplementation())
        .isExactlyInstanceOf(DurationImpl.class);
  }

  @Test
  void setAbs() {
    assertThat(durationBuilder.setAbs(duration)).isSameAs(durationBuilder);
    verify(implementation).setAbs(duration);
  }

  @Test
  void setNano() {
    assertThat(durationBuilder.setNano(integerAssert)).isSameAs(durationBuilder);
    verify(implementation).setNano(integerAssert);
  }

  @Test
  void setNegated() {
    assertThat(durationBuilder.setNegated(duration)).isSameAs(durationBuilder);
    verify(implementation).setNegated(duration);
  }

  @Test
  void setNegative() {
    assertThat(durationBuilder.setNegative(booleanAssert)).isSameAs(durationBuilder);
    verify(implementation).setNegative(booleanAssert);
  }

  @Test
  void setSeconds() {
    assertThat(durationBuilder.setSeconds(longAssert)).isSameAs(durationBuilder);
    verify(implementation).setSeconds(longAssert);
  }

  @Test
  void setToDays() {
    assertThat(durationBuilder.setToDays(longAssert)).isSameAs(durationBuilder);
    verify(implementation).setToDays(longAssert);
  }

  @Test
  void setToDaysPart() {
    assertThat(durationBuilder.setToDaysPart(longAssert)).isSameAs(durationBuilder);
    verify(implementation).setToDaysPart(longAssert);
  }

  @Test
  void setToHours() {
    assertThat(durationBuilder.setToHours(longAssert)).isSameAs(durationBuilder);
    verify(implementation).setToHours(longAssert);
  }

  @Test
  void setToHoursPart() {
    assertThat(durationBuilder.setToHoursPart(integerAssert)).isSameAs(durationBuilder);
    verify(implementation).setToHoursPart(integerAssert);
  }

  @Test
  void setToMillis() {
    assertThat(durationBuilder.setToMillis(longAssert)).isSameAs(durationBuilder);
    verify(implementation).setToMillis(longAssert);
  }

  @Test
  void setToMillisPart() {
    assertThat(durationBuilder.setToMillisPart(integerAssert)).isSameAs(durationBuilder);
    verify(implementation).setToMillisPart(integerAssert);
  }

  @Test
  void setToMinutes() {
    assertThat(durationBuilder.setToMinutes(longAssert)).isSameAs(durationBuilder);
    verify(implementation).setToMinutes(longAssert);
  }

  @Test
  void setToMinutesPart() {
    assertThat(durationBuilder.setToMinutesPart(integerAssert)).isSameAs(durationBuilder);
    verify(implementation).setToMinutesPart(integerAssert);
  }

  @Test
  void setToNanos() {
    assertThat(durationBuilder.setToNanos(longAssert)).isSameAs(durationBuilder);
    verify(implementation).setToNanos(longAssert);
  }

  @Test
  void setToNanosPart() {
    assertThat(durationBuilder.setToNanosPart(integerAssert)).isSameAs(durationBuilder);
    verify(implementation).setToNanosPart(integerAssert);
  }

  @Test
  void setToSeconds() {
    assertThat(durationBuilder.setToSeconds(longAssert)).isSameAs(durationBuilder);
    verify(implementation).setToSeconds(longAssert);
  }

  @Test
  void setToSecondsPart() {
    assertThat(durationBuilder.setToSecondsPart(integerAssert)).isSameAs(durationBuilder);
    verify(implementation).setToSecondsPart(integerAssert);
  }

  @Test
  void setUnits() {
    assertThat(durationBuilder.setUnits(listAssert)).isSameAs(durationBuilder);
    verify(implementation).setUnits(listAssert);
  }

  @Test
  void setZero() {
    assertThat(durationBuilder.setZero(booleanAssert)).isSameAs(durationBuilder);
    verify(implementation).setZero(booleanAssert);
  }
}
