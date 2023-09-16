package com.test.thread.test05;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/16 22:44
 */
public class Consumer extends Thread {

    @Override
    public void run() {
        /*
        1. 循环
        2. 同步代码块
        3. 判断共享数据是否到了末尾（到了末尾）
        4. 判断共享数据是否到了末尾（没有到末尾，执行核心逻辑）
         */
        while (true) {
            synchronized (Controller.lock) {
                if (Controller.count == 0) {
                    break;
                } else {
                    // 先判断桌子上是否有面条
                    if (Controller.foodFlag == 0) {
                        // 如果没有，就等待
                        try {
                            Controller.lock.wait();// 让当前线程跟锁进行绑定
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        // 把吃的总数 - 1
                        Controller.count--;
                        // 如果有，就开吃
                        System.out.println("正在消费，还能消费" + Controller.count);
                        // 吃完之后，唤醒厨师继续做
                        Controller.lock.notifyAll();
                        // 修改状态
                        Controller.foodFlag = 0;
                    }
                }
            }
        }
    }
}
