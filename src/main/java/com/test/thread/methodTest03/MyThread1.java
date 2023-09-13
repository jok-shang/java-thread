package com.test.thread.methodTest03;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/13 17:05
 */
public class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println(getName() + ":" + i);
        }
    }
}
