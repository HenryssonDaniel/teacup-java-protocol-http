package org.teacup.protocol.http.node;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.time.temporal.TemporalUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.teacup.core.DefaultNodeBuilder;
import org.teacup.core.Utils;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.ListAssert;
import org.teacup.core.assertion.LongAssert;

class DurationBuilderImplTest {
  private final BooleanAssert booleanAssert = mock(BooleanAssert.class);
  private final Duration duration = mock(Duration.class);
  private final DurationBuilder durationBuilder = new DurationBuilderImpl();
  private final DurationSetter durationSetter = mock(DurationSetter.class);
  private final IntegerAssert integerAssert = mock(IntegerAssert.class);
  private final LongAssert longAssert = mock(LongAssert.class);

  @Mock private ListAssert<? super TemporalUnit, ?> listAssert;

  @BeforeEach
  void beforeEach() throws IllegalAccessException, NoSuchFieldException {
    Utils.setField(DefaultNodeBuilder.class, durationBuilder, "setter", durationSetter);
  }

  @Test
  void createSetter() {
    assertThat(new DurationBuilderImpl().createSetter()).isExactlyInstanceOf(DurationImpl.class);
  }

  @Test
  void setAbs() {
    assertThat(durationBuilder.setAbs(duration)).isSameAs(durationBuilder);
    verify(durationSetter).setAbs(duration);
  }

  @Test
  void setNano() {
    assertThat(durationBuilder.setNano(integerAssert)).isSameAs(durationBuilder);
    verify(durationSetter).setNano(integerAssert);
  }

  @Test
  void setNegated() {
    assertThat(durationBuilder.setNegated(duration)).isSameAs(durationBuilder);
    verify(durationSetter).setNegated(duration);
  }

  @Test
  void setNegative() {
    assertThat(durationBuilder.setNegative(booleanAssert)).isSameAs(durationBuilder);
    verify(durationSetter).setNegative(booleanAssert);
  }

  @Test
  void setSeconds() {
    assertThat(durationBuilder.setSeconds(longAssert)).isSameAs(durationBuilder);
    verify(durationSetter).setSeconds(longAssert);
  }

  @Test
  void setToDays() {
    assertThat(durationBuilder.setToDays(longAssert)).isSameAs(durationBuilder);
    verify(durationSetter).setToDays(longAssert);
  }

  @Test
  void setToDaysPart() {
    assertThat(durationBuilder.setToDaysPart(longAssert)).isSameAs(durationBuilder);
    verify(durationSetter).setToDaysPart(longAssert);
  }

  @Test
  void setToHours() {
    assertThat(durationBuilder.setToHours(longAssert)).isSameAs(durationBuilder);
    verify(durationSetter).setToHours(longAssert);
  }

  @Test
  void setToHoursPart() {
    assertThat(durationBuilder.setToHoursPart(integerAssert)).isSameAs(durationBuilder);
    verify(durationSetter).setToHoursPart(integerAssert);
  }

  @Test
  void setToMillis() {
    assertThat(durationBuilder.setToMillis(longAssert)).isSameAs(durationBuilder);
    verify(durationSetter).setToMillis(longAssert);
  }

  @Test
  void setToMillisPart() {
    assertThat(durationBuilder.setToMillisPart(integerAssert)).isSameAs(durationBuilder);
    verify(durationSetter).setToMillisPart(integerAssert);
  }

  @Test
  void setToMinutes() {
    assertThat(durationBuilder.setToMinutes(longAssert)).isSameAs(durationBuilder);
    verify(durationSetter).setToMinutes(longAssert);
  }

  @Test
  void setToMinutesPart() {
    assertThat(durationBuilder.setToMinutesPart(integerAssert)).isSameAs(durationBuilder);
    verify(durationSetter).setToMinutesPart(integerAssert);
  }

  @Test
  void setToNanos() {
    assertThat(durationBuilder.setToNanos(longAssert)).isSameAs(durationBuilder);
    verify(durationSetter).setToNanos(longAssert);
  }

  @Test
  void setToNanosPart() {
    assertThat(durationBuilder.setToNanosPart(integerAssert)).isSameAs(durationBuilder);
    verify(durationSetter).setToNanosPart(integerAssert);
  }

  @Test
  void setToSeconds() {
    assertThat(durationBuilder.setToSeconds(longAssert)).isSameAs(durationBuilder);
    verify(durationSetter).setToSeconds(longAssert);
  }

  @Test
  void setToSecondsPart() {
    assertThat(durationBuilder.setToSecondsPart(integerAssert)).isSameAs(durationBuilder);
    verify(durationSetter).setToSecondsPart(integerAssert);
  }

  @Test
  void setUnits() {
    assertThat(durationBuilder.setUnits(listAssert)).isSameAs(durationBuilder);
    verify(durationSetter).setUnits(listAssert);
  }

  @Test
  void setZero() {
    assertThat(durationBuilder.setZero(booleanAssert)).isSameAs(durationBuilder);
    verify(durationSetter).setZero(booleanAssert);
  }
}
