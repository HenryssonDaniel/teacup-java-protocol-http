package org.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.DefaultNodeBuilder;
import io.github.henryssondaniel.teacup.core.Node;
import io.github.henryssondaniel.teacup.core.NodeBuilder;
import io.github.henryssondaniel.teacup.core.assertion.ObjectAssert;

abstract class BuilderImpl<
        T, U extends Node<T>, V extends Setter<T>, X extends NodeBuilder<T, U, X>>
    extends DefaultNodeBuilder<T, U, V, X> {
  BuilderImpl(V setter) {
    super(setter);
  }

  @Override
  protected void doAssertion(ObjectAssert<T, ?> objectAssert) {
    getImplementation().setAssertion(objectAssert);
  }
}
