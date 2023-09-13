package com.test.thread.methodTest03;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/13 17:06
 */
public class MyThead2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println(getName() + ":" + i);
        }
    }
}
