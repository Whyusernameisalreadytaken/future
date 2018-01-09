package com.future.lambda.event;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

/**
 * servlet context event
 *
 * @author liming
 * @date 2017-12-23 11:23
 */
public class ServletContextEvent<T> extends EventObject{

    private static final long  serialVersionUID = 7732879423908225263L;

    /**
     * listeners on this event
     */
    private List<ServletContextListener> listeners = new ArrayList<>();

    public void register(ServletContextListener listener){
        listeners.add(listener);
    }

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ServletContextEvent(ServletContext source) {
        super(source);
    }

    /**
     * get the event source object alias Servlet context
     * @return
     */
    public ServletContext getServletContext(){
        return (ServletContext) super.getSource();
    }
}
