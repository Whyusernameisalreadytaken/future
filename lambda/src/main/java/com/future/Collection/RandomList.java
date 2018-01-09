package com.future.Collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * random list
 *
 * @author liming
 * @date 2018-01-04 14:12
 */
public class RandomList<T> {

    private List<T> list = new ArrayList<>();

    private static final Random random = new Random(47);

    public T select(){
        /*
         * avoid IllegalArgumentException
         */
        if(list.size() <= 0)
            return null;
        return list.get(random.nextInt(list.size()));
    }

    public void add(T item){
        list.add(item);
    }

    public static void main(String[] args) {
        RandomList<String> randomList = new RandomList<>();
        System.out.println(randomList.select());
    }
}
