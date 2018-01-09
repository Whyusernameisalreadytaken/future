package com.future.random;

import java.util.Random;

/**
 * random list
 *
 * @author liming
 * @date 2018-01-04 13:46
 */
public class RandomList {

    public static void main(String[] args) {
        Random random = new Random(49);
//        while(random.nextInt(100) < 100){
//            continue;
//        }
        System.out.println(random.nextInt());
        System.out.println(random.nextInt(100));
    }
}
