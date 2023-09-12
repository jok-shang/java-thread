package com.test.thread.method03;

import com.test.thread.method01.MyThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/12 22:22
 */
public class Thread03Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 多线程的第三种实现方法
         *  特点：可以获取到多线程运行的结果
         *  1.创建一个 MyCallable 实现 Callable 接口
         *  2.重写 call（是有返回值的，表示多线程运行的结果）
         *  3.创建 MyCallable 的对象（表示多线程要执行的任务）
         *  4。创建 Future 的对象（作用管理多线程运行的结果）
         *  5.创建 Thread 类的对象，并启动（表示线程）
         */

        // 创建 MyCallable 的对象（表示多线程要执行的任务）
        MyCallable mc = new MyCallable();
        // 创建 FutureTask 的对象(作用管理多线程运行的结果)
        FutureTask<Integer> ft = new FutureTask<>(mc);
        // 创建线程的对象
        Thread t1 = new Thread(ft);
        // 启动线程
        t1.start();
        // 获取多线程的运行的结果
        Integer integer = ft.get();
        System.out.println(integer);
    }
}
