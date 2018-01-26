package com.future.data.structure;

/**
 * @author liming
 * @date 2018-01-18 16:32
 */
public class Optional {

    public static void main(String[] args) {
        java.util.Optional<Object> empty = java.util.Optional.empty();
        if(empty.isPresent())
            System.out.println("$");
    }
}
