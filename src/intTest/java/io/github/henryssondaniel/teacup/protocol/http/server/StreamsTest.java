package io.github.henryssondaniel.teacup.protocol.http.server;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.junit.jupiter.api.Test;

class StreamsTest {
  @Test
  void createStreamsBuilder() throws IOException {
    InputStream inStream;
    OutputStream outStream;
    Streams streams;

    try (var inputStream = InputStream.nullInputStream();
        var outputStream = OutputStream.nullOutputStream()) {
      inStream = inputStream;
      outStream = outputStream;
      streams = Factory.createStreams(inputStream, outputStream);
    }

    try (var input = streams.getInputStream()) {
      assertThat(input).isSameAs(inStream);
    }

    try (var output = streams.getOutputStream()) {
      assertThat(output).isSameAs(outStream);
    }
  }
}
