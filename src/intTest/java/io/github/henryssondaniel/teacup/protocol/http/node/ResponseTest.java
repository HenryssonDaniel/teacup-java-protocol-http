package io.github.henryssondaniel.teacup.protocol.http.node;

import static io.github.henryssondaniel.teacup.core.assertion.Factory.createIntegerAssert;
import static io.github.henryssondaniel.teacup.core.assertion.Factory.createObjectAssert;

import java.net.URI;
import java.net.http.HttpClient.Version;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSession;
import org.junit.jupiter.api.Test;

class ResponseTest {
  private static final Object BODY = new Object();
  private static final URI LOCALHOST = URI.create("http://localhost");
  private static final HttpRequest HTTP_REQUEST = HttpRequest.newBuilder(LOCALHOST).build();
  private static final Map<String, List<String>> MAP = Collections.emptyMap();
  private static final SSLSession SSL_SESSION = new TestExtendedSslSession();
  private static final int STATUS_CODE = 0;
  private static final Version VERSION = Version.HTTP_1_1;

  @Test
  void verify() {
    Factory.createResponseBuilder()
        .setBody(createObjectAssert().isSameAs(BODY))
        .setHeaders(
            io.github.henryssondaniel.teacup.core.assertion.Factory
                .<String, List<String>>createMapAssert()
                .isEqualTo(MAP))
        .setPreviousResponse(
            Factory.createResponseBuilder()
                .setAssertion(
                    io.github.henryssondaniel.teacup.core.assertion.Factory
                        .<HttpResponse<Object>>createObjectAssert()
                        .isEqualTo(null))
                .build())
        .setRequest(
            Factory.createRequestBuilder()
                .setAssertion(
                    io.github.henryssondaniel.teacup.core.assertion.Factory
                        .<HttpRequest>createObjectAssert()
                        .isSameAs(HTTP_REQUEST))
                .build())
        .setSslSession(
            Factory.createSslSessionBuilder()
                .setAssertion(
                    io.github.henryssondaniel.teacup.core.assertion.Factory
                        .<SSLSession>createObjectAssert()
                        .isSameAs(SSL_SESSION))
                .build())
        .setStatusCode(createIntegerAssert().isSameAs(STATUS_CODE))
        .setUri(
            Factory.createUriBuilder()
                .setAssertion(
                    io.github.henryssondaniel.teacup.core.assertion.Factory
                        .<URI>createObjectAssert()
                        .isSameAs(LOCALHOST))
                .build())
        .setVersion(
            io.github.henryssondaniel.teacup.core.assertion.Factory
                .<Version>createComparableAssert()
                .isSameAs(VERSION))
        .build()
        .verify(new TestHttpResponse());
  }

  private static final class TestHttpResponse implements HttpResponse<Object> {
    private static final Logger LOGGER = Logger.getLogger(TestHttpResponse.class.getName());

    @Override
    public Object body() {
      LOGGER.log(Level.FINE, "Body");
      return BODY;
    }

    @Override
    public HttpHeaders headers() {
      LOGGER.log(Level.FINE, "Headers");
      return HttpHeaders.of(MAP, (s1, s2) -> true);
    }

    @Override
    public Optional<HttpResponse<Object>> previousResponse() {
      LOGGER.log(Level.FINE, "Previous response");
      return Optional.empty();
    }

    @Override
    public HttpRequest request() {
      LOGGER.log(Level.FINE, "Request");
      return HTTP_REQUEST;
    }

    @Override
    public Optional<SSLSession> sslSession() {
      LOGGER.log(Level.FINE, "SSL session");
      return Optional.of(SSL_SESSION);
    }

    @Override
    public int statusCode() {
      LOGGER.log(Level.FINE, "Status code");
      return STATUS_CODE;
    }

    @Override
    public URI uri() {
      LOGGER.log(Level.FINE, "URI");
      return LOCALHOST;
    }

    @Override
    public Version version() {
      LOGGER.log(Level.FINE, "Version");
      return VERSION;
    }
  }
}
