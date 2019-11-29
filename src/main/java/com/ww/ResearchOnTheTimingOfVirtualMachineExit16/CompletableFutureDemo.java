package com.ww.ResearchOnTheTimingOfVirtualMachineExit16;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo {

    /**
     * 运行此段代码，大概率会发现:打印语句并没有被执行程序就退出了。
     * 不是说多线程问题可以通过将代码写在main函数中来避免的吗?
     * <p>
     * 为什么会出现这种情况？我们通过观察代码调用链：
     * java.util.concurrent.CompletableFuture#runAsync(java.lang.Runnable)
     * java.util.concurrent.CompletableFuture#asyncRunStage
     * java.util.concurrent.ForkJoinPool#execute(java.lang.Runnable)
     * java.util.concurrent.ForkJoinPool#externalPush
     * ...
     * 最终调用到:
     * java.util.concurrent.ForkJoinPool#registerWorker
     * <p>
     * 进入 java.util.concurrent.ForkJoinPool#registerWorker()方法中可以看到
     * wt.setDaemon(true);
     * 从这里可知ForkJoinPool的工作线程类型为守护者线程。我们知道如果只有守护线程，程序将退出。
     * <p>
     * 下面代码中：
     * 主线程为普通用户线程，执行到第1处，使用默认的ForkJoinPool来异步执行传入的任务。
     * 此时工作线程(守护线程)如果得到运行机会，调用TimeUnit.SECONDS.sleep(2L);导致该线程sleep 2秒钟。
     * 主线程执行到第2处(无代码) ，然后主线程执行完毕。此时已经没有非守护线程，还不等工作线程从Time waiting睡眠状态结束，
     * 虚拟机发现已经没有非守护线程，便退出了。
     *
     * @param args
     */
    public static void main(String[] args) {
        // 第1处
        CompletableFuture.runAsync(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "开始休眠");
                TimeUnit.SECONDS.sleep(2L);
                System.out.println(Thread.currentThread().getName() + "休眠结束");
            } catch (InterruptedException ignore) {
                ignore.printStackTrace();
            }
            System.out.println("异步任务");
        });
        // 第2处

        /*((Runnable) () -> {
            try {
                System.out.println(Thread.currentThread().getName() + "开始休眠");
                TimeUnit.SECONDS.sleep(1L);     // 休眠1秒照样不打印异步任务字符串、休眠2秒会打印
                System.out.println(Thread.currentThread().getName() + "休眠结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).run();*/
    }
}