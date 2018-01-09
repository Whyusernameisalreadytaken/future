package com.future.lambda.application;

import com.future.lambda.functional.Predicate;

import java.awt.event.ActionListener;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.Function;

import static com.future.lambda.functional.Predicate.defaultMethod;

/**
 * test for functional interface predicate
 *
 * @author liming
 * @date 2017-12-22 21:36
 */
public class PredicateTest {

    public static void main(String[] args) {
        defaultMethod();
        List<String> s = new ArrayList<String>(){
            @Override
            public boolean add(String s) {return add(s);}

        };

        s.forEach(x -> x.toUpperCase());

        List<Long> l = new ArrayList<Long>(){
            @Override
            public boolean add(Long aLong) {
                return add(aLong);
            }
        };
        System.out.println("1$");

        List<Integer> i = new ArrayList<Integer>(){{
            add(1);
        }};
        Class iC = i.getClass();
        Class sC = iC.getSuperclass();
        System.out.println("2$");

        call(() -> new Object());

        boolean r = checkEmpty4List(o -> {
            if(o.size() > 0) return true;
            return false;
        });

        boolean or = checkEmpty4List(ss -> ss.size() > 0);
        System.out.println(or);


        String bs = Optional.ofNullable(new ArrayList<Integer>(){{add(1);add(2);}}).map(List::size).map(Integer::toBinaryString).orElse(null);
        Optional.ofNullable(new ArrayList<Integer>(){{add(1);add(2);}}).map(new Function<ArrayList<Integer>, Integer>() {

            /**
             * Applies this function to the given argument.
             *
             * @param integers the function argument
             * @return the function result
             */
            @Override
            public Integer apply(ArrayList<Integer> integers) {
                return integers.size();
            }
        }).map(o -> o.intValue());
        System.out.println(bs);

    }

    /**
     * check if a list is empty
     * @param p
     * @param c
     * @param <T>
     * @return
     */
    public static <T> boolean checkEmpty4List(Predicate p, Collection c){
        return p.test(c);
    }

    public static boolean checkEmpty4List(Predicate<List<String>> p){
        List l = new ArrayList(){{add("1");}};
        return p.test(l);
    }

    /**
     * instance for a list object with a null element
     * @param <T>
     * @return
     */
    public <T> List<T> instance(){
        return new ArrayList<T>();
    }

    /**
     * wapper call method of Callable interface
     * @param c
     * @param <T>
     * @return
     */
    public static <T> T call(Callable<T> c){
        try {
            return c.call();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * instance a lambda object
     */
    public void instanceForLambdaExpression() {
        Comparator<String> c = (s1,s2) -> s1.compareTo(s2);
        Comparator<String> s = Comparator.naturalOrder();
        addActionListener(e -> System.out.println(e.getActionCommand()));
    }

    /**
     * add ActionListener
     * @param l
     */
    protected void addActionListener(ActionListener l){
    }

}
