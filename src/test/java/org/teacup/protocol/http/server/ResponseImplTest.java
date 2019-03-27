package org.teacup.protocol.http.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import com.sun.net.httpserver.Headers;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ResponseImplTest {
  private static final int CODE = 200;
  private static final long LENGTH = 0L;

  private final ResponseSetter requestSetter = new ResponseImpl(CODE, LENGTH);

  @Test
  void getAttributes() {
    assertThat(requestSetter.getAttributes()).isEmpty();
  }

  @Test
  void getBody() {
    assertThat(requestSetter.getBody()).isNull();
  }

  @Test
  void getCode() {
    assertThat(requestSetter.getCode()).isEqualTo(CODE);
  }

  @Test
  void getHeaders() {
    assertThat(requestSetter.getHeaders()).isEmpty();
  }

  @Test
  void getLength() {
    assertThat(requestSetter.getLength()).isEqualTo(LENGTH);
  }

  @Test
  void getStreams() {
    assertThat(requestSetter.getStreams()).isNull();
  }

  @Test
  void setAndGetAttributes() {
    Map<String, Object> map = Collections.emptyMap();
    requestSetter.setAttributes(map);
    assertThat(requestSetter.getAttributes()).isEqualTo(map);
  }

  @Test
  void setAndGetBody() {
    var body = "body".getBytes(Charset.defaultCharset());
    requestSetter.setBody(body);
    assertThat(requestSetter.getBody()).isEqualTo(body);
  }

  @Test
  void setAndGetHeaders() {
    Map<String, List<String>> headers = mock(Headers.class);
    requestSetter.setHeaders(headers);
    assertThat(requestSetter.getHeaders()).isEqualTo(headers);
  }

  @Test
  void setAndGetStreams() {
    var streams = mock(Streams.class);
    requestSetter.setStreams(streams);
    assertThat(requestSetter.getStreams()).isSameAs(streams);
  }
}
