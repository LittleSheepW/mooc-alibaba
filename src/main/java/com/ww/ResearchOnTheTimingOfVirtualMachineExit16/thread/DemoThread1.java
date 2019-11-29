package com.ww.ResearchOnTheTimingOfVirtualMachineExit16.thread;

import java.util.concurrent.TimeUnit;

public class DemoThread1 extends Thread {


    public DemoThread1() {
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
    }

    public static void main(String[] args) {
        DemoThread1 demoThread = new DemoThread1();
        demoThread.run();
    }

}