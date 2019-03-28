package org.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.Node;
import java.net.http.HttpRequest;

/**
 * Request.
 *
 * @since 1.0
 */
@FunctionalInterface
public interface Request extends Node<HttpRequest> {}
