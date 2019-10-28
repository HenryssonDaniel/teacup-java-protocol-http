package io.github.henryssondaniel.teacup.protocol.http.server;

import com.sun.net.httpserver.HttpHandler;

interface Handler
    extends HttpHandler, io.github.henryssondaniel.teacup.protocol.server.Handler<Request> {
  Response getResponse();
}
