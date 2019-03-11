package org.teacup.protocols.http;

import javax.net.ssl.SSLSession;
import org.teacup.core.Node;

/**
 * SSL session node.
 *
 * @since 1.0
 */
@FunctionalInterface
public interface SslSessionNode extends Node<SSLSession> {}
