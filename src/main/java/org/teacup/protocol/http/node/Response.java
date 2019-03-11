package org.teacup.protocol.http.node;

import java.net.http.HttpResponse;
import org.teacup.core.Node;

/**
 * Response.
 *
 * @since 1.0
 */
@FunctionalInterface
public interface Response<T> extends Node<HttpResponse<T>> {}
