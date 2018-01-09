package com.future.lambda.event;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

/**
 * listener for context load event
 *
 * @author liming
 * @date 2017-12-23 11:42
 */
public class ContextLoaderListener implements ServletContextListener{

    /**
     * events for this listener
     */
    private List<EventObject> events;

    private EventObject event;

    private Object monitor;


    public ContextLoaderListener (EventObject e){
        this.event = e;
        this.monitor = new Object();
    }

    public void register(EventObject e){
        if(events == null){
            synchronized (monitor){
                events = new ArrayList<>();
            }
        }else {
            events.add(e);
        }
    }

    /**
     * handle servlet context event
     *
     * @param event
     */
    @Override
    public void onServletContextEvent(ServletContextEvent event) {
        System.out.println(event.getServletContext());
    }

    /**
     * handle servlet context initialized event
     *
     * @param event
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println(event.getServletContext());

        System.out.println("$");
    }

    /**
     * handle servlet context destoryed event
     *
     * @param event
     */
    @Override
    public void contextDestoryed(ServletContextEvent event) {

    }
}
