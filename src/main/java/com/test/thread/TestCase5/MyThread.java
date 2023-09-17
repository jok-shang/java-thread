package com.test.thread.TestCase5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/17 16:50
 */
public class MyThread extends Thread {

    ArrayList<Integer> list;

    public MyThread(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (MyThread.class) {
                if (list.size() == 0) {
                    break;
                } else {
                    // 继续抽奖
                    // 打乱集合顺序
                    Collections.shuffle(list);
                    Integer prize = list.remove(0);
                    System.out.println(getName() + "又产生一个" + prize + "元大奖");
//                    Integer integer = list.get(0);
//                    list.remove(0);
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
