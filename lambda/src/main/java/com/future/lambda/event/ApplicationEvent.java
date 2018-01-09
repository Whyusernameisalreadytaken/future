package com.future.lambda.event;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import java.util.Objects;

/**
 * application event
 *
 * @author liming
 * @date 2017-12-23 11:01
 */
public class ApplicationEvent extends EventObject {

    /**
     * system time when event happens
     */
    private final long timestamp;

    /**
     * listeners on this event
     */
    private List<ApplicationListener> listeners;

    /**
     * must define own constructor for parent class does not have no-args constructor
     * @param source
     */
    public ApplicationEvent(Object source){
        super(source);
        this.listeners = new ArrayList<>();
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * return the timestamp which represent the actual time when event happens
     * @return
     */
    public long getTimestamp(){
        return this.timestamp;
    }


    /**
     * register a listener on this event
     * @param listener
     * @return true if register success,otherwise false
     */
    public boolean register(ApplicationListener listener){
        return this.listeners.add(listener);
    }

    /**
     * event happen something
     */
    public void happen(){
        System.out.println("Event happen something.");
        assert Objects.isNull(listeners) || listeners.size() <= 0;
        listeners.forEach(listener -> listener.onApplicationEvent(this));
    }

}
