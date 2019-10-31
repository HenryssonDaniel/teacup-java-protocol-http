package io.github.henryssondaniel.teacup.protocol.http.server;

import com.sun.net.httpserver.HttpHandler;

interface Handler extends HttpHandler {
  Response getResponse();
}
