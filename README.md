# Java-Thread
#### 介绍
# java多线程的两个概念
*并发：在同一个时刻，有多个指令在*单个*cpu上*交替*执行<br>
*并行：在同一个时刻，有多个指令在*多个*cpu上*同时*执行<br>
# 多线程的实现方式
## 继承 Thread 类的方式进行实现
        对应代码包名：method01
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
        对应代码包名：method02
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
        对应代码包名：method03
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
# 多线程三种实现方式对比

|                 |            优点                     |          缺点                     | 对应包名|
|             --- |                ---                 |               ---                | ---|
|继承 Thread 类    |编程比较简单，可以直接使用 Thread 类中的方法|可以扩展性较差，不能再继承其他的类|method01|
|实现 Runnable 接口|扩展性强，实现该接口的同时还可以继承其他的类|编程相对复杂，不能直接使用 Thread 类中的方法|method02|
|实现 Callable 接口|扩展性强，实现该接口的同时还可以继承其他的类|编程相对复杂，不能直接使用 Thread 类中的方法|method03|

#常见的成员方法

|         方法名称                  |       说明      |对应包名|
|           ---                   |      ---        | --- |
|String getName()                 |返回此线程的名称   |methodTest|
|void setName()                   |设置线程的名字(构造方法也可以设置名字)|methodTest|
|static Thread currentThread()    |获取当前线程的对象|methodTest|
|static void sleep(long time)     |让线程休眠指定的时间，单位为毫秒|methodTest01|
|setPriority(int newPriority)     |设置线程的优先级(1~10档，1最小，10最大，默认5) |methodTest02|
|final int getPriority()          |获取线程的优先级|methodTest02|
|final void setDaemon(boolean on) |设置为守护线程(备胎线程)|methodTest03|
|public static void yield()       |出让线程/礼让线程|methodTest04|
|public static void join()        |插入线程/插队线程|methodTest05|

# 线程的生命周期
![img.png](image/生命周期.png)

# 线程安全的问题
## 同步代码块
    把操作共享数据的代码锁起来
```java
// 格式
synchronized(锁对象){
    操作共享数据的代码
        }
/*
        特点一： 锁默认打开，有一个线程进去了，锁自动关闭
        特点二： 里面的代码全部执行完毕，线程出来，锁自动打开
 */
```
        需求：某电影院目前正在上映国产大片，共有100张票，而它有3个窗口卖票，请设计一个程序模拟该电影院卖票[包名：test01]
```java
public class ThreadDemo {
    public static void main(String[] args) {
        /*
        某电影院目前正在上映国产大片，共有100张票，而它有3个窗口卖票，请设计一个程序模拟该电影院卖票
         */
        // 创建对象
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();

        // 起名字
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        // 开启线程
        t1.start();
        t2.start();
        t3.start();
    }
}


public class MyThread extends Thread{

    // 表示这个类所有的对象，都共享 ticket数据
    static int ticket = 0; // 0 ~ 99

    // 锁对象，一定要是唯一的
//    static Object obj = new Object();

    @Override
    public void run() {
        while (true){
            // 加锁 轮流执行(同步代码块)
            // MyThread.class类的字节码文件表示唯一
            synchronized (MyThread.class){
                if (ticket < 100){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket ++;
                    System.out.println(getName() + "正在卖第" + ticket + "张票");
                } else {
                    break;
                }
            }
        }
    }
}

```
## 同步方法
    就是把 synchronized 关键字加到方法上
