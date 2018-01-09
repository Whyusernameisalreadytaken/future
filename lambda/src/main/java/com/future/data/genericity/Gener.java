package com.future.data.genericity;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

/**
 * Gener
 *
 * @author liming
 * @date 2018-01-03 18:09
 */
public class Gener<T,R> {

    private Class<T> tClass;

    public Gener(Class<T> tClass){
        this.tClass = tClass;
    }

    public static void main(String[] args) {

        List<?>[] ls = new ArrayList<?>[10];
        List<String>[] ll = (List<String>[]) new ArrayList<?>[10];
//        List<String>[] lk = new ArrayList<?>[10];
        List<?>[] lt = new ArrayList[10];
        Enumeration<URL>[] tmp = (Enumeration<URL>[]) new Enumeration<?>[2];
     }

    private static void genericalArray() {
        Gener<String,String>[] geners = new Gener[2];
        Object[] objs = geners;

        Gener<Integer,Integer> gener = new Gener<>(Integer.class);
        gener.setValue(1);
        objs[0] = gener;

        Gener<String,String> s = geners[0];
        String sk = s.getValue();
        System.out.println(sk);
    }


    R[] createArray(int size){
        return (R[])Array.newInstance(tClass,size);
    }

    public interface K{
        void dk();
    }

    public <S extends Date & K> S test(S s){
        s.toLocaleString();
        s.dk();
        return null;
    }


    private T value;

    public T getValue(){
        return value;
    }

    public void setValue(T value){
        this.value = value;
    }
}
