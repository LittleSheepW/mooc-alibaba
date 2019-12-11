package com.ww.CorrectPostureForCodeDebugging24.thread;

/**
 * @author: Sun
 * @create: 2019-12-11 11:51
 * @version: v1.0
 */
public class DebugThreadMode extends Thread {

    /**
     * 15行加入断点，断点上右键选择断点的模式为Thread模式，开启多线程调试
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
