package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;

abstract class SetterImpl<T> implements Setter<T> {
  private GenericObjectAssert<T, ?> assertion;

  @Override
  public GenericObjectAssert<T, ?> getAssertion() {
    return assertion;
  }

  @Override
  public void setAssertion(GenericObjectAssert<T, ?> assertion) {
    this.assertion = assertion;
  }
}
