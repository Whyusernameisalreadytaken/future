package com.future.Collection;

import java.lang.reflect.Field;

/**
 * coffee
 *
 * @author liming
 * @date 2018-01-04 14:42
 */
public class Coffee {

    private static long counter = 0;

    private static final long id = counter++;

    @Override
    public String toString() {
//        return getClass().getSimpleName() + "  " + id;
        return super.toString();
    }

    static class Mocha extends Coffee {}
    static class Cappuccino extends Coffee {}
    static class Latte extends Coffee {}

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {

    }
}
