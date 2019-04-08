package io.github.henryssondaniel.teacup.protocol.http.server;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

class TimeoutSupplierImpl implements TimeoutSupplier {
  private static final Logger LOGGER = Logger.getLogger(TimeoutSupplierImpl.class.getName());

  private final Object lock = new Object();
  private final List<Request> requests = new LinkedList<>();

  private Consumer<? super List<Request>> consumerStopped;
  private boolean empty = true;
  private boolean running = true;

  @Override
  public void addRequest(Request request) {
    LOGGER.log(Level.FINE, "Adding the request");

    synchronized (lock) {
      requests.add(request);
      empty = false;
      lock.notifyAll();
    }
  }

  @Override
  public List<Request> get() {
    List<Request> temporaryList = new ArrayList<>(requests);

    if (running)
      try {
        synchronized (lock) {
          while (empty) lock.wait(1L);

          temporaryList.clear();
          temporaryList.addAll(requests);

          requests.clear();
          empty = true;
        }
      } catch (InterruptedException e) {
        LOGGER.log(Level.SEVERE, "The supplier got interrupted", e);
        Thread.currentThread().interrupt();
      }
    else requests.clear();

    return temporaryList;
  }

  @Override
  public void stop() {
    LOGGER.log(Level.FINE, "Stopping the supplier");
    consumerStopped.accept(null);
    running = false;
  }

  @Override
  public void whenStopped(Consumer<? super List<Request>> consumer) {
    LOGGER.log(Level.FINE, "When stopped");
    consumerStopped = consumer;
  }
}
