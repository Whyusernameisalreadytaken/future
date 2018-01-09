package com.future.lambda.event;

import java.util.EventListener;

/**
 * servlet context listener
 *
 * @author liming
 * @date 2017-12-23 11:36
 */
public interface ServletContextListener<T extends ServletContextEvent> extends EventListener{

    /**
     * handle servlet context event
     * @param event
     */
    void onServletContextEvent(T event);

    /**
     * handle servlet context initialized event
     * @param event
     */
    void contextInitialized(T event);

    /**
     * handle servlet context destoryed event
     * @param event
     */
    void contextDestoryed(T event);
}
