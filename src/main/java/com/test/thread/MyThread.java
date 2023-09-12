package com.test.thread;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/12 20:10
 */

/*
    1. 让子类继承Thread线程类
 */
public class MyThread extends Thread{
    // 2. 必须重写Thread类的run方法
    @Override
    public void run(){
        // 描述线程的执行任务
        for (int i = 1; i <= 5; i++){
            System.out.println("子线程" + i);
        }
    }
}