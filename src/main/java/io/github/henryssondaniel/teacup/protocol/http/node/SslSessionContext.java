package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.protocol.Node;
import javax.net.ssl.SSLSessionContext;

/**
 * SSL session context.
 *
 * @since 1.0
 */
@FunctionalInterface
public interface SslSessionContext extends Node<SSLSessionContext> {}
