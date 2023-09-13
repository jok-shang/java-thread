package com.test.thread.methodTest;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/13 16:38
 */
public class MyThread extends Thread{


    // alt + insert
    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + ":" + i);
        }
    }
}
