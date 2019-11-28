package com.ww.LearningTheCorrectPostureOfTheThreadPool15;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.concurrent.*;

/**
 * @author: Sun
 * @create: 2019-11-28 10:00
 * @version: v1.0
 */
public class LearningTheCorrectPostureOfTheThreadPool15 {

    /**
     *《手册》第14页有关于线程池的论述:
     *【强制】创建线程或线程池时请指定有意义的线程名称，方便出错时回溯。
     *【强制】线程资源必须通过线程池提供，不允许在应用中自行显式创建线程。
     *【强制】线程池不允许使用Executors 去创建，而是通过ThreadPoolExecutor的方式。这样的处理方式让写的同学更加明确线程池的
     * 运行规则，规避资源耗尽的风险。
     */

    /**
     * 本节问题：
     * 1、线程池那么重要，我们该如何学习线程池?
     * <p>
     * 2、为什么创建线程或线程池时请指定有意义的线程名称？
     * 答：手册中给出的答案是方便出错时回溯。
     * 下面为JSTack抓取的线程信息：
     * 默认命名："pool-1-thread-1" #11 prio=5 os_prio=31 tid=0x00007fa0964c7000 nid=0x4403 waiting on condition [0x000070000db67000]...at java.lang.Thread.run(Thread.java:748)
     * 自定义命名："定时短息任务线程 thread-2" #11 prio=5 os_prio=31 tid=0x00007fa0964c7000 nid=0x4403 waiting on condition [0x000070000db67000]...at java.lang.Thread.run(Thread.java:748)
     * 通过自定义名称，我们可以快速理解所关注的线程所属的线程池，对一些问题可以快速作出预判。
     * <p>
     * 3、为什么不允许在应用中自行显式创建线程？
     * 这里要先看一个设计模式: “对象池模式”，参见《Java 设计模式及实践》34 页。
     * 对象的实例化是最耗费性能的操作之一，这在过去是一个大问题，现在已经不需要再那么关注。但当我们处理封装外部资源的对象(例如数据库连接)时，
     * 对象的创建会耗费很多资源。解决方案就是重用和共享这些创建成本昂贵的对象，这被称为对象池模式。
     * <p>
     * (1)线程的创建需要开辟虚拟机栈、本地方法栈、程序计数器等线程私有的内存空间。线程销毁时也会回收这些系统资源，因此如果频繁创建和销毁线程
     * 将大量消耗系统资源。从上述特点我们可以看出，该场景非常符合对象池设计模式，其核心目的是复用资源消耗较大的对象。
     * (2)不提倡手动创建线程的另外一个原因是线程池自身的优点，使用线程池有利于控制最大并发数,可以实现任务队列的缓存和拒绝策略，实现定时和
     * 周期执行任务，可以更好地隔离不同的场景等。
     * 4、线程池不允许使用Executors 去创建，而是通过ThreadPoolExecutor的方式？
     * 我们使用Executors.newFixedThreadPool(5);创建线程池时我们发现
     * (1)FixedThreadPool的核心线程数和最大线程数相等
     * (2)该方法内部创建工作队列时使用的new LinkedBlockingQueue<Runnable>()，我们看该构造方法发现创建的此工作队列大小为整数的最大值。
     * 我们试想该场景：如果对该线程池的请求不断增多，达到核心线程数后，任务将暂存到该工作队列。但是这个阻塞队列是“无界”的，如果大量任务过来，
     * 工作队列可能还没达到整数最大值可能就已经OOM了。
     *
     * 如果我们自定义线程池对象，可以设置相对可控的最大线程数和可控的工作队列长度以及拒绝策略。那么即使任务大量堆积，在OOM之前就进入了拒绝策略。
     * 总之通过自定义线程池参数，线程池的可控性更强。所以最好是手动使用ThreadPoolExecutor方式创建线程池。
     *
     */

    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
    private static ExecutorService singleThreadPool = new ThreadPoolExecutor(5, 5,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        // 第一种方式
        Thread sunshine = new Thread(() -> System.out.println("Begin Thread!"));
        sunshine.start();

        // 第二种方式
        Runnable runnable = () -> System.out.println("Begin Runnable");
        runnable.run();

        // 第三种方式
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(sunshine);
        executorService.shutdown();

        // 第四种方式
        singleThreadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
        singleThreadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
        singleThreadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
        singleThreadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
        singleThreadPool.execute(() -> System.out.println(Thread.currentThread().getName()));

        singleThreadPool.shutdown();

    }

}
