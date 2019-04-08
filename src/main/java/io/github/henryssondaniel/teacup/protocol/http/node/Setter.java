package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.Node;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;

interface Setter<T> extends Node<T> {
  GenericObjectAssert<T, ?> getAssertion();

  void setAssertion(GenericObjectAssert<T, ?> assertion);
}
