package com.future.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liming
 * @date 2018-01-09 20:00
 */
public class Client {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(1);
        list.add(9);
        list.add(2);

        System.out.println(list);
        Collections.sort(list, (o1, o2) -> o1 - o2 > 0 ? 1 : -1);
        System.out.println(list);
    }
}
