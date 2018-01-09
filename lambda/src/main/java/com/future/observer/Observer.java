package com.future.observer;

/**
 * observer common interface
 *
 * @author liming
 * @date 2018-01-03 10:08
 */
public interface Observer<S> {

    /**
     * update method,will be invoke when subject object change,may apply callback pattern
     */
    void update(S subject);

}
