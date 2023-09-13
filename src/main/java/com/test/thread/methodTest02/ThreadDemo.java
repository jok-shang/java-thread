package com.test.thread.methodTest02;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/13 16:56
 */
public class ThreadDemo {
    /*
     设置优先级
     */
    public static void main(String[] args) {
        /*
         setPriority(int newPriority)     设置线程的优先级(1~10档，1最小，10最大，默认5)
         概率问题
         final int getPriority()          获取线程的优先级
         */

        // 创建线程要执行的参数对象
        MyRunnable mr = new MyRunnable();
        // 创建线程对象
        Thread t1 = new Thread(mr,"飞机");
        Thread t2 = new Thread(mr,"坦克");
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        // 设置线程优先
        t1.setPriority(1);
        t2.setPriority(10);
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getPriority());
    }
}
