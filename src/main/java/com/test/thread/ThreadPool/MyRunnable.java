package com.test.thread.ThreadPool;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/17 22:19
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName()+"---"+i);
//            System.out.println(Thread.currentThread().getName()+"---"+"i");
        }
    }
}
