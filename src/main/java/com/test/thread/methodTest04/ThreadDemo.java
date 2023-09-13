package com.test.thread.methodTest04;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/13 17:17
 */
public class ThreadDemo {
    public static void main(String[] args) {
        /*
         public static void yield()       出让线程/礼让线程
         */

        MyThread m1 = new MyThread();
        MyThread m2 = new MyThread();

        m1.setName("飞机");
        m2.setName("坦克");

        m1.start();
        m2.start();
    }
}
