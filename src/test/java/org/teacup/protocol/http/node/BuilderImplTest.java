package org.teacup.protocol.http.node;

import static org.mockito.Mockito.verify;

import io.github.henryssondaniel.teacup.core.Node;
import io.github.henryssondaniel.teacup.core.assertion.ObjectAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class BuilderImplTest {
  @Mock private Setter<String> implementation;
  @Mock private ObjectAssert<String, ?> objectAssert;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void doAssertion() {
    new TestBuilderImpl(implementation).doAssertion(objectAssert);
    verify(implementation).setAssertion(objectAssert);
  }

  private static final class TestBuilderImpl
      extends BuilderImpl<String, Node<String>, Setter<String>, TestBuilderImpl> {
    private TestBuilderImpl(Setter<String> setter) {
      super(setter);
    }

    @Override
    protected Setter<String> createImplementation() {
      return null;
    }
  }
}
