package com.test.thread.test03;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/14 13:06
 */
public class ThreadDemo {
    public static void main(String[] args) {
        /*
        某电影院目前正在上映国产大片，共有180张票，而它有3个窗口卖票，请设计一个程序模拟该电影院卖票
        使用JDK的lock实现
         */
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
