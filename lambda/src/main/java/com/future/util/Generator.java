package com.future.util;

/**
 * object generator
 *
 * @author liming
 * @date 2018-01-04 14:19
 */
@FunctionalInterface
public interface Generator<T> {

    T next();
}
