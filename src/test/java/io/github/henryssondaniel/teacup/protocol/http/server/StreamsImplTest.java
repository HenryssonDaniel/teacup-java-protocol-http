package io.github.henryssondaniel.teacup.protocol.http.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.io.InputStream;
import java.io.OutputStream;
import org.junit.jupiter.api.Test;

class StreamsImplTest {
  private final InputStream inputStream = mock(InputStream.class);
  private final OutputStream outputStream = mock(OutputStream.class);
  private final Streams streams = new StreamsImpl(inputStream, outputStream);

  @Test
  void getInputStream() {
    assertThat(streams.getInputStream()).isSameAs(inputStream);
  }

  @Test
  void getOutputStream() {
    assertThat(streams.getOutputStream()).isSameAs(outputStream);
  }
}
