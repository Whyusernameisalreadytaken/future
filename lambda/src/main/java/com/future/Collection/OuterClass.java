package com.future.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * outer class
 *
 * @author liming
 * @date 2018-01-04 10:37
 */
public class OuterClass {
    public static void main(String[] args) {
        List<?> list = new ArrayList<>();
        Iterator iterator = list.iterator();
    }
}
