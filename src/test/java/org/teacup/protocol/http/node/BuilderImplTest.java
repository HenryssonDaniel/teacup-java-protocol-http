package org.teacup.protocol.http.node;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.teacup.core.Node;
import org.teacup.core.assertion.ObjectAssert;

class BuilderImplTest {
  @Mock private ObjectAssert<String, ?> objectAssert;
  @Mock private Setter<String> setter;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void doAssertion() {
    new TestBuilderImpl(setter).doAssertion(objectAssert);
    verify(setter).setAssertion(objectAssert);
  }

  private static final class TestBuilderImpl
      extends BuilderImpl<String, Node<String>, Setter<String>, TestBuilderImpl> {
    private TestBuilderImpl(Setter<String> setter) {
      super(setter);
    }

    @Override
    protected Setter<String> createSetter() {
      return null;
    }
  }
}
