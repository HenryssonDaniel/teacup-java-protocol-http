package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.Node;
import javax.net.ssl.SSLSession;

/**
 * SSL session.
 *
 * @since 1.0
 */
@FunctionalInterface
public interface SslSession extends Node<SSLSession> {}
