package com.future.primitive;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 基本类型
 *
 * @author liming
 * @date 2017-12-25 16:20
 */
public class Primitive {

    public static void main(String[] args) {
        UrlEncode("#","UTF-8");
    }

    public static void UrlEncode(String s,String enc){
        try {
            System.out.println(URLEncoder.encode(s,enc));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void getLengthOfLongPrimitive(){
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
    }


}
