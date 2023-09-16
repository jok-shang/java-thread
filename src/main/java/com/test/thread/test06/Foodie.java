package com.test.thread.test06;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/16 23:46
 */
public class Foodie extends Thread{

    ArrayBlockingQueue<String> queue;

    public Foodie(ArrayBlockingQueue<String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            // 不断把面条放到阻塞队列当中
            try {
                String food = queue.take();
                System.out.println(food);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
