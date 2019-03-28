package org.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.Node;
import io.github.henryssondaniel.teacup.core.assertion.ObjectAssert;

interface Setter<T> extends Node<T> {
  ObjectAssert<? super T, ?> getAssertion();

  void setAssertion(ObjectAssert<? super T, ?> assertion);
}
