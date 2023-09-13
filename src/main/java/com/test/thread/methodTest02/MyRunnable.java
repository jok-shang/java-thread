package com.test.thread.methodTest02;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/13 16:56
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
