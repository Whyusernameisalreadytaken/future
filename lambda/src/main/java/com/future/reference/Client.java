package com.future.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * client
 *
 * @author liming
 * @date 2018-01-04 22:41
 */
public class Client {

    public static void main(String[] args) {
//        Bean bean = new Bean();
//        bean.setId("1");

//        SoftReference<Bean> softReference = new SoftReference<Bean>(bean);

//        System.gc();
//        System.out.println(softReference.get());

//        WeakReference<Bean> weakReference = new WeakReference<Bean>(bean);
//        System.gc();
////        System.out.println(weakReference.get());
        SecurityManager sm = new SecurityManager();
        System.setSecurityManager(sm);
        SecurityManager securityManager = System.getSecurityManager();
        System.out.println(securityManager);

//        System.out.println(System.getSecurityManager());
//        System.out.println(System.getProperty("java.security.manager"));
//        System.out.println(System.getProperty("os.version"));
//
//        ReferenceQueue<Bean> queue = new ReferenceQueue<>();
//        PhantomReference<Bean> phantomReference =  new PhantomReference<>(bean,queue);
//        System.out.println(phantomReference.get());
//        System.out.println(queue.poll());
//        System.gc();
//        System.out.println(queue.poll());

    }
}
