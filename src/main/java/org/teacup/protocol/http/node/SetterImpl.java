package org.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.ObjectAssert;

abstract class SetterImpl<T> implements Setter<T> {
  private ObjectAssert<? super T, ?> assertion;

  @Override
  public ObjectAssert<? super T, ?> getAssertion() {
    return assertion;
  }

  @Override
  public void setAssertion(ObjectAssert<? super T, ?> assertion) {
    this.assertion = assertion;
  }
}
