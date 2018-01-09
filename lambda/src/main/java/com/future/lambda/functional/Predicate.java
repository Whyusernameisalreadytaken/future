package com.future.lambda.functional;

/**
 * predicate for test
 *
 * @author liming
 * @date 2017-12-22 21:29
 */
@FunctionalInterface
public interface Predicate<T> {

    /**
     *
     * @param t
     * @return
     */
    boolean test(T t);

    /**
     * default toString method
     */
    static String defaultMethod(){
        return "default method with interface";
    }
}
