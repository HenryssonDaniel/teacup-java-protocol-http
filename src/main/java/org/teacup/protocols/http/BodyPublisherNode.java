package org.teacup.protocols.http;

import java.net.http.HttpRequest.BodyPublisher;
import org.teacup.core.Node;

/**
 * Body publisher node.
 *
 * @since 1.0
 */
@FunctionalInterface
public interface BodyPublisherNode extends Node<BodyPublisher> {}
