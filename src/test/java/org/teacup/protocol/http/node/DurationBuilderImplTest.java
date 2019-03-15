package org.teacup.protocol.http.node;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.time.temporal.TemporalUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.ListAssert;
import org.teacup.core.assertion.LongAssert;

class DurationBuilderImplTest {
  private final BooleanAssert<?> booleanAssert = mock(BooleanAssert.class);
  private final Duration duration = mock(Duration.class);
  @InjectMocks private final DurationBuilder durationBuilder = new DurationBuilderImpl();
  private final IntegerAssert<?> integerAssert = mock(IntegerAssert.class);
  private final LongAssert<?> longAssert = mock(LongAssert.class);

  @Mock private ListAssert<? super TemporalUnit, ?> listAssert;
  @Mock private DurationSetter setter;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createSetter() {
    assertThat(new DurationBuilderImpl().createSetter()).isExactlyInstanceOf(DurationImpl.class);
  }

  @Test
  void setAbs() {
    assertThat(durationBuilder.setAbs(duration)).isSameAs(durationBuilder);
    verify(setter).setAbs(duration);
  }

  @Test
  void setNano() {
    assertThat(durationBuilder.setNano(integerAssert)).isSameAs(durationBuilder);
    verify(setter).setNano(integerAssert);
  }

  @Test
  void setNegated() {
    assertThat(durationBuilder.setNegated(duration)).isSameAs(durationBuilder);
    verify(setter).setNegated(duration);
  }

  @Test
  void setNegative() {
    assertThat(durationBuilder.setNegative(booleanAssert)).isSameAs(durationBuilder);
    verify(setter).setNegative(booleanAssert);
  }

  @Test
  void setSeconds() {
    assertThat(durationBuilder.setSeconds(longAssert)).isSameAs(durationBuilder);
    verify(setter).setSeconds(longAssert);
  }

  @Test
  void setToDays() {
    assertThat(durationBuilder.setToDays(longAssert)).isSameAs(durationBuilder);
    verify(setter).setToDays(longAssert);
  }

  @Test
  void setToDaysPart() {
    assertThat(durationBuilder.setToDaysPart(longAssert)).isSameAs(durationBuilder);
    verify(setter).setToDaysPart(longAssert);
  }

  @Test
  void setToHours() {
    assertThat(durationBuilder.setToHours(longAssert)).isSameAs(durationBuilder);
    verify(setter).setToHours(longAssert);
  }

  @Test
  void setToHoursPart() {
    assertThat(durationBuilder.setToHoursPart(integerAssert)).isSameAs(durationBuilder);
    verify(setter).setToHoursPart(integerAssert);
  }

  @Test
  void setToMillis() {
    assertThat(durationBuilder.setToMillis(longAssert)).isSameAs(durationBuilder);
    verify(setter).setToMillis(longAssert);
  }

  @Test
  void setToMillisPart() {
    assertThat(durationBuilder.setToMillisPart(integerAssert)).isSameAs(durationBuilder);
    verify(setter).setToMillisPart(integerAssert);
  }

  @Test
  void setToMinutes() {
    assertThat(durationBuilder.setToMinutes(longAssert)).isSameAs(durationBuilder);
    verify(setter).setToMinutes(longAssert);
  }

  @Test
  void setToMinutesPart() {
    assertThat(durationBuilder.setToMinutesPart(integerAssert)).isSameAs(durationBuilder);
    verify(setter).setToMinutesPart(integerAssert);
  }

  @Test
  void setToNanos() {
    assertThat(durationBuilder.setToNanos(longAssert)).isSameAs(durationBuilder);
    verify(setter).setToNanos(longAssert);
  }

  @Test
  void setToNanosPart() {
    assertThat(durationBuilder.setToNanosPart(integerAssert)).isSameAs(durationBuilder);
    verify(setter).setToNanosPart(integerAssert);
  }

  @Test
  void setToSeconds() {
    assertThat(durationBuilder.setToSeconds(longAssert)).isSameAs(durationBuilder);
    verify(setter).setToSeconds(longAssert);
  }

  @Test
  void setToSecondsPart() {
    assertThat(durationBuilder.setToSecondsPart(integerAssert)).isSameAs(durationBuilder);
    verify(setter).setToSecondsPart(integerAssert);
  }

  @Test
  void setUnits() {
    assertThat(durationBuilder.setUnits(listAssert)).isSameAs(durationBuilder);
    verify(setter).setUnits(listAssert);
  }

  @Test
  void setZero() {
    assertThat(durationBuilder.setZero(booleanAssert)).isSameAs(durationBuilder);
    verify(setter).setZero(booleanAssert);
  }
}
