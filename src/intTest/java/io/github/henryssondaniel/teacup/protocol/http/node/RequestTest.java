package io.github.henryssondaniel.teacup.protocol.http.node;

import static io.github.henryssondaniel.teacup.core.assertion.Factory.createBooleanAssert;
import static io.github.henryssondaniel.teacup.core.assertion.Factory.createStringAssert;

import java.net.URI;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.Test;

class RequestTest {
  @Test
  void verify() {
    var uri = URI.create("http://localhost");

    Factory.createRequestBuilder()
        .setBodyPublisher(
            Factory.createBodyPublisherBuilder()
                .setAssertion(
                    io.github.henryssondaniel.teacup.core.assertion.Factory
                        .<HttpRequest.BodyPublisher>createObjectAssert()
                        .isEqualTo(null))
                .build())
        .setExpectContinue(createBooleanAssert().isFalse())
        .setHeaders(
            io.github.henryssondaniel.teacup.core.assertion.Factory
                .<String, List<String>>createMapAssert()
                .isEmpty())
        .setMethod(createStringAssert().isEqualTo("GET"))
        .setTimeout(
            Factory.createDurationBuilder()
                .setAssertion(
                    io.github.henryssondaniel.teacup.core.assertion.Factory
                        .<Duration>createObjectAssert()
                        .isEqualTo(null))
                .build())
        .setUri(
            Factory.createUriBuilder()
                .setAssertion(
                    io.github.henryssondaniel.teacup.core.assertion.Factory
                        .<URI>createObjectAssert()
                        .isSameAs(uri))
                .build())
        .setVersion(
            io.github.henryssondaniel.teacup.core.assertion.Factory
                .<Version>createComparableAssert()
                .isEqualTo(null))
        .build()
        .verify(HttpRequest.newBuilder(uri).build());
  }
}
