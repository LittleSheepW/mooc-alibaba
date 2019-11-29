package com.ww.ResearchOnTheTimingOfVirtualMachineExit16;

/**
 * @author: Sun
 * @create: 2019-11-29 10:00
 * @version: v1.0
 */
public class ResearchOnTheTimingOfVirtualMachineExit16 {

    /**
     * 本节重点学习JVM关闭时机相关问题：
     * 1、JVM在何时正常退出呢(不包含通过kill 指令杀死进程等情况) ?
     * (1)Java虚批机退出的条件是，某个线程凋用了Runtime类或System类的exit方法，或Runtime类的halt 方法，
     * 并且Java安全管理器也允许这次exit或halt操作。除此之外，JNI (Java Native Interface)規范描述了用JNI Invocation API
     * 来加載或卸載Java虚似机吋，Java 虚拟机的退出情况。
     * (2)可以通过一些其他平台相关的手段(比如发送SIGINT,或键入Ctrl-C)，都可以实现JVM的正常关闭。
     * (3)程序中只剩下守护进程时JVM会正常退出。
     */
}
