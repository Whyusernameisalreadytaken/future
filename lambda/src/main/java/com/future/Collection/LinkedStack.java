package com.future.Collection;

import java.util.List;

/**
 * linked stack
 *
 * @author liming
 * @date 2018-01-04 10:14
 */
public class LinkedStack<T> {

    private static class Node<U> {
        U item;
        Node<U> next;

        public Node(U item,Node<U> next){
            this.item = item;
            this.next = next;
        }

        /*
         * 构造方法不允许携带参数化类型
         */
        public Node(){
            this.item = null;
            this.next = null;
        }

        public boolean end(){
            return this.item == null && this.next == null;
        }

    }

    // end sentinel
    private Node<T> top = new Node<>();
    public void push(T item){
        top = new Node<>(item,top);
    }

    /**
     * pop the first element
     * @return
     */
    public T pop(){
        T result = top.item;
        /*
         * avoid NPE
         */
        if(!top.end()){
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
//        linkedStack.push(1);
//        linkedStack.push(2);
//        linkedStack.push(3);
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
    }
}
