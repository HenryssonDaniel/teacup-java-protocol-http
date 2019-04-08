package io.github.henryssondaniel.teacup.protocol.http.node;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.github.henryssondaniel.teacup.core.assertion.GenericBooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericListAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericLongAssert;
import java.time.temporal.TemporalUnit;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class DurationBuilderImplTest {
  private final Duration duration = mock(Duration.class);
  @InjectMocks private final DurationBuilder durationBuilder = new DurationBuilderImpl();
  private final GenericBooleanAssert<?> genericBooleanAssert = mock(GenericBooleanAssert.class);
  private final GenericIntegerAssert<?> genericIntegerAssert = mock(GenericIntegerAssert.class);
  private final GenericLongAssert<?> genericLongAssert = mock(GenericLongAssert.class);

  @Mock
  private GenericListAssert<? super TemporalUnit, ? super List<? extends TemporalUnit>, ?>
      genericListAssert;

  @Mock private DurationSetter implementation;

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
    assertThat(durationBuilder.setNano(genericIntegerAssert)).isSameAs(durationBuilder);
    verify(implementation).setNano(genericIntegerAssert);
  }

  @Test
  void setNegated() {
    assertThat(durationBuilder.setNegated(duration)).isSameAs(durationBuilder);
    verify(implementation).setNegated(duration);
  }

  @Test
  void setNegative() {
    assertThat(durationBuilder.setNegative(genericBooleanAssert)).isSameAs(durationBuilder);
    verify(implementation).setNegative(genericBooleanAssert);
  }

  @Test
  void setSeconds() {
    assertThat(durationBuilder.setSeconds(genericLongAssert)).isSameAs(durationBuilder);
    verify(implementation).setSeconds(genericLongAssert);
  }

  @Test
  void setToDays() {
    assertThat(durationBuilder.setToDays(genericLongAssert)).isSameAs(durationBuilder);
    verify(implementation).setToDays(genericLongAssert);
  }

  @Test
  void setToDaysPart() {
    assertThat(durationBuilder.setToDaysPart(genericLongAssert)).isSameAs(durationBuilder);
    verify(implementation).setToDaysPart(genericLongAssert);
  }

  @Test
  void setToHours() {
    assertThat(durationBuilder.setToHours(genericLongAssert)).isSameAs(durationBuilder);
    verify(implementation).setToHours(genericLongAssert);
  }

  @Test
  void setToHoursPart() {
    assertThat(durationBuilder.setToHoursPart(genericIntegerAssert)).isSameAs(durationBuilder);
    verify(implementation).setToHoursPart(genericIntegerAssert);
  }

  @Test
  void setToMillis() {
    assertThat(durationBuilder.setToMillis(genericLongAssert)).isSameAs(durationBuilder);
    verify(implementation).setToMillis(genericLongAssert);
  }

  @Test
  void setToMillisPart() {
    assertThat(durationBuilder.setToMillisPart(genericIntegerAssert)).isSameAs(durationBuilder);
    verify(implementation).setToMillisPart(genericIntegerAssert);
  }

  @Test
  void setToMinutes() {
    assertThat(durationBuilder.setToMinutes(genericLongAssert)).isSameAs(durationBuilder);
    verify(implementation).setToMinutes(genericLongAssert);
  }

  @Test
  void setToMinutesPart() {
    assertThat(durationBuilder.setToMinutesPart(genericIntegerAssert)).isSameAs(durationBuilder);
    verify(implementation).setToMinutesPart(genericIntegerAssert);
  }

  @Test
  void setToNanos() {
    assertThat(durationBuilder.setToNanos(genericLongAssert)).isSameAs(durationBuilder);
    verify(implementation).setToNanos(genericLongAssert);
  }

  @Test
  void setToNanosPart() {
    assertThat(durationBuilder.setToNanosPart(genericIntegerAssert)).isSameAs(durationBuilder);
    verify(implementation).setToNanosPart(genericIntegerAssert);
  }

  @Test
  void setToSeconds() {
    assertThat(durationBuilder.setToSeconds(genericLongAssert)).isSameAs(durationBuilder);
    verify(implementation).setToSeconds(genericLongAssert);
  }

  @Test
  void setToSecondsPart() {
    assertThat(durationBuilder.setToSecondsPart(genericIntegerAssert)).isSameAs(durationBuilder);
    verify(implementation).setToSecondsPart(genericIntegerAssert);
  }

  @Test
  void setUnits() {
    assertThat(durationBuilder.setUnits(genericListAssert)).isSameAs(durationBuilder);
    verify(implementation).setUnits(genericListAssert);
  }

  @Test
  void setZero() {
    assertThat(durationBuilder.setZero(genericBooleanAssert)).isSameAs(durationBuilder);
    verify(implementation).setZero(genericBooleanAssert);
  }
}
