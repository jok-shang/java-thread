package com.test.thread.TestCase6;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/17 21:07
 */
public class MyThread extends Thread{
    ArrayList<Integer> list;

    public MyThread(ArrayList<Integer> list) {
        this.list = list;
    }
    @Override
    public void run() {
        ArrayList<Integer> boxList = new ArrayList<>();
        while (true) {
            synchronized (com.test.thread.TestCase5.MyThread.class) {
                if (list.size() == 0) {
                        System.out.println(getName() + boxList);
                    break;
                } else {
                    // 继续抽奖
                    // 打乱集合顺序
                    Collections.shuffle(list);
                    Integer prize = list.remove(0);
                    boxList.add(prize);
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
