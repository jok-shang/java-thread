package com.test.thread.test03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/14 13:06
 */
public class MyThread extends Thread {

    static int ticket = 0;
    // 创建锁对象
    static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            // 加锁 轮流执行(同步代码块)
            // MyThread.class类的字节码文件表示唯一
//            synchronized (MyThread.class){
            lock.lock();// 加锁
            try {
                if (ticket == 100) {
                    break;
                } else {
                    Thread.sleep(10);
                    ticket++;
                    System.out.println(getName() + "正在卖第" + ticket + "张票");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
