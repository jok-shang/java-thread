package com.test.thread.methodTest04;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/13 17:18
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println(getName() + ":" + i);
            // 表示出让当前cpu的执行权（尽可能均匀）
            Thread.yield();
        }
    }
}
