package org.teacup.protocol.http.node;

import javax.net.ssl.SSLSession;
import org.teacup.core.Node;

/**
 * SSL session.
 *
 * @since 1.0
 */
@FunctionalInterface
public interface SslSession extends Node<SSLSession> {}
