package org.teacup.protocol.http.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class TimeoutSupplierImplTest {
  private final Object lock = new Object();
  private final TimeoutSupplier timeoutSupplier = new TimeoutSupplierImpl();

  @Mock private Consumer<? super List<Request>> consumer;
  private boolean waiting = true;

  @Test
  void addAndGetRequest() {
    var request = mock(Request.class);
    timeoutSupplier.addRequest(request);
    assertThat(timeoutSupplier.get()).containsExactly(request);
  }

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void getWhenInterrupted() throws InterruptedException {
    List<Request> requests = new LinkedList<>();

    var thread = new Thread(() -> get(requests));
    thread.start();
    thread.interrupt();

    synchronized (lock) {
      while (waiting) lock.wait(1L);

      assertThat(requests).isEmpty();
    }
  }

  @Test
  void getWhenNotRunning() {
    timeoutSupplier.whenStopped(consumer);
    timeoutSupplier.stop();

    verify(consumer).accept(null);
    assertThat(timeoutSupplier.get()).isEmpty();
  }

  @Test
  void stop() {
    timeoutSupplier.whenStopped(consumer);
    timeoutSupplier.stop();

    verify(consumer).accept(null);
  }

  private void get(Collection<? super Request> requests) {
    synchronized (lock) {
      requests.addAll(timeoutSupplier.get());
      waiting = false;
      lock.notifyAll();
    }
  }
}
