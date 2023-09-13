package com.test.thread.test01;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/13 23:05
 */
public class MyThread extends Thread{

    // 表示这个类所有的对象，都共享 ticket数据
    static int ticket = 0; // 0 ~ 99

    // 锁对象，一定要是唯一的
//    static Object obj = new Object();

    @Override
    public void run() {
        while (true){
            // 加锁 轮流执行(同步代码块)
            // MyThread.class类的字节码文件表示唯一
            synchronized (MyThread.class){
                if (ticket < 100){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket ++;
                    System.out.println(getName() + "正在卖第" + ticket + "张票");
                } else {
                    break;
                }
            }
        }
    }
}
