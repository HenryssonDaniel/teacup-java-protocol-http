package org.teacup.protocol.http.server;

import java.io.InputStream;
import java.io.OutputStream;

class StreamsImpl implements Streams {
  private final InputStream inputStream;
  private final OutputStream outputStream;

  StreamsImpl(InputStream inputStream, OutputStream outputStream) {
    this.inputStream = inputStream;
    this.outputStream = outputStream;
  }

  @Override
  public InputStream getInputStream() {
    return inputStream;
  }

  @Override
  public OutputStream getOutputStream() {
    return outputStream;
  }
}
