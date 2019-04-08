package io.github.henryssondaniel.teacup.protocol.http.node;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.github.henryssondaniel.teacup.core.assertion.GenericBooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericComparableAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericMapAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import java.net.http.HttpClient.Version;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class RequestBuilderImplTest {
  @InjectMocks private final RequestBuilder requestBuilder = new RequestBuilderImpl();

  @Mock private GenericComparableAssert<Version, ?> genericComparableAssert;

  @Mock
  private GenericMapAssert<String, List<String>, ? super Map<String, List<String>>, ?>
      genericMapAssert;

  @Mock private RequestSetter implementation;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createImplementation() {
    assertThat(new RequestBuilderImpl().createImplementation())
        .isExactlyInstanceOf(RequestImpl.class);
  }

  @Test
  void setBodyPublisher() {
    var bodyPublisher = mock(BodyPublisher.class);

    assertThat(requestBuilder.setBodyPublisher(bodyPublisher)).isSameAs(requestBuilder);
    verify(implementation).setBodyPublisher(bodyPublisher);
  }

  @Test
  void setExpectContinue() {
    var genericBooleanAssert = mock(GenericBooleanAssert.class);

    assertThat(requestBuilder.setExpectContinue(genericBooleanAssert)).isSameAs(requestBuilder);
    verify(implementation).setExpectContinue(genericBooleanAssert);
  }

  @Test
  void setHeaders() {
    assertThat(requestBuilder.setHeaders(genericMapAssert)).isSameAs(requestBuilder);
    verify(implementation).setHeaders(genericMapAssert);
  }

  @Test
  void setMethod() {
    var genericStringAssert = mock(GenericStringAssert.class);

    assertThat(requestBuilder.setMethod(genericStringAssert)).isSameAs(requestBuilder);
    verify(implementation).setMethod(genericStringAssert);
  }

  @Test
  void setTimeout() {
    var duration = mock(Duration.class);

    assertThat(requestBuilder.setTimeout(duration)).isSameAs(requestBuilder);
    verify(implementation).setTimeout(duration);
  }

  @Test
  void setUri() {
    var uri = mock(Uri.class);

    assertThat(requestBuilder.setUri(uri)).isSameAs(requestBuilder);
    verify(implementation).setUri(uri);
  }

  @Test
  void setVersion() {
    assertThat(requestBuilder.setVersion(genericComparableAssert)).isSameAs(requestBuilder);
    verify(implementation).setVersion(genericComparableAssert);
  }
}
