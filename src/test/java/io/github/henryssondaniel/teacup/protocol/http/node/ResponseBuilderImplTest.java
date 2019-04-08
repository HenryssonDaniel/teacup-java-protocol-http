package io.github.henryssondaniel.teacup.protocol.http.node;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.github.henryssondaniel.teacup.core.assertion.GenericComparableAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericMapAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import java.net.http.HttpClient.Version;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ResponseBuilderImplTest {
  @InjectMocks private final ResponseBuilder<String> responseBuilder = new ResponseBuilderImpl<>();

  @Mock private GenericComparableAssert<Version, ?> genericComparableAssert;

  @Mock
  private GenericMapAssert<String, List<String>, ? super Map<String, List<String>>, ?>
      genericMapAssert;

  @Mock private GenericObjectAssert<String, ?> genericObjectAssert;
  @Mock private ResponseSetter<String> implementation;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createImplementation() {
    assertThat(new ResponseBuilderImpl<>().createImplementation())
        .isExactlyInstanceOf(ResponseImpl.class);
  }

  @Test
  void setBody() {
    assertThat(responseBuilder.setBody(genericObjectAssert)).isSameAs(responseBuilder);
    verify(implementation).setBody(genericObjectAssert);
  }

  @Test
  void setHeaders() {
    assertThat(responseBuilder.setHeaders(genericMapAssert)).isSameAs(responseBuilder);
    verify(implementation).setHeaders(genericMapAssert);
  }

  @Test
  void setPreviousResponse() {
    assertThat(responseBuilder.setPreviousResponse(implementation)).isSameAs(responseBuilder);
    verify(implementation).setPreviousResponse(implementation);
  }

  @Test
  void setRequest() {
    var request = mock(Request.class);

    assertThat(responseBuilder.setRequest(request)).isSameAs(responseBuilder);
    verify(implementation).setRequest(request);
  }

  @Test
  void setSslSession() {
    var sslSession = mock(SslSession.class);

    assertThat(responseBuilder.setSslSession(sslSession)).isSameAs(responseBuilder);
    verify(implementation).setSslSession(sslSession);
  }

  @Test
  void setStatusCode() {
    var integerAssert = mock(GenericIntegerAssert.class);

    assertThat(responseBuilder.setStatusCode(integerAssert)).isSameAs(responseBuilder);
    verify(implementation).setStatusCode(integerAssert);
  }

  @Test
  void setUri() {
    var uri = mock(Uri.class);

    assertThat(responseBuilder.setUri(uri)).isSameAs(responseBuilder);
    verify(implementation).setUri(uri);
  }

  @Test
  void setVersion() {
    assertThat(responseBuilder.setVersion(genericComparableAssert)).isSameAs(responseBuilder);
    verify(implementation).setVersion(genericComparableAssert);
  }
}
