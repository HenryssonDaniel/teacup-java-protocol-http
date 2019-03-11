package org.teacup.protocol.http.node;

import java.net.http.HttpRequest;
import org.teacup.core.Node;

/**
 * Body publisher.
 *
 * @since 1.0
 */
@FunctionalInterface
public interface BodyPublisher extends Node<HttpRequest.BodyPublisher> {}
