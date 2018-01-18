package com.future.reflect;

import java.util.HashMap;
import java.util.Map;

/**
 * parent
 *
 * @author liming
 * @date 2018-01-06 18:44
 */
public class Parent {

    private String country;

    private static Map<String,String> map = new HashMap<>();

    static {
        map.put("1","1");
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String get(){
        return map.get("1");
    }


}
