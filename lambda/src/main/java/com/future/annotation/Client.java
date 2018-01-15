package com.future.annotation;


import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.security.ProtectionDomain;
import java.util.*;

/**
 * @author liming
 * @date 2018-01-09 12:04
 */
@Owner(value = "Client")
@Owner(value = "Test")
public class Client<T> {

    public static<T> void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Annotation[] annotations = Owner.class.getAnnotations();

        boolean annotation = Owner.class.isAnnotation();

        Class<?>[] interfaces = Owner.class.getInterfaces();

        Target target = Owner.class.getAnnotation(Target.class);

        ProtectionDomain protectionDomain = Owner.class.getProtectionDomain();

        Annotation[] original = Client.class.getAnnotations();
        //@com.future.annotation.Container(s="", value={@com.future.annotation.Owner(value="Client"), @com.future.annotation.Owner(value="Test")})

        Class<? extends Annotation> aClass = original[0].annotationType();

        System.out.println(original[0].toString());

        System.out.println();

        String s = new @Owner String();
        Object k0 = "k0";
        String k = (@Owner String) k0;

        /**
         * Determines if the class or interface represented by this
         * {@code Class} object is either the same as, or is a superclass or
         * superinterface of, the class or interface represented by the specified
         * {@code Class} parameter. It returns {@code true} if so;
         * otherwise it returns {@code false}. If this {@code Class}
         * object represents a primitive type, this method returns
         * {@code true} if the specified {@code Class} parameter is
         * exactly this {@code Class} object; otherwise it returns
         * {@code false}.
         *
         * <p> Specifically, this method tests whether the type represented by the
         * specified {@code Class} parameter can be converted to the type
         * represented by this {@code Class} object via an identity conversion
         * or via a widening reference conversion. See <em>The Java Language
         * Specification</em>, sections 5.1.1 and 5.1.4 , for details.
         *
         * @param cls the {@code Class} object to be checked
         * @return the {@code boolean} value indicating whether objects of the
         * type {@code cls} can be assigned to objects of this class
         * @exception NullPointerException if the specified Class parameter is
         *            null.
         * @since 1.1
         */
        System.out.println(Annotation.class.isAssignableFrom(Owner.class));



    }

    public void test() throws @Owner RuntimeException{

    }


}
