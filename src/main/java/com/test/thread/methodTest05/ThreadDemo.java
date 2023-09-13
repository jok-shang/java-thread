package com.test.thread.methodTest05;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/13 22:22
 */
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        /*
        public static void join()        插入线程/插队线程
         */
        MyThread t = new MyThread();
        t.setName("土豆");
        t.start();
        // 插入线程
        t.join();

        for (int i = 0; i < 10; i++){
            System.out.println("main线程" + i);
        }
    }
}
