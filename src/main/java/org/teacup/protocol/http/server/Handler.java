package org.teacup.protocol.http.server;

import com.sun.net.httpserver.HttpHandler;
import java.util.List;

interface Handler extends HttpHandler {
  void addTimeoutSupplier(TimeoutSupplier timeoutSupplier);

  Response getResponse();

  List<TimeoutSupplier> getTimeoutSuppliers();

  void removeTimeoutSupplier(TimeoutSupplier timeoutSupplier);
}
