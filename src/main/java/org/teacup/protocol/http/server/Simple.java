package org.teacup.protocol.http.server;

import java.util.List;
import java.util.function.Supplier;
import org.teacup.core.Server;

/**
 * A simple HTTP server.
 *
 * @since 1.0
 */
public interface Simple extends Server {
  /**
   * Removes the supplier from the context.
   *
   * @param supplier the supplier
   */
  void removeSupplier(Supplier<List<Request>> supplier);

  /**
   * Sets the context to the server and returns a supplier.
   *
   * @param context the context
   * @return the supplier
   */
  Supplier<List<Request>> setContext(Context context);
}