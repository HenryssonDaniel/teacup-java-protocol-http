package org.teacup.protocol.http;

import java.net.http.HttpResponse;
import org.teacup.core.Node;

/**
 * Response node.
 *
 * @since 1.0
 */
@FunctionalInterface
public interface ResponseNode<T> extends Node<HttpResponse<T>> {}