```java
// 格式 
修饰符 synchronized 返回值类型 方法名(方法参数){...}
// 特点1：同步方法是锁住方法里面所有的代码
// 特点2：锁对象不能自己指定  非静态：this  静态：当前类的字节码文件对象
```
例子：某电影院目前正在上映国产大片，共有180张票，而它有3个窗口卖票，请设计一个程序模拟该电影院卖票
利用同步方法完成
```java
public class ThreadDemo {
    public static void main(String[] args) {
        /*
        某电影院目前正在上映国产大片，共有180张票，而它有3个窗口卖票，请设计一个程序模拟该电影院卖票
        利用同步方法完成
         */

        MyRunnable mr = new MyRunnable();

        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);
        Thread t3 = new Thread(mr);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
        
    }
}

public class MyRunnable implements Runnable{

    int ticket = 0;

    @Override
    public void run() {
        // 循环
        // 同步代码块
        // 判断共享数据是否到了末尾，如果到了末尾
        // 判断共享数据是否到了末尾，如果没有到末尾
        while (true){
            synchronized (MyRunnable.class) {
                if (method()) break;
            }
        }
    }

    // 锁对象 非静态是 this
    private synchronized boolean method() {
        if (ticket == 100){
            return true;
        }else {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticket++;
            System.out.println(Thread.currentThread().getName() + "在卖第" + ticket);
        }
        return false;
    }
}
```


# Lock锁
        代码包test03
  虽然我们可以理解同步代码块和同步方法的锁对象问题但是我们并没有直接看到在哪里加上了锁，在哪里释放了锁提供了一个新的锁对象Lock为了更清晰的表达如何加锁和释放锁，
JDK5以后提供了一个新的锁对象Lock。

  Lock实现提供比使用方法和语句可以获得更广泛的锁定操作synchronized方法和语句可以获得更广泛的锁定操作。
  Lock中提供了获得锁和释放锁的方法
  void lock(): 获得锁
  void unlock():释放锁

  Lock是接口不能直接实例化，这里采用它的实现类ReentrantLock来实例化
  ReentrantLock的构造方法
  ReentrantLock():创建一个ReentrantLock的实例
```java
public class ThreadDemo {
    public static void main(String[] args) {
        /*
        某电影院目前正在上映国产大片，共有180张票，而它有3个窗口卖票，请设计一个程序模拟该电影院卖票
        使用JDK的lock实现
         */
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

public class MyThread extends Thread {

  static int ticket = 0;
  // 创建锁对象
  static Lock lock = new ReentrantLock();

  @Override
  public void run() {
    while (true) {
      // 加锁 轮流执行(同步代码块)
      // MyThread.class类的字节码文件表示唯一
//            synchronized (MyThread.class){
      lock.lock();// 加锁
      try {
        if (ticket == 100) {
          break;
        } else {
          Thread.sleep(10);
          ticket++;
          System.out.println(getName() + "正在卖第" + ticket + "张票");
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
      }
    }
  }
}
```

# 死锁
    死锁 是指两个或两个以上的进程在执行过程中，由于竞争资源或者由于彼此通信而造成的一种阻塞的现象，若无外力作用，它们都将无法推进下去。也就是两个线程拥有锁的情况下，又在尝试获取对方的锁，从而造成程序一直阻塞的情况。
    代码包test04
```java
public class ThreadDemo {
    public static void main(String[] args) {
        /*
        需求：
            死锁
         */
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.setName("线程A");
        t2.setName("线程B");

        t1.start();
        t2.start();
    }
}


public class MyThread extends Thread {

  static Object objA = new Object();
  static Object objB = new Object();

  @Override
  public void run() {
    // 1. 循环
    while (true) {
      if ("线程A".equals(getName())) {
        synchronized (objA) {
          System.out.println("线程A拿到了A锁，准备拿B锁");
          synchronized (objB) {
            System.out.println("线程A拿到了B锁，顺利执行完一轮");
          }
        }
      } else if ("线程B".equals(getName())) {
        if ("线程B".equals(getName())) {
          synchronized (objB) {
            System.out.println("线程B拿到了B锁，准备拿A锁");
            synchronized (objA) {
              System.out.println("线程B拿到了A锁，顺利执行完一轮");
            }
          }
        }
      }
    }
  }
}
```

# 生产者和消费者（等待唤醒机制）
    生产者等待/消费者等待
    生产者消费者模式是一个十分经典的多线程协作的模式
