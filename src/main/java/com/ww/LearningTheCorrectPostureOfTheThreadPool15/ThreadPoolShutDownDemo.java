package com.ww.LearningTheCorrectPostureOfTheThreadPool15;

import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.util.NamedThreadFactory;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadPoolShutDownDemo {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(50000), new NamedThreadFactory("shutdown-demo"));

        int total = 20000;
        for (int i = 0; i < total; i++) {
            executorService.submit(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(5L);
                } catch (InterruptedException ignore) {
                }
                // System.out.println(Thread.currentThread().getName());
            });
        }

        // 第 1 处代码
        printExecutorInfo(total, executorService);

        // 第 2 处代码：shutdown()不会等待直接提交的任务执行完成（但是会让它们执行完毕）就会返回。你可以将该方法理解为 “开始关闭” 函数。
        // 启动有序关闭，在该关闭中执行先前提交的任务，但不接受任何新任务。如果已关闭，则调用不会产生任何其他影响。此方法不等待先前提交的任务完成执行。使用awaitTermination可以做到这一点。
        executorService.shutdown();

        // 尝试停止所有正在执行的任务，暂停正在等待的任务的处理，并返回正在等待执行的任务的列表。从此方法返回后，这些任务将从任务队列中耗尽（删除）。此方法不等待主动执行的任务终止。使用awaitTermination可以做到这一点。除了尽最大努力尝试停止处理正在执行的任务之外，没有任何保证。此实现通过Thread.interrupt取消任务，因此任何无法响应中断的任务都可能永远不会终止。
        // executorService.shutdownNow();

        // 第 3 处代码：shutdown()之后再提交任务会抛出RejectedExecutionException异常
        // executorService.submit(() -> {});

        // 线程池没结束，隔一秒打印任务情况
        while (!executorService.isTerminated()) {
            TimeUnit.SECONDS.sleep(1);
            printExecutorInfo(total, executorService);
        }
    }

    /**
     * 打印线程池信息
     */
    private static void printExecutorInfo(int total, ThreadPoolExecutor executorService) {
        LocalDateTime dateString = LocalDateTime.now(ZoneId.systemDefault());
        log.debug("时间:{},总任务数：{}, 工作队列中有:{}个任务，已完成:{}个任务，正在执行:{}个任务", dateString, total, executorService.getQueue().size(), executorService.getCompletedTaskCount(), executorService.getActiveCount());
    }


}