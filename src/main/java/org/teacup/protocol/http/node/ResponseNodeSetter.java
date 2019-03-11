package org.teacup.protocol.http.node;

import java.net.http.HttpClient.Version;
import java.net.http.HttpResponse;
import java.util.List;
import org.teacup.core.assertion.ComparableAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.MapAssert;
import org.teacup.core.assertion.ObjectAssert;

interface ResponseNodeSetter<T> extends ResponseNode<T> {
  void setAssertion(ObjectAssert<? super HttpResponse<T>, ?> assertion);

  void setBody(ObjectAssert<? super T, ?> body);

  void setHeaders(MapAssert<String, List<String>, ?> headers);

  void setPreviousResponse(ResponseNode<T> previousResponse);

  void setRequest(RequestNode request);

  void setSslSession(SslSessionNode sslSession);

  void setStatusCode(IntegerAssert statusCode);

  void setUri(UriNode uri);

  void setVersion(ComparableAssert<? super Version, ?> version);
}
