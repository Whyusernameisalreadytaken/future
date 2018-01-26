package com.future.bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author liming
 * @date 2018-01-09 17:59
 */
public class Client {

    private static void test1() {
        BigDecimal b = new BigDecimal(4.5125);
        BigDecimal divisor = new BigDecimal(100);
        BigDecimal result = b.divide(divisor).multiply(new BigDecimal(369));
        System.out.println(result);
        System.out.println(result.setScale(2));
    }


    private static void test2() {
        BigDecimal b = BigDecimal.ZERO.setScale(4);
        System.out.println(b);
        BigDecimal a = new BigDecimal(5).setScale(3);
        BigDecimal c = a.setScale(8);
        BigDecimal d = new BigDecimal("1.2567842");
        BigDecimal e = b.add(d);
        System.out.println(a);
        System.out.println(c);
        System.out.println(e);
    }

    private static void test3() {
       String s = "1.23456";
       BigDecimal b = new BigDecimal(s);
       BigDecimal nb = b.setScale(4,RoundingMode.UP);
       System.out.println(b);
       System.out.println(nb);
    }

    private static void test4() {
        double d = 1.23456D;
        System.out.println(d);//1.23456
        BigDecimal b = new BigDecimal(d);
        System.out.println(b);//1.2345600000000001017497197608463466167449951171875

        BigDecimal z = new BigDecimal("1.23456");
        BigDecimal x = BigDecimal.valueOf(d);
        System.out.println(z);//1.23456
        System.out.println(x);//1.23456
    }

    private static void test5() {
        BigDecimal devided = new BigDecimal("1.0");
        BigDecimal devisor = new BigDecimal("0.9");
        BigDecimal result = devided.divide(devisor,4,RoundingMode.UP);
        System.out.println(result);
    }

    public static void main(String[] args) {
        test5();
    }
}
