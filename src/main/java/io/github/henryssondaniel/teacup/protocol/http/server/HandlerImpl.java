package io.github.henryssondaniel.teacup.protocol.http.server;

import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpPrincipal;
import com.sun.net.httpserver.HttpServer;
import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class HandlerImpl implements Handler {
  private static final Logger LOGGER = Factory.getLogger(HandlerImpl.class);
  private static final Pattern PATTERN = Pattern.compile("\\A");

  private final io.github.henryssondaniel.teacup.protocol.server.Handler<? super Request> handler;
  private final Response response;

  HandlerImpl(
      io.github.henryssondaniel.teacup.protocol.server.Handler<? super Request> handler,
      Response response) {
    this.handler = handler;
    this.response = response;
  }

  @Override
  public Response getResponse() {
    return response;
  }

  @Override
  public void handle(HttpExchange httpExchange) throws IOException {
    LOGGER.log(Level.FINE, "Handle");

    response.getAttributes().forEach(httpExchange::setAttribute);

    var streams = response.getStreams();
    if (streams != null)
      httpExchange.setStreams(streams.getInputStream(), streams.getOutputStream());

    handler.addRequest(createRequest(httpExchange));

    createResponse(httpExchange);

    httpExchange.close();
  }

  private static Request createRequest(HttpExchange httpExchange) {
    var httpContext = httpExchange.getHttpContext();
    var localAddress = httpExchange.getLocalAddress();
    var httpPrincipal = httpExchange.getPrincipal();
    var protocol = httpExchange.getProtocol();
    var remoteAddress = httpExchange.getRemoteAddress();
    var body = getBody(httpExchange);
    var headers = httpExchange.getRequestHeaders();
    var method = httpExchange.getRequestMethod();
    var uri = httpExchange.getRequestURI();

    LOGGER.log(
        Level.INFO,
        () ->
            "Request:"
                + System.lineSeparator()
                + "HTTP context:"
                + System.lineSeparator()
                + logHttpContext(httpContext)
                + System.lineSeparator()
                + "Local address: "
                + localAddress
                + System.lineSeparator()
                + "Principal: "
                + httpPrincipal
                + System.lineSeparator()
                + "Protocol: "
                + protocol
                + System.lineSeparator()
                + "Remote address: "
                + remoteAddress
                + System.lineSeparator()
                + "Body: "
                + body
                + System.lineSeparator()
                + "Headers:"
                + System.lineSeparator()
                + logMap(headers)
                + System.lineSeparator()
                + "Method: "
                + method
                + System.lineSeparator()
                + "URI: "
                + uri);

    RequestSetter requestSetter = new RequestImpl();
    setupRequest(httpContext, localAddress, requestSetter);
    setupRequest(httpPrincipal, protocol, requestSetter);
    setupRequest(body, httpExchange, requestSetter);
    setupRequest(headers, method, requestSetter);
    requestSetter.setUri(uri);

    return requestSetter;
  }

  private void createResponse(HttpExchange httpExchange) throws IOException {
    setResponseHeaders(httpExchange);

    var length = response.getLength();
    httpExchange.sendResponseHeaders(response.getCode(), length);

    setResponseBody(httpExchange, length);
  }

  private static String getBody(HttpExchange httpExchange) {
    try (var scanner =
        new Scanner(httpExchange.getRequestBody(), Charset.defaultCharset())
            .useDelimiter(PATTERN)) {
      return scanner.hasNext() ? scanner.next() : "";
    }
  }

  private static String logHttpContext(HttpContext httpContext) {
    return "Attributes:"
        + System.lineSeparator()
        + logMap(httpContext.getAttributes())
        + "Authenticator: "
        + httpContext.getAuthenticator()
        + System.lineSeparator()
        + "Filters:"
        + System.lineSeparator()
        + httpContext.getFilters().stream()
            .map(Filter::description)
            .collect(Collectors.joining(", "))
        + System.lineSeparator()
        + "Handler: "
        + httpContext.getHandler()
        + System.lineSeparator()
        + "Path: "
        + httpContext.getPath()
        + System.lineSeparator()
        + "Server:"
        + System.lineSeparator()
        + logHttpServer(httpContext.getServer());
  }

  private static String logHttpServer(HttpServer httpServer) {
    return "Address: " + httpServer.getAddress();
  }

  private static String logMap(Map<String, ?> map) {
    return map.entrySet().stream()
        .map(entry -> entry.getKey() + '=' + entry.getValue())
        .collect(Collectors.joining(", ", "{", "}"));
  }

  private void setResponseBody(HttpExchange httpExchange, long length) throws IOException {
    if (length >= 0L)
      try (var outputStream = httpExchange.getResponseBody()) {
        outputStream.write(response.getBody());
      }
  }

  private void setResponseHeaders(HttpExchange httpExchange) {
    var headers = response.getHeaders();
    if (!headers.isEmpty()) httpExchange.getResponseHeaders().putAll(headers);
  }

  private static void setupRequest(
      HttpContext httpContext, InetSocketAddress localAddress, RequestSetter requestSetter) {
    requestSetter.setHttpContext(httpContext);
    requestSetter.setLocalAddress(localAddress);
  }

  private static void setupRequest(
      HttpPrincipal httpPrincipal, String protocol, RequestSetter requestSetter) {
    requestSetter.setHttpPrincipal(httpPrincipal);
    requestSetter.setProtocol(protocol);
  }

  private static void setupRequest(
      String body, HttpExchange httpExchange, RequestSetter requestSetter) {
    requestSetter.setRemoteAddress(httpExchange.getRemoteAddress());
    requestSetter.setBody(body);
  }

  private static void setupRequest(Headers headers, String method, RequestSetter requestSetter) {
    requestSetter.setHeaders(headers);
    requestSetter.setMethod(method);
  }
}
