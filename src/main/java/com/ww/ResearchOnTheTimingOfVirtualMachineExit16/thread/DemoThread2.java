package com.ww.ResearchOnTheTimingOfVirtualMachineExit16.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: Sun
 * @create: 2019-11-29 10:31
 * @version: v1.0
 */
public class DemoThread2 extends Thread {

    private CountDownLatch countDownLatch;

    public DemoThread2(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ignore) {
            }
        }
        // 如果注释掉下一行代码，单元测试永远不会停止
        countDownLatch.countDown();
    }

}