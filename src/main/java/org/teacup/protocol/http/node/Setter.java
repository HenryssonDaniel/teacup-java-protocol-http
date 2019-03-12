package org.teacup.protocol.http.node;

import org.teacup.core.Node;
import org.teacup.core.assertion.ObjectAssert;

interface Setter<T> extends Node<T> {
  ObjectAssert<? super T, ?> getAssertion();

  void setAssertion(ObjectAssert<? super T, ?> assertion);
}
