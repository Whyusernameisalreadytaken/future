package com.future.util;

import java.util.Random;

/**
 * serialVersionUID generator
 *
 * @author liming
 * @date 2017-12-23 11:29
 */
public class SerialVersionUIDGenerator implements Generator<Long>{

    private static final Random random = new Random();

    public final Long next(){
        return random.nextLong();
    }

    public static void main(String[] args) {
    }
}
