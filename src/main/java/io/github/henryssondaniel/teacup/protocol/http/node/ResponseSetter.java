package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericComparableAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericMapAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import java.net.http.HttpClient.Version;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

interface ResponseSetter<T> extends Response<T>, Setter<HttpResponse<T>> {
  void setBody(GenericObjectAssert<? super T, ?> body);

  void setHeaders(
      GenericMapAssert<String, List<String>, ? super Map<String, List<String>>, ?> headers);

  void setPreviousResponse(Response<T> previousResponse);

  void setRequest(Request request);

  void setSslSession(SslSession sslSession);

  void setStatusCode(GenericIntegerAssert<?> statusCode);

  void setUri(Uri uri);

  void setVersion(GenericComparableAssert<? super Version, ?> version);
}
