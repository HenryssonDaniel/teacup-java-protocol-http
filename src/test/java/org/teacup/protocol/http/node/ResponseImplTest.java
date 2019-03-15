package org.teacup.protocol.http.node;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.net.http.HttpClient.Version;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.teacup.core.assertion.ComparableAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.MapAssert;
import org.teacup.core.assertion.ObjectAssert;

class ResponseImplTest {
  private final ResponseSetter<String> responseSetter = new ResponseImpl<>();

  @Mock private ComparableAssert<? super Version, ?> comparableAssert;
  @Mock private HttpResponse<String> httpResponse;
  @Mock private MapAssert<String, List<String>, ?> mapAssert;
  @Mock private ObjectAssert<? super HttpResponse<String>, ?> objectAssert;
  @Mock private Response<String> response;
  @Mock private ObjectAssert<? super String, ?> stringObjectAssert;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void setAssertion() {
    responseSetter.setAssertion(objectAssert);
    responseSetter.verify(httpResponse);

    verify(httpResponse, never()).body();
    verify(httpResponse, never()).headers();
    verify(httpResponse, never()).previousResponse();
    verify(httpResponse, never()).request();
    verify(httpResponse, never()).sslSession();
    verify(httpResponse, never()).statusCode();
    verify(httpResponse, never()).uri();
    verify(httpResponse, never()).version();

    verify(objectAssert).verify(httpResponse);
  }

  @Test
  void setBody() {
    responseSetter.setBody(stringObjectAssert);
    responseSetter.verify(httpResponse);

    verify(httpResponse).body();
    verify(httpResponse, never()).headers();
    verify(httpResponse, never()).previousResponse();
    verify(httpResponse, never()).request();
    verify(httpResponse, never()).sslSession();
    verify(httpResponse, never()).statusCode();
    verify(httpResponse, never()).uri();
    verify(httpResponse, never()).version();

    verify(stringObjectAssert).verify(httpResponse.body());
  }

  @Test
  void setHeaders() {
    when(httpResponse.headers())
        .thenReturn(HttpHeaders.of(Collections.emptyMap(), (s1, s2) -> false));

    responseSetter.setHeaders(mapAssert);
    responseSetter.verify(httpResponse);

    verify(httpResponse, never()).body();
    verify(httpResponse).headers();
    verify(httpResponse, never()).previousResponse();
    verify(httpResponse, never()).request();
    verify(httpResponse, never()).sslSession();
    verify(httpResponse, never()).statusCode();
    verify(httpResponse, never()).uri();
    verify(httpResponse, never()).version();

    verify(mapAssert).verify(httpResponse.headers().map());
  }

  @Test
  void setPreviousResponse() {
    responseSetter.setPreviousResponse(response);
    responseSetter.verify(httpResponse);

    verify(httpResponse, never()).body();
    verify(httpResponse, never()).headers();
    verify(httpResponse).previousResponse();
    verify(httpResponse, never()).request();
    verify(httpResponse, never()).sslSession();
    verify(httpResponse, never()).statusCode();
    verify(httpResponse, never()).uri();
    verify(httpResponse, never()).version();

    verify(response).verify(httpResponse.previousResponse().orElse(null));
  }

  @Test
  void setRequest() {
    var request = mock(Request.class);

    responseSetter.setRequest(request);
    responseSetter.verify(httpResponse);

    verify(httpResponse, never()).body();
    verify(httpResponse, never()).headers();
    verify(httpResponse, never()).previousResponse();
    verify(httpResponse).request();
    verify(httpResponse, never()).sslSession();
    verify(httpResponse, never()).statusCode();
    verify(httpResponse, never()).uri();
    verify(httpResponse, never()).version();

    verify(request).verify(httpResponse.request());
  }

  @Test
  void setSslSession() {
    var sslSession = mock(SslSession.class);

    responseSetter.setSslSession(sslSession);
    responseSetter.verify(httpResponse);

    verify(httpResponse, never()).body();
    verify(httpResponse, never()).headers();
    verify(httpResponse, never()).previousResponse();
    verify(httpResponse, never()).request();
    verify(httpResponse).sslSession();
    verify(httpResponse, never()).statusCode();
    verify(httpResponse, never()).uri();
    verify(httpResponse, never()).version();

    verify(sslSession).verify(httpResponse.sslSession().orElse(null));
  }

  @Test
  void setStatusCode() {
    IntegerAssert<?> integerAssert = mock(IntegerAssert.class);

    responseSetter.setStatusCode(integerAssert);
    responseSetter.verify(httpResponse);

    verify(httpResponse, never()).body();
    verify(httpResponse, never()).headers();
    verify(httpResponse, never()).previousResponse();
    verify(httpResponse, never()).request();
    verify(httpResponse, never()).sslSession();
    verify(httpResponse).statusCode();
    verify(httpResponse, never()).uri();
    verify(httpResponse, never()).version();

    verify(integerAssert).verify(httpResponse.statusCode());
  }

  @Test
  void setUri() {
    var uri = mock(Uri.class);

    responseSetter.setUri(uri);
    responseSetter.verify(httpResponse);

    verify(httpResponse, never()).body();
    verify(httpResponse, never()).headers();
    verify(httpResponse, never()).previousResponse();
    verify(httpResponse, never()).request();
    verify(httpResponse, never()).sslSession();
    verify(httpResponse, never()).statusCode();
    verify(httpResponse).uri();
    verify(httpResponse, never()).version();

    verify(uri).verify(httpResponse.uri());
  }

  @Test
  void setVersion() {
    responseSetter.setVersion(comparableAssert);
    responseSetter.verify(httpResponse);

    verify(httpResponse, never()).body();
    verify(httpResponse, never()).headers();
    verify(httpResponse, never()).previousResponse();
    verify(httpResponse, never()).request();
    verify(httpResponse, never()).sslSession();
    verify(httpResponse, never()).statusCode();
    verify(httpResponse, never()).uri();
    verify(httpResponse).version();

    verify(comparableAssert).verify(httpResponse.version());
  }
}
