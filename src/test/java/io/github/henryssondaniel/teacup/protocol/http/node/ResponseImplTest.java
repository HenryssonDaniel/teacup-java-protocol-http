package io.github.henryssondaniel.teacup.protocol.http.node;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.github.henryssondaniel.teacup.core.assertion.GenericComparableAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericMapAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import java.net.http.HttpClient.Version;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ResponseImplTest {
  private final ResponseSetter<String> responseSetter = new ResponseImpl<>();

  @Mock private GenericComparableAssert<? super Version, ?> genericComparableAssert;

  @Mock
  private GenericMapAssert<String, List<String>, ? super Map<String, List<String>>, ?>
      genericMapAssert;

  @Mock private GenericObjectAssert<? super HttpResponse<String>, ?> genericObjectAssert;
  @Mock private GenericObjectAssert<? super String, ?> genericStringObjectAssert;
  @Mock private HttpResponse<String> httpResponse;
  @Mock private Response<String> response;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void setAssertion() {
    responseSetter.setAssertion(genericObjectAssert);
    responseSetter.verify(httpResponse);

    verify(httpResponse, never()).body();
    verify(httpResponse, never()).headers();
    verify(httpResponse, never()).previousResponse();
    verify(httpResponse, never()).request();
    verify(httpResponse, never()).sslSession();
    verify(httpResponse, never()).statusCode();
    verify(httpResponse, never()).uri();
    verify(httpResponse, never()).version();

    verify(genericObjectAssert).verify(httpResponse);
  }

  @Test
  void setBody() {
    responseSetter.setBody(genericStringObjectAssert);
    responseSetter.verify(httpResponse);

    verify(httpResponse).body();
    verify(httpResponse, never()).headers();
    verify(httpResponse, never()).previousResponse();
    verify(httpResponse, never()).request();
    verify(httpResponse, never()).sslSession();
    verify(httpResponse, never()).statusCode();
    verify(httpResponse, never()).uri();
    verify(httpResponse, never()).version();

    verify(genericStringObjectAssert).verify(httpResponse.body());
  }

  @Test
  void setHeaders() {
    when(httpResponse.headers())
        .thenReturn(HttpHeaders.of(Collections.emptyMap(), (s1, s2) -> false));

    responseSetter.setHeaders(genericMapAssert);
    responseSetter.verify(httpResponse);

    verify(httpResponse, never()).body();
    verify(httpResponse).headers();
    verify(httpResponse, never()).previousResponse();
    verify(httpResponse, never()).request();
    verify(httpResponse, never()).sslSession();
    verify(httpResponse, never()).statusCode();
    verify(httpResponse, never()).uri();
    verify(httpResponse, never()).version();

    verify(genericMapAssert).verify(httpResponse.headers().map());
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
    GenericIntegerAssert<?> genericIntegerAssert = mock(GenericIntegerAssert.class);

    responseSetter.setStatusCode(genericIntegerAssert);
    responseSetter.verify(httpResponse);

    verify(httpResponse, never()).body();
    verify(httpResponse, never()).headers();
    verify(httpResponse, never()).previousResponse();
    verify(httpResponse, never()).request();
    verify(httpResponse, never()).sslSession();
    verify(httpResponse).statusCode();
    verify(httpResponse, never()).uri();
    verify(httpResponse, never()).version();

    verify(genericIntegerAssert).verify(httpResponse.statusCode());
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
    responseSetter.setVersion(genericComparableAssert);
    responseSetter.verify(httpResponse);

    verify(httpResponse, never()).body();
    verify(httpResponse, never()).headers();
    verify(httpResponse, never()).previousResponse();
    verify(httpResponse, never()).request();
    verify(httpResponse, never()).sslSession();
    verify(httpResponse, never()).statusCode();
    verify(httpResponse, never()).uri();
    verify(httpResponse).version();

    verify(genericComparableAssert).verify(httpResponse.version());
  }
}
