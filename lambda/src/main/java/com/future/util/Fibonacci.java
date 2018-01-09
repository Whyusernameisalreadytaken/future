package com.future.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * effective fibonacci
 *
 * @author liming
 * @date 2018-01-04 19:10
 */
public class Fibonacci implements Generator<BigDecimal>{

    @Override
    public BigDecimal next() {
//        return fib(length++);
        return fibonacci(length++);
    }

    private static final List<BigDecimal> cache = new ArrayList<>();

    /**
     * eat memory
     * @param i
     * @return
     */
    private BigDecimal fib(int i) {
        if(i <= 1) {
            cache.add(new BigDecimal(1));
            return new BigDecimal(1);
        }
        BigDecimal r = cache.get(i - 1).add(cache.get(i - 2));
        cache.add(r);
        return r;
    }

    private static final BigDecimal initial_0 = new BigDecimal(1);
    private static final BigDecimal initial_1 = new BigDecimal(1);
    private static final BigDecimal[] cacheArray = new BigDecimal[]{initial_0,initial_1};

    /**
     * recommended
     * @param i
     * @return
     */
    private BigDecimal fibonacci(int i){
        if(i <= 1){
            return cacheArray[0];
        }
        BigDecimal remove = cacheArray[0];
        cacheArray[0] = cacheArray[1];
        cacheArray[1] = remove.add(cacheArray[0]);
        return cacheArray[1];
    }


    private int length;

    public static void main(String[] args) {
        Long begin = System.nanoTime();
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0;i < 1000;i++)
            System.out.print(fibonacci.next() + " ");
        Long end = System.nanoTime();
        System.out.println("Total time: " + (end - begin));
    }
}
