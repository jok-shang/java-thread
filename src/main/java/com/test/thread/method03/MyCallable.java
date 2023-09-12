package com.test.thread.method03;

import java.util.concurrent.Callable;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/12 22:26
 */
public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        // 求 1 ~ 100 之间的和
        int sum = 0;
        for (int i = 1; i <= 100; i++){
            sum += i;
        }
        return sum;
    }
}
