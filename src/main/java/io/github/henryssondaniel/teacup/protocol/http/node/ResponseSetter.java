package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.ComparableAssert;
import io.github.henryssondaniel.teacup.core.assertion.IntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.MapAssert;
import io.github.henryssondaniel.teacup.core.assertion.ObjectAssert;
import java.net.http.HttpClient.Version;
import java.net.http.HttpResponse;
import java.util.List;

interface ResponseSetter<T> extends Response<T>, Setter<HttpResponse<T>> {
  void setBody(ObjectAssert<? super T, ?> body);

  void setHeaders(MapAssert<String, List<String>, ?> headers);

  void setPreviousResponse(Response<T> previousResponse);

  void setRequest(Request request);

  void setSslSession(SslSession sslSession);

  void setStatusCode(IntegerAssert<?> statusCode);

  void setUri(Uri uri);

  void setVersion(ComparableAssert<? super Version, ?> version);
}
