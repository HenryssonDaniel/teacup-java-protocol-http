package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;

abstract class SetterImpl<T> implements Setter<T> {
  private GenericObjectAssert<? super T, ?> assertion;

  @Override
  public GenericObjectAssert<? super T, ?> getAssertion() {
    return assertion;
  }

  @Override
  public void setAssertion(GenericObjectAssert<? super T, ?> assertion) {
    this.assertion = assertion;
  }
}
