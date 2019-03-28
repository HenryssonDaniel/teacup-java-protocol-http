package org.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.Node;
import java.net.http.HttpResponse;

/**
 * Response.
 *
 * @since 1.0
 */
@FunctionalInterface
public interface Response<T> extends Node<HttpResponse<T>> {}
