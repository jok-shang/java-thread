package com.test.thread;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/12 20:09
 */

/*
目标: 掌握线程的创建方式一
 */
public class ThreadTest01 {
    // main 方法是由一条默认的主线程负责执行。
    public static void main(String[] args) {
        // 3. 创建MyThread线程类的对象代表一个线程
        Thread t = new MyThread();
        // 4. 启动线程（自动执行run方法）
        t.start();  // main 线程 t线程（子线程）
        for (int i = 1; i <= 5; i++){
            System.out.println("main 主" + i);
        }
    }
}
