package com.test.thread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/17 22:18
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        /*
        public static ExecutorService newCachedThreadPool|创建一个没有上线的线程池|
        public static ExecutorService newFixedThreadPool(int nThreads)|创建有上限的线程池|
         */

        // 1.获取线程池对象
        ExecutorService pool1 = Executors.newCachedThreadPool();

        // 2.提交任务
        pool1.submit(new MyRunnable());
        Thread.sleep(1000);
        pool1.submit(new MyRunnable());
        Thread.sleep(1000);
        pool1.submit(new MyRunnable());
        Thread.sleep(1000);
        pool1.submit(new MyRunnable());
        Thread.sleep(1000);
        pool1.submit(new MyRunnable());
        Thread.sleep(1000);
        // 3.销毁线程池
        pool1.shutdown();

        System.out.println("---xxx---");
        ExecutorService pool2 = Executors.newFixedThreadPool(3);

        // 2.提交任务
        pool2.submit(new MyRunnable());
        pool2.submit(new MyRunnable());
        pool2.submit(new MyRunnable());
        pool2.submit(new MyRunnable());
        pool2.submit(new MyRunnable());
        // 3.销毁线程池
        pool2.shutdown();
    }
}
