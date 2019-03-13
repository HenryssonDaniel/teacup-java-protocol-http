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
import org.teacup.core.assertion.ComparableAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.MapAssert;
import org.teacup.core.assertion.ObjectAssert;

class ResponseBuilderImplTest {
  @InjectMocks private final ResponseBuilder<String> responseBuilder = new ResponseBuilderImpl<>();

  @Mock private ComparableAssert<Version, ?> comparableAssert;
  @Mock private MapAssert<String, List<String>, ?> mapAssert;
  @Mock private ObjectAssert<String, ?> objectAssert;
  @Mock private ResponseSetter<String> setter;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createSetter() {
    assertThat(new ResponseBuilderImpl<>().createSetter()).isExactlyInstanceOf(ResponseImpl.class);
  }

  @Test
  void setBody() {
    assertThat(responseBuilder.setBody(objectAssert)).isSameAs(responseBuilder);
    verify(setter).setBody(objectAssert);
  }

  @Test
  void setHeaders() {
    assertThat(responseBuilder.setHeaders(mapAssert)).isSameAs(responseBuilder);
    verify(setter).setHeaders(mapAssert);
  }

  @Test
  void setPreviousResponse() {
    assertThat(responseBuilder.setPreviousResponse(setter)).isSameAs(responseBuilder);
    verify(setter).setPreviousResponse(setter);
  }

  @Test
  void setRequest() {
    var request = mock(Request.class);

    assertThat(responseBuilder.setRequest(request)).isSameAs(responseBuilder);
    verify(setter).setRequest(request);
  }

  @Test
  void setSslSession() {
    var sslSession = mock(SslSession.class);

    assertThat(responseBuilder.setSslSession(sslSession)).isSameAs(responseBuilder);
    verify(setter).setSslSession(sslSession);
  }

  @Test
  void setStatusCode() {
    var integerAssert = mock(IntegerAssert.class);

    assertThat(responseBuilder.setStatusCode(integerAssert)).isSameAs(responseBuilder);
    verify(setter).setStatusCode(integerAssert);
  }

  @Test
  void setUri() {
    var uri = mock(Uri.class);

    assertThat(responseBuilder.setUri(uri)).isSameAs(responseBuilder);
    verify(setter).setUri(uri);
  }

  @Test
  void setVersion() {
    assertThat(responseBuilder.setVersion(comparableAssert)).isSameAs(responseBuilder);
    verify(setter).setVersion(comparableAssert);
  }
}
