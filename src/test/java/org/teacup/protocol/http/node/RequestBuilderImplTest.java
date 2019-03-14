package org.teacup.protocol.http.node;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.net.http.HttpClient.Version;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.ComparableAssert;
import org.teacup.core.assertion.MapAssert;
import org.teacup.core.assertion.StringAssert;

class RequestBuilderImplTest {
  @InjectMocks private final RequestBuilder requestBuilder = new RequestBuilderImpl();

  @Mock private ComparableAssert<Version, ?> comparableAssert;
  @Mock private MapAssert<String, List<String>, ?> mapAssert;
  @Mock private RequestSetter setter;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createSetter() {
    assertThat(new RequestBuilderImpl().createSetter()).isExactlyInstanceOf(RequestImpl.class);
  }

  @Test
  void setBodyPublisher() {
    var bodyPublisher = mock(BodyPublisher.class);

    assertThat(requestBuilder.setBodyPublisher(bodyPublisher)).isSameAs(requestBuilder);
    verify(setter).setBodyPublisher(bodyPublisher);
  }

  @Test
  void setExpectContinue() {
    var booleanAssert = mock(BooleanAssert.class);

    assertThat(requestBuilder.setExpectContinue(booleanAssert)).isSameAs(requestBuilder);
    verify(setter).setExpectContinue(booleanAssert);
  }

  @Test
  void setHeaders() {
    assertThat(requestBuilder.setHeaders(mapAssert)).isSameAs(requestBuilder);
    verify(setter).setHeaders(mapAssert);
  }

  @Test
  void setMethod() {
    var stringAssert = mock(StringAssert.class);

    assertThat(requestBuilder.setMethod(stringAssert)).isSameAs(requestBuilder);
    verify(setter).setMethod(stringAssert);
  }

  @Test
  void setTimeout() {
    var duration = mock(Duration.class);

    assertThat(requestBuilder.setTimeout(duration)).isSameAs(requestBuilder);
    verify(setter).setTimeout(duration);
  }

  @Test
  void setUri() {
    var uri = mock(Uri.class);

    assertThat(requestBuilder.setUri(uri)).isSameAs(requestBuilder);
    verify(setter).setUri(uri);
  }

  @Test
  void setVersion() {
    assertThat(requestBuilder.setVersion(comparableAssert)).isSameAs(requestBuilder);
    verify(setter).setVersion(comparableAssert);
  }
}