package io.github.henryssondaniel.teacup.protocol.http.node;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class FactoryTest {
  @Test
  void createBodyPublisherBuilder() {
    assertThat(Factory.createBodyPublisherBuilder())
        .isExactlyInstanceOf(BodyPublisherBuilderImpl.class);
  }

  @Test
  void createDurationBuilder() {
    assertThat(Factory.createDurationBuilder()).isExactlyInstanceOf(DurationBuilderImpl.class);
  }

  @Test
  void createPrincipalBuilder() {
    assertThat(Factory.createPrincipalBuilder()).isExactlyInstanceOf(PrincipalBuilderImpl.class);
  }

  @Test
  void createRequestBuilder() {
    assertThat(Factory.createRequestBuilder()).isExactlyInstanceOf(RequestBuilderImpl.class);
  }

  @Test
  void createResponseBuilder() {
    assertThat(Factory.createResponseBuilder()).isExactlyInstanceOf(ResponseBuilderImpl.class);
  }

  @Test
  void createSslSessionBuilder() {
    assertThat(Factory.createSslSessionBuilder()).isExactlyInstanceOf(SslSessionBuilderImpl.class);
  }

  @Test
  void createSslSessionContextBuilder() {
    assertThat(Factory.createSslSessionContextBuilder())
        .isExactlyInstanceOf(SslSessionContextBuilderImpl.class);
  }

  @Test
  void createUriBuilder() {
    assertThat(Factory.createUriBuilder()).isExactlyInstanceOf(UriBuilderImpl.class);
  }
}
