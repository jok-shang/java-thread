# Java-Thread
#### 介绍
# java多线程的两个概念
*并发：在同一个时刻，有多个指令在*单个*cpu上*交替*执行<br>
*并行：在同一个时刻，有多个指令在*多个*cpu上*同时*执行<br>
# 多线程的实现方式
## 继承 Thread 类的方式进行实现
```java
public class ThreadDemo {
    public static void main(String[] args) {
        /**
         * 多线程的第一种启动方式
         *  1. 自己定义一个类继承 Thread
         *  2. 重写 run 方法
         *  3. 创建子类的对象，并启动线程
         */
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}

public class MyThread extends Thread{

    @Override
    public void run() {
        // 线程要执行的代码
        for (int i = 0; i < 100; i++){
            System.out.println(getName()+"hello");
        }
    }
}
```
## 实现 Runnable 接口的方式进行实现
```java
public class Thread02Demo {
    public static void main(String[] args) {
        /**
         * 多线程的第二种启动方式
         * 1. 自己定义一个类实现 Runnable 接口
         * 2。 重写里面的 run 方法
         * 3. 创建自己的类的对象
         * 4. 创建一个 Thread 类的对象，并开启线程
         */

        // 创建 MyRun 的对象
        // 表示多线程要执行的任务
        MyRun r = new MyRun();
        // 创建线程对象
        Thread t1  = new Thread(r);
        Thread t2  = new Thread(r);
        t1.setName("线程1");
        t2.setName("线程2");
        // 开启线程
        t1.start();
        t2.start();
    }
}


public class MyRun implements Runnable {

    @Override
    public void run() {
        // 书写线程要执行的代码
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName()+"hello");
        }
    }
}
```
## 利用 Callable 接口和 Future 接口的方式实现
```java
public class Thread03Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 多线程的第三种实现方法
         *  特点：可以获取到多线程运行的结果
         *  1.创建一个 MyCallable 实现 Callable 接口
         *  2.重写 call（是有返回值的，表示多线程运行的结果）
         *  3.创建 MyCallable 的对象（表示多线程要执行的任务）
         *  4。创建 Future 的对象（作用管理多线程运行的结果）
         *  5.创建 Thread 类的对象，并启动（表示线程）
         */

        // 创建 MyCallable 的对象（表示多线程要执行的任务）
        MyCallable mc = new MyCallable();
        // 创建 FutureTask 的对象(作用管理多线程运行的结果)
        FutureTask<Integer> ft = new FutureTask<>(mc);
        // 创建线程的对象
        Thread t1 = new Thread(ft);
        // 启动线程
        t1.start();
        // 获取多线程的运行的结果
        Integer integer = ft.get();
        System.out.println(integer);
    }
}


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
```
# 多线程三种实现方式对bi

|                 |            优点                     |          缺点                     |
|             --- |                ---                 |               ---                |
|继承 Thread 类    |编程比较简单，可以直接使用 Thread 类中的方法|可以扩展性较差，不能再继承其他的类|
|实现 Runnable 接口|扩展性强，实现该接口的同时还可以继承其他的类|编程相对复杂，不能直接使用 Thread 类中的方法|
|实现 Callable 接口|扩展性强，实现该接口的同时还可以继承其他的类|编程相对复杂，不能直接使用 Thread 类中的方法|