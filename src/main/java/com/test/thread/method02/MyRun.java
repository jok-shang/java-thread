package com.test.thread.method02;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/12 21:56
 */
public class MyRun implements Runnable {

    @Override
    public void run() {
        // 书写线程要执行的代码
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName()+"hello");
        }
    }
}
