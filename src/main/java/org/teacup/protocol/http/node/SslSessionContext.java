package org.teacup.protocol.http.node;

import javax.net.ssl.SSLSessionContext;
import org.teacup.core.Node;

/**
 * SSL session context.
 *
 * @since 1.0
 */
@FunctionalInterface
public interface SslSessionContext extends Node<SSLSessionContext> {}