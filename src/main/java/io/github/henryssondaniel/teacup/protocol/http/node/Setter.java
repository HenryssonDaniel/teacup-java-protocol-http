package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.Node;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;

interface Setter<T> extends Node<T> {
  GenericObjectAssert<? super T, ?> getAssertion();

  void setAssertion(GenericObjectAssert<? super T, ?> assertion);
}
