package org.teacup.protocol.http;

import java.net.http.HttpRequest;
import org.teacup.core.Node;

/**
 * Request node.
 *
 * @since 1.0
 */
@FunctionalInterface
public interface RequestNode extends Node<HttpRequest> {}
