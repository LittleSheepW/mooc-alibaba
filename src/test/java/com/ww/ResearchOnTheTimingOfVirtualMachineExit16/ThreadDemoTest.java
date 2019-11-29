package com.ww.ResearchOnTheTimingOfVirtualMachineExit16;

import com.ww.ResearchOnTheTimingOfVirtualMachineExit16.thread.DemoThread1;
import com.ww.ResearchOnTheTimingOfVirtualMachineExit16.thread.DemoThread2;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class ThreadDemoTest {

    /*
     * 预期结果为：每个线程分别执行4次打印语句。
     * 但是实际运行结果为: Thread-0-->0       Thread-1-->0
     * 通过观察现象，我们看出Junit单元测试“不支持多线程”测试，换句话说两个线程可能还没执行完，程序就退出了。
     *
     * 原因：IDEA运行JUnit4时
     * 1.先执行com.intellij.rt.execution.junit.JUnitStarter#main，此函数中调用prepareStreamsAndStart子函数;
     * 2.子函数最终调用到ThreadDemoTest#test 的代码。
     * 3. ThreadDemoTest#test创建两个新线程并依次开启后结束，函数返回退出码，最终调用System.exit(exitCode);退出JVM。
     *
     * 那么如何避免两个子线程尚未执行完单元测试函数，就被主线程调用System.exit导致JVM退出呢?
     * 方案1:可以将代码写在main函数中;还记得开头说的吗，只要有一个非守护线程还在运行，虛拟机就不会退出(正常情况下)。
     * 方案2:可以使用CountDownLatch;
     * 方案3:使用join()函数
     */
    @Test
    public void test1() {
        DemoThread1 demoThread1 = new DemoThread1();
        DemoThread1 demoThread2 = new DemoThread1();

        demoThread1.start();
        demoThread2.start();
    }

    /**
     * 使用CountDownLatch避免子线程尚未执行完成，主线程就调用System.exit导致JVM退出。
     * CountDownLatch.await() 使当前线程等待，直到锁存器递减至零为止，除非该线程被中断。如果当前计数为零，则此方法立即返回。
     * 如果当前计数大于零，则出于线程调度目的，当前线程将被禁用并处于休眠状态，直到发生以下两种情况之一为止：
     * (1)由于countDown方法的调用，计数达到零；
     * (2)或其他一些线程中断当前线程。
     *
     * @throws InterruptedException
     */
    @Test
    public void test2() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        DemoThread2 demoThread1 = new DemoThread2(countDownLatch);
        DemoThread2 demoThread2 = new DemoThread2(countDownLatch);

        System.out.println(Thread.currentThread().getName());

        demoThread1.start();
        demoThread2.start();

        countDownLatch.await();
    }

    /**
     * 使用join()函数避免子线程尚未执行完成，主线程就调用System.exit导致JVM退出。
     * json()函数会等待当前线程执行结束后再继续执行。
     *
     * @throws InterruptedException
     */
    @Test
    public void test3() throws InterruptedException {
        DemoThread1 demoThread1 = new DemoThread1();
        DemoThread1 demoThread2 = new DemoThread1();

        demoThread1.start();
        demoThread2.start();

        demoThread1.join();
        demoThread2.join();
    }

}