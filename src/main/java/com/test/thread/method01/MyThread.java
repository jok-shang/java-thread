package com.test.thread.method01;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/12 21:22
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        // 线程要执行的代码
        for (int i = 0; i < 100; i++){
            System.out.println(getName()+"hello");
        }
    }
}
