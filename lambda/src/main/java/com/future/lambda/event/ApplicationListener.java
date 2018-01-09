package com.future.lambda.event;

import java.util.EventListener;

/**
 * application listener
 *
 * @author liming
 * @date 2017-12-23 11:16
 */
public interface ApplicationListener<T extends ApplicationEvent> extends EventListener {

    /**
     * handle an application event
     * @param event
     */
    void onApplicationEvent(T event);
}
