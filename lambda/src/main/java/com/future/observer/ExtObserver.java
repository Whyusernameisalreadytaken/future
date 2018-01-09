package com.future.observer;

/**
 * extension for Observer
 *
 * @author liming
 * @date 2018-01-03 17:28
 */
public interface ExtObserver<S> extends Observer<S>{

    /**
     * subject notify observer with args
     * @param args
     */
    void update(Object...args);

    /**
     * subject notify observer with itself and extended args
     * @param subject
     * @param args
     */
    void upate(S subject,Object...args);
}
