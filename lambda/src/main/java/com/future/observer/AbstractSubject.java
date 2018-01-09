package com.future.observer;

import java.util.Vector;

/**
 * abstract subject
 *
 * @author liming
 * @date 2018-01-03 17:17
 */
public abstract class AbstractSubject<O,S> implements ExtSubject<O,S>{

    private Vector<O> vector;

    public AbstractSubject(){
        this.vector = new Vector<>();
    }

    /**
     * register observer
     *
     * @param observer
     */
    @Override
    public synchronized void registerObserver(O observer) {
        vector.add(observer);
    }

    /**
     * remove observer
     *
     * @param observer
     */
    @Override
    public synchronized void removeObserver(O observer) {
        vector.remove(observer);
    }

    /**
     * how many observers on this subject
     * @return
     */
    protected synchronized int countObserver(){
        return vector.size();
    }

}
