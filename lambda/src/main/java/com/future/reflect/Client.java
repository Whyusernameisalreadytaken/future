package com.future.reflect;


/**
 * client
 *
 * @author liming
 * @date 2018-01-06 18:45
 */
public class Client {

    public static void main(String[] args) throws Exception {

//        Class<?> sc = Class.forName("com.future.reflect.Son");
//        System.out.println(sc);
//
//        Constructor constructor = sc.getDeclaredConstructor();
//
//        Son son = (Son) constructor.newInstance();
//
//        System.out.println(son);

        Son s = new Son();
        s.setCountry("ZN");
        s.setName("WL");
        System.out.println(s);
        s.getCountry();
    }
}
