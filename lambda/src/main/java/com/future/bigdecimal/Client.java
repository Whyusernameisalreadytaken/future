package com.future.bigdecimal;

import java.math.BigDecimal;

/**
 * @author liming
 * @date 2018-01-09 17:59
 */
public class Client {
    public static void main(String[] args) {
        BigDecimal b = new BigDecimal(4.5125);
        BigDecimal divisor = new BigDecimal(100);
        BigDecimal result = b.divide(divisor).multiply(new BigDecimal(369));
        System.out.println(result);
        System.out.println(result.setScale(2));
    }
}
