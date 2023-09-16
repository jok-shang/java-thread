package com.test.thread.test06;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/16 23:45
 */
public class Cookie extends Thread{

    ArrayBlockingQueue<String> queue;

    public Cookie(ArrayBlockingQueue<String> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true){
            // 不断把面条放到阻塞队列当中
            try {
                queue.put("面条");
                System.out.println("厨师放了一碗面条");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
