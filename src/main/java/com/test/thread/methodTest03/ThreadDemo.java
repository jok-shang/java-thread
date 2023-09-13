package com.test.thread.methodTest03;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/13 17:06
 */
public class ThreadDemo {
    public static void main(String[] args) {
        /*
        final void setDaemon(boolean on)  设置为守护线程(备胎线程)
        细节：
            当其他的非守护线程执行完毕之后，守护线程会陆续结束
         */

        MyThread1 m1 = new MyThread1();
        MyThead2 m2 = new MyThead2();

        m1.setName("A");
        m2.setName("备胎");

        // 设置为守护线程
        m2.setDaemon(true);

        m1.start();
        m2.start();
    }
}
