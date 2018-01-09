package com.future.annotation;


import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.security.ProtectionDomain;

/**
 * @author liming
 * @date 2018-01-09 12:04
 */
@Owner
public class Client {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Annotation[] annotations = Owner.class.getAnnotations();
        boolean annotation = Owner.class.isAnnotation();
        Class<?>[] interfaces = Owner.class.getInterfaces();
        Target annotation1 = Owner.class.getAnnotation(Target.class);
        ProtectionDomain protectionDomain = Owner.class.getProtectionDomain();

        Annotation[] annotations1 = Client.class.getAnnotations();
        Class<? extends Annotation> aClass = annotations1[0].annotationType();
        System.out.println(annotations1[0].toString());

        System.out.println();

    }
}
