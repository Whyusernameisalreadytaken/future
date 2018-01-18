package com.future.init;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liming
 * @date 2018-01-17 22:41
 */
public class Person {

    private static Map<String,List<String>> map = new HashMap<>();

    private static ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) {

    }


    public static List<String> get(){
        return map.get("this");
    }

    public void g(){
    }
}
