package io.github.henryssondaniel.teacup.protocol.http.server;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ResponseTest {
  private static final int CODE = 200;
  private static final long LENGTH = 0L;

  @Test
  void createResponseBuilder() {
    Map<String, Object> attributes = Collections.singletonMap("key", "value");
    byte[] body = {(byte) 1};
    var headers = Collections.singletonMap("key", Collections.singletonList("value"));
    var streams = Factory.createStreams(null, null);

    var response =
        Factory.createResponseBuilder(CODE, LENGTH)
            .setAttributes(attributes)
            .setBody(body)
            .setHeaders(headers)
            .setStreams(streams)
            .build();
    assertThat(response.getAttributes()).isEqualTo(attributes);
    assertThat(response.getBody()).isEqualTo(body);
    assertThat(response.getCode()).isEqualTo(CODE);
    assertThat(response.getHeaders()).isEqualTo(headers);
    assertThat(response.getLength()).isSameAs(LENGTH);
    assertThat(response.getStreams()).isSameAs(streams);
  }
}
