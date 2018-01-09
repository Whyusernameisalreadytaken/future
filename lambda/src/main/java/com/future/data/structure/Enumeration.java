package com.future.data.structure;

import java.net.URL;

/**
 * Enumeration
 *
 * @author liming
 * @date 2018-01-03 17:54
 */
public class Enumeration {

    java.util.Enumeration<URL> enumeration = new java.util.Enumeration<URL>() {
        @Override
        public boolean hasMoreElements() {
            return false;
        }

        @Override
        public URL nextElement() {
            return null;
        }
    };

    java.util.Enumeration<URL>[] tmp = (java.util.Enumeration<URL>[]) new java.util.Enumeration<?>[2];

    public void test(){
        Object o  = new java.util.Enumeration<?>[2];
    }
}
