package com.test.thread.test05;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/16 22:43
 */
public class Producer extends Thread{

    @Override
    public void run() {
        /*
        1. 循环
        2. 同步代码块
        3. 判断共享数据是否到了末尾（到了末尾）
        4. 判断共享数据是否到了末尾（没有到末尾，执行核心逻辑）
         */
        while (true){
            synchronized (Controller.lock){
                if (Controller.count == 0){
                    break;
                }else {
                    // 判断桌子上是否有食物
                    if (Controller.foodFlag == 1){
                        // 如果有，就等待
                        try {
                            Controller.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        // 如果没有，就制作食物
                        System.out.println("开始制作食物");
                        // 修改桌子尚的食物状态
                        Controller.foodFlag = 1;
                        // 侥幸等待的消费者开吃
                        Controller.lock.notifyAll();
                    }
                }
            }
        }
    }
}
