package com.test.thread.test02;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/13 23:31
 */
public class MyRunnable implements Runnable{

    int ticket = 0;

    @Override
    public void run() {
        // 循环
        // 同步代码块
        // 判断共享数据是否到了末尾，如果到了末尾
        // 判断共享数据是否到了末尾，如果没有到末尾
        while (true){
            synchronized (MyRunnable.class) {
                if (method()) break;
            }
        }
    }

    // 锁对象 非静态是 this
    private synchronized boolean method() {
        if (ticket == 100){
            return true;
        }else {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticket++;
            System.out.println(Thread.currentThread().getName() + "在卖第" + ticket);
        }
        return false;
    }
}
