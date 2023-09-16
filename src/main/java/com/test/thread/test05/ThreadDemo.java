package com.test.thread.test05;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/16 22:42
 */
public class ThreadDemo {
    public static void main(String[] args) {

        /*
        需求： 完成生产者和消费者（等待唤醒机制）的代码
              实现线程轮流交替执行的效果
         */

        // 创建线程对象
        Consumer c = new Consumer();
        Producer p = new Producer();

        // 给线程设置名字
        p.setName("生产者");
        c.setName("消费者");

        // 开启线程
        c.start();
        p.start();
    }
}
