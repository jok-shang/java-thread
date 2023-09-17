package com.test.thread.TestCase4;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author 尚智江
 * @description
 * @CreateDate 2023/9/17 16:06
 */
public class MyThread extends Thread {
    // 共享数据
    // 100块，分成三个包
    static BigDecimal money = new BigDecimal(100);
    static int count = 3;

    // 最小中奖金额
    static final BigDecimal MIN = BigDecimal.valueOf(0.01);

    @Override
    public void run() {
        synchronized (MyThread.class) {
            if (count == 0) {
                // 判断共享数据已经到末尾
                System.out.println(getName() + "未抢到红包");
            } else {
                // 判断共享数据没有到末尾
                // 定义一个变量，表示中奖的金额
                BigDecimal prize;
                if (count == 1) {
                    // 表示此时是最后一个红包
                    // 就无需随机，剩余所有的钱就是中奖金额
                    prize = money;
                } else {
                    // 获取抽奖范围
                    double bounds = money.subtract(BigDecimal.valueOf(count - 1).multiply(MIN)).doubleValue();
                    Random r = new Random();
                    // 抽奖金额
                    prize = BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(0, bounds));
                }
                // 设置抽中红包，小数点保留两位，四舍五入
                prize = prize.setScale(2, RoundingMode.HALF_UP);
                // 在总金额中去掉对应的钱
                money = money.subtract(prize);
                // 红包个数减少
                count--;
                // 输出红包信息
                System.out.println(getName() + "抽中了" + prize + "元");
            }
        }
    }
}
