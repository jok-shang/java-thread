package com.test.thread.test05;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/16 22:44
 */
public class Controller {
    /*
    作用：
        控制生产者和消费者执行
     */

    // 判断是否有面条  0：没有面条  1：有面条
    public static int foodFlag = 0;

    // 总个数
    public static int count = 10;

    // 锁对象
    public static Object lock = new Object();

}
