package com.future.lambda.event;


import java.util.Map;

/**
 * event source
 *
 * @author liming
 * @date 2018-01-02 16:51
 */
public class EventSource<K,V> {

    private Map container;

    public void put(K k,V v){
        assert container!=null;
        container.put(k,v);
    }

    public Map getContainer() {
        return container;
    }

    public void setContainer(Map container) {
        this.container = container;
    }
}

