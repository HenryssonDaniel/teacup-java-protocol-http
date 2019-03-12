package org.teacup.protocol.http.node;

import org.teacup.core.DefaultNodeBuilder;
import org.teacup.core.Node;
import org.teacup.core.NodeBuilder;
import org.teacup.core.assertion.ObjectAssert;

abstract class BuilderImpl<
        T, U extends Node<T>, V extends Setter<T>, X extends NodeBuilder<T, U, X>>
    extends DefaultNodeBuilder<T, U, V, X> {
  BuilderImpl(V setter) {
    super(setter);
  }

  @Override
  protected void doAssertion(ObjectAssert<T, ?> objectAssert) {
    getSetter().setAssertion(objectAssert);
  }
}
