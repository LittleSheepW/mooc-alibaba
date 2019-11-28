package com.ww.LearningTheCorrectPostureOfTheThreadPool15;

import org.junit.Test;

/**
 * @author: Sun
 * @create: 2019-11-28 11:10
 * @version: v1.0
 */
public class LearningTheCorrectPostureOfTheThreadPool15Test {

    /**
     * 使用正确方式构建线程池
     */
    @Test
    public void useTheRightWayBuildThreadPool() {

    }

    @Test
    public void removeSymbol() {
        String string = "* 1. If fewer than corePoolSize threads are running, try to\n" +
                "         * start a new thread with the given command as its first\n" +
                "         * task.  The call to addWorker atomically checks runState and\n" +
                "         * workerCount, and so prevents false alarms that would add\n" +
                "         * threads when it shouldn't, by returning false.\n" +
                "         *\n" +
                "         * 2. If a task can be successfully queued, then we still need\n" +
                "         * to double-check whether we should have added a thread\n" +
                "         * (because existing ones died since last checking) or that\n" +
                "         * the pool shut down since entry into this method. So we\n" +
                "         * recheck state and if necessary roll back the enqueuing if\n" +
                "         * stopped, or start a new thread if there are none.\n" +
                "         *\n" +
                "         * 3. If we cannot queue task, then we try to add a new\n" +
                "         * thread.  If it fails, we know we are shut down or saturated\n" +
                "         * and so reject the task.";

        string = string.replace("*", "");

        System.out.println(string);
    }
}
