package com.future.observer;

/**
 * subject common interface
 *
 * @author liming
 * @date 2018-01-03 10:10
 */
public interface Subject<O> {

    /**
     * register observer
     * @param observer
     */
    void registerObserver(O observer);

    /**
     * remove observer
     * @param observer
     */
    void removeObserver(O observer);

    /**
     * notify all observer when possible
     */
    void notifyObserver();
}
