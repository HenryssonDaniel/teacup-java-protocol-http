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
  @Mock private ResponseSetter<String> implementation;
  @Mock private MapAssert<String, List<String>, ?> mapAssert;
  @Mock private ObjectAssert<String, ?> objectAssert;

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
    assertThat(responseBuilder.setBody(objectAssert)).isSameAs(responseBuilder);
    verify(implementation).setBody(objectAssert);
  }

  @Test
  void setHeaders() {
    assertThat(responseBuilder.setHeaders(mapAssert)).isSameAs(responseBuilder);
    verify(implementation).setHeaders(mapAssert);
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
    var integerAssert = mock(IntegerAssert.class);

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
    assertThat(responseBuilder.setVersion(comparableAssert)).isSameAs(responseBuilder);
    verify(implementation).setVersion(comparableAssert);
  }
}
