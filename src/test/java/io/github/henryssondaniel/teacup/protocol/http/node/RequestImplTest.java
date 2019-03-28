package io.github.henryssondaniel.teacup.protocol.http.node;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.github.henryssondaniel.teacup.core.assertion.BooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.ComparableAssert;
import io.github.henryssondaniel.teacup.core.assertion.MapAssert;
import io.github.henryssondaniel.teacup.core.assertion.ObjectAssert;
import io.github.henryssondaniel.teacup.core.assertion.StringAssert;
import java.net.URI;
import java.net.http.HttpClient.Version;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class RequestImplTest {
  private final HttpRequest httpRequest = new TestHttpRequest();
  private final RequestSetter requestSetter = new RequestImpl();

  @Mock private ComparableAssert<? super Version, ?> comparableAssert;
  @Mock private MapAssert<String, List<String>, ?> mapAssert;
  @Mock private ObjectAssert<? super HttpRequest, ?> objectAssert;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void setAssertion() {
    requestSetter.setAssertion(objectAssert);
    requestSetter.verify(httpRequest);

    verify(objectAssert).verify(httpRequest);
  }

  @Test
  void setBodyPublisher() {
    var publisher = mock(BodyPublisher.class);

    requestSetter.setBodyPublisher(publisher);
    requestSetter.verify(httpRequest);

    verify(publisher).verify(httpRequest.bodyPublisher().orElse(null));
  }

  @Test
  void setExpectContinue() {
    BooleanAssert<?> booleanAssert = mock(BooleanAssert.class);

    requestSetter.setExpectContinue(booleanAssert);
    requestSetter.verify(httpRequest);

    verify(booleanAssert).verify(httpRequest.expectContinue());
  }

  @Test
  void setMethod() {
    StringAssert<?> stringAssert = mock(StringAssert.class);

    requestSetter.setMethod(stringAssert);
    requestSetter.verify(httpRequest);

    verify(stringAssert).verify(httpRequest.method());
  }

  @Test
  void setName() {
    requestSetter.setHeaders(mapAssert);
    requestSetter.verify(httpRequest);

    verify(mapAssert).verify(httpRequest.headers().map());
  }

  @Test
  void setTimeout() {
    var duration = mock(io.github.henryssondaniel.teacup.protocol.http.node.Duration.class);

    requestSetter.setTimeout(duration);
    requestSetter.verify(httpRequest);

    verify(duration).verify(httpRequest.timeout().orElse(null));
  }

  @Test
  void setUri() {
    var uri = mock(Uri.class);

    requestSetter.setUri(uri);
    requestSetter.verify(httpRequest);

    verify(uri).verify(httpRequest.uri());
  }

  @Test
  void setVersion() {
    requestSetter.setVersion(comparableAssert);
    requestSetter.verify(httpRequest);

    verify(comparableAssert).verify(httpRequest.version().orElse(null));
  }

  private static final class TestHttpRequest extends HttpRequest {
    private static final Logger LOGGER = Logger.getLogger(TestHttpRequest.class.getName());

    @Override
    public Optional<BodyPublisher> bodyPublisher() {
      LOGGER.log(Level.FINE, "Body publisher");
      return Optional.empty();
    }

    @Override
    public boolean expectContinue() {
      LOGGER.log(Level.FINE, "Expect continue");
      return false;
    }

    @Override
    public HttpHeaders headers() {
      LOGGER.log(Level.FINE, "Headers");
      return HttpHeaders.of(Collections.emptyMap(), (s1, s2) -> false);
    }

    @Override
    public String method() {
      LOGGER.log(Level.FINE, "Method");
      return null;
    }

    @Override
    public Optional<Duration> timeout() {
      LOGGER.log(Level.FINE, "Timeout");
      return Optional.empty();
    }

    @Override
    public URI uri() {
      LOGGER.log(Level.FINE, "URI");
      return null;
    }

    @Override
    public Optional<Version> version() {
      LOGGER.log(Level.FINE, "Version");
      return Optional.empty();
    }
  }
}
