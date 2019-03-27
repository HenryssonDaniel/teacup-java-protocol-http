package org.teacup.protocol.http.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ResponseBuilderImplTest {
  @InjectMocks private final ResponseBuilder responseBuilder = new ResponseBuilderImpl(0, 0L);
  @Mock private ResponseSetter implementation;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createImplementation() {
    assertThat(new ResponseBuilderImpl(0, 0L).createImplementation())
        .isExactlyInstanceOf(ResponseImpl.class);
  }

  @Test
  void setAttributes() {
    Map<String, Object> map = Collections.emptyMap();
    responseBuilder.setAttributes(map);
    verify(implementation).setAttributes(map);
  }

  @Test
  void setBody() {
    var body = "".getBytes(Charset.defaultCharset());
    responseBuilder.setBody(body);
    verify(implementation).setBody(body);
  }

  @Test
  void setFilters() {
    Map<String, ? extends List<String>> map = Collections.emptyMap();
    responseBuilder.setHeaders(map);
    verify(implementation).setHeaders(map);
  }

  @Test
  void setStreams() {
    var streams = mock(Streams.class);
    responseBuilder.setStreams(streams);
    verify(implementation).setStreams(streams);
  }
}
