package com.test.thread.method02;

import com.test.thread.method01.MyThread;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/12 21:29
 */
public class Thread02Demo {
    public static void main(String[] args) {
        /**
         * 多线程的第二种启动方式
         * 1. 自己定义一个类实现 Runnable 接口
         * 2。 重写里面的 run 方法
         * 3. 创建自己的类的对象
         * 4. 创建一个 Thread 类的对象，并开启线程
         */

        // 创建 MyRun 的对象
        // 表示多线程要执行的任务
        MyRun r = new MyRun();
        // 创建线程对象
        Thread t1  = new Thread(r);
        Thread t2  = new Thread(r);
        t1.setName("线程1");
        t2.setName("线程2");
        // 开启线程
        t1.start();
        t2.start();
    }
}
