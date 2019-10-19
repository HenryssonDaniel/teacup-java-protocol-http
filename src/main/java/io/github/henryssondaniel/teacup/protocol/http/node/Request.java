package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.protocol.Node;
import java.net.http.HttpRequest;

/**
 * Request.
 *
 * @since 1.0
 */
@FunctionalInterface
public interface Request extends Node<HttpRequest> {}
