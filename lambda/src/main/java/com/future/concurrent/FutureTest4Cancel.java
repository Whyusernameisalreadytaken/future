package com.future.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Future cancle 方法
 *
 * @author liming
 * @date 2017-12-30 10:21
 */
public class FutureTest4Cancel {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Future<?> future = executor.submit(() -> {
            int i = 0;
            while (i < 1000){
                try {
                    Thread.currentThread().sleep(10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("#" + i++);
            }
        });
        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        future.cancel(true);
        System.out.println("$");

    }

}
