package io.github.henryssondaniel.teacup.protocol.http.node;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Factory.
 *
 * @since 1.0
 */
public enum Factory {
  ;

  private static final String CREATE_BUILDER = "Creating a new {0} builder";
  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(Factory.class);

  /**
   * Creates a new body publisher builder.
   *
   * @return the body publisher builder
   */
  public static BodyPublisherBuilder createBodyPublisherBuilder() {
    LOGGER.log(Level.FINE, CREATE_BUILDER, "body publisher");
    return new BodyPublisherBuilderImpl();
  }

  /**
   * Creates a new duration builder.
   *
   * @return the duration builder
   */
  public static DurationBuilder createDurationBuilder() {
    LOGGER.log(Level.FINE, CREATE_BUILDER, "duration");
    return new DurationBuilderImpl();
  }
  /**
   * Creates a new principal builder.
   *
   * @return the principal builder
   */
  public static PrincipalBuilder createPrincipalBuilder() {
    LOGGER.log(Level.FINE, CREATE_BUILDER, "principal");
    return new PrincipalBuilderImpl();
  }

  /**
   * Creates a new request builder.
   *
   * @return the request builder
   */
  public static RequestBuilder createRequestBuilder() {
    LOGGER.log(Level.FINE, CREATE_BUILDER, "request");
    return new RequestBuilderImpl();
  }

  /**
   * Creates a new response builder.
   *
   * @param <T> the response body type
   * @return the response builder
   */
  public static <T> ResponseBuilder<T> createResponseBuilder() {
    LOGGER.log(Level.FINE, CREATE_BUILDER, "response");
    return new ResponseBuilderImpl<>();
  }

  /**
   * Create a new SSL session builder.
   *
   * @return the SSL session builder
   */
  public static SslSessionBuilder createSslSessionBuilder() {
    LOGGER.log(Level.FINE, CREATE_BUILDER, "SSL session");
    return new SslSessionBuilderImpl();
  }

  /**
   * Create a new SSL session context builder.
   *
   * @return the SSL session context builder
   */
  public static SslSessionContextBuilder createSslSessionContextBuilder() {
    LOGGER.log(Level.FINE, CREATE_BUILDER, "SSL session context");
    return new SslSessionContextBuilderImpl();
  }

  /**
   * Create a new URI builder.
   *
   * @return the URI builder
   */
  public static UriBuilder createUriBuilder() {
    LOGGER.log(Level.FINE, CREATE_BUILDER, "URI");
    return new UriBuilderImpl();
  }
}
