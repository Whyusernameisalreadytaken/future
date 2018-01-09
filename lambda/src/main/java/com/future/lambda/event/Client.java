package com.future.lambda.event;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * client for test event pattern
 *
 * @author liming
 * @date 2017-12-23 16:06
 */
public class Client {

    public static void main(String[] args) {
        // initialize event source
        EventSource eventSource = new EventSource();
        eventSource.setContainer(new HashMap());
        ApplicationEvent applicationEvent = new ApplicationEvent(eventSource);

        // initialize listener
        ApplicationListener listener = new ApplicationListener() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                Object source = applicationEvent.getSource();
                if(source instanceof EventSource) {
                    EventSource s = (EventSource)source;
                    s.put("k.."+System.nanoTime(),System.nanoTime());
                    System.out.println(("@"));
                    System.out.println(s.getContainer());
                }
            }
        };

        // register
        applicationEvent.register(listener);

        applicationEvent.happen();

//        listener.onApplicationEvent(applicationEvent);

    }

    public void happen(){
        System.out.println("event source happen something");

    }

}
