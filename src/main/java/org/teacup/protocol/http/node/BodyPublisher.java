package org.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.Node;
import java.net.http.HttpRequest;

/**
 * Body publisher.
 *
 * @since 1.0
 */
@FunctionalInterface
public interface BodyPublisher extends Node<HttpRequest.BodyPublisher> {}
