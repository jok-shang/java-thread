package com.test.thread.methodTest05;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/13 22:23
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println(getName() + ":" + i);
        }
    }
}
