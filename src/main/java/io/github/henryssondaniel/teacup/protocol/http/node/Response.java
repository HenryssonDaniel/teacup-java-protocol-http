package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.protocol.Node;
import java.net.http.HttpResponse;

/**
 * Response.
 *
 * @since 1.0
 */
@FunctionalInterface
public interface Response<T> extends Node<HttpResponse<T>> {}
