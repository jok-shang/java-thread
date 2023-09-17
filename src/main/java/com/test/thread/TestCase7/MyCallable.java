package com.test.thread.TestCase7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/17 21:34
 */
public class MyCallable implements Callable<Integer> {
    ArrayList<Integer> list;

    public MyCallable(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public Integer call() throws Exception {
        ArrayList<Integer> boxList = new ArrayList<>();
        while (true) {
            synchronized (com.test.thread.TestCase5.MyThread.class) {
                if (list.size() == 0) {
                    System.out.println(Thread.currentThread().getName() + boxList);
                    break;
                } else {
                    // 继续抽奖
                    // 打乱集合顺序
                    Collections.shuffle(list);
                    Integer prize = list.remove(0);
                    boxList.add(prize);
                }
            }
            Thread.sleep(10);
        }
        // 把集合的最大值返回
        if (boxList.size() == 0) {
            return null;
        } else {
            return Collections.max(boxList);
        }
    }
}
