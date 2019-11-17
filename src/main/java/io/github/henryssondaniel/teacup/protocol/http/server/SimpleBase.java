package io.github.henryssondaniel.teacup.protocol.http.server;

import com.sun.net.httpserver.HttpContext;

interface SimpleBase extends Simple {
  HttpContext createProtocolContext(
      Context context, io.github.henryssondaniel.teacup.protocol.server.Handler<Request> handler);

  String getKey(Context context);

  boolean isEquals(Context context, HttpContext protocolContext);

  void serverCleanup(HttpContext protocolContext);
}
