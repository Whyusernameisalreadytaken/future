package com.future.lambda.event;

/**
 * servlet context
 *
 * @author liming
 * @date 2017-12-23 11:26
 */
@FunctionalInterface
public interface ServletContext<T,V> {

    /**
     * init a object
     * @param v
     * @return
     */
    T init(V v);
}