## 生产者和消费者（常见方法）
    代码包:test05
|   方法名称  |   说明 |
|   ---      |   --- |
| void wait() | 当前线程等待,直到被其他线程唤醒|
| void notify()| 随机唤醒单个线程|
| void notifyAll()| 唤醒所有线程|
```java
// 消费者
public class Consumer extends Thread {

  @Override
  public void run() {
        /*
        1. 循环
        2. 同步代码块
        3. 判断共享数据是否到了末尾（到了末尾）
        4. 判断共享数据是否到了末尾（没有到末尾，执行核心逻辑）
         */
    while (true) {
      synchronized (Controller.lock) {
        if (Controller.count == 0) {
          break;
        } else {
          // 先判断桌子上是否有面条
          if (Controller.foodFlag == 0) {
            // 如果没有，就等待
            try {
              Controller.lock.wait();// 让当前线程跟锁进行绑定
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          } else {
            // 把吃的总数 - 1
            Controller.count--;
            // 如果有，就开吃
            System.out.println("正在消费，还能消费" + Controller.count);
            // 吃完之后，唤醒厨师继续做
            Controller.lock.notifyAll();
            // 修改状态
            Controller.foodFlag = 0;
          }
        }
      }
    }
  }
}

// 生产者
public class Producer extends Thread{

  @Override
  public void run() {
        /*
        1. 循环
        2. 同步代码块
        3. 判断共享数据是否到了末尾（到了末尾）
        4. 判断共享数据是否到了末尾（没有到末尾，执行核心逻辑）
         */
    while (true){
      synchronized (Controller.lock){
        if (Controller.count == 0){
          break;
        }else {
          // 判断桌子上是否有食物
          if (Controller.foodFlag == 1){
            // 如果有，就等待
            try {
              Controller.lock.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }else {
            // 如果没有，就制作食物
            System.out.println("开始制作食物");
            // 修改桌子尚的食物状态
            Controller.foodFlag = 1;
            // 侥幸等待的消费者开吃
            Controller.lock.notifyAll();
          }
        }
      }
    }
  }
}

// 控制线程
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

// main函数
public class ThreadDemo {
  public static void main(String[] args) {

        /*
        需求： 完成生产者和消费者（等待唤醒机制）的代码
              实现线程轮流交替执行的效果
         */

    // 创建线程对象
    Consumer c = new Consumer();
    Producer p = new Producer();

    // 给线程设置名字
    p.setName("生产者");
    c.setName("消费者");

    // 开启线程
    c.start();
    p.start();
  }
}
```

## 等待唤醒机制（阻塞队列方式实现）
**什么是阻塞队列**
* 阻塞队列（BlockingQueue）是一个支持两个附加操作的队列，这两个附加的操作支持阻塞的插入和移除方法。
* 支持阻塞的插入方法：当队列满时，队列会阻塞插入元素的线程，直到队列不满。
* 支持阻塞的移除方法：当队列为空时，获取元素的线程会等待队列变为非空。
* 阻塞队列常用于生产者和消费者场景，生产者是向队列里添加元素的线程，消费者是从队列里获取元素的线程。阻塞队列就是生产者用来存放元素、消费者用来获取元素的容器。
### 阻塞队列的继承结构
![img.png](image/阻塞队列.png)
```java
// 消费者
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


// 生产者
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


// 主函数
public class ThreadDemo {
  public static void main(String[] args) {
        /*
        需求： 利用阻塞队列完成生产者和消费者（等待唤醒机制）的代码
            细节：生产者和消费者必须使用同一个阻塞队列
         */

    // 1. 创建阻塞队列的对象
    ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

    // 2. 创建线程的对象，并把阻塞队列传递过去
    Cookie c = new Cookie(queue);
    Foodie f = new Foodie(queue);

    // 3. 开启线程
    c.start();
    f.start();
  }
}
```