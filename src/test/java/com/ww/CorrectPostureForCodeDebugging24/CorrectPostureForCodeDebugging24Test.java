package com.ww.CorrectPostureForCodeDebugging24;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.ww.CorrectPostureForCodeDebugging24.thread.DebugThreadMode;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: Sun
 * @create: 2019-12-11 11:44
 * @version: v1.0
 */
public class CorrectPostureForCodeDebugging24Test {

    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
    private static ExecutorService threadPoolExecutor = new ThreadPoolExecutor(5, 5,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    /**
     * 1.使用Debug 多线程模式，支持多线程调试以控制不同线程的运行。
     */
    @Test
    public void useDebugThreadMode() {
        threadPoolExecutor.execute(new DebugThreadMode());
        threadPoolExecutor.execute(new DebugThreadMode());
    }

    /**
     * 2.使用Debug中的条件断点，只有满足设置的条件时断点才会生效。
     */
    @Test
    public void useDebugConditionalBreakpoint() {
        for (int j = 0; j < 100; j++) {
            if (j == 99) {
                System.out.println("条件生效");
            }
        }
    }

    /**
     * 3.移除帧，相当于回退到上一级，当我们调试某个问题时，一不小心走过了，往往会重新运行调试，非常浪费时间，此时可以通过该功能实现“回退”。
     */
    @Test
    public void useDebugDropFrame() {
        System.out.println("1");
        System.out.println("2");
        printNumber();
        System.out.println("3");
        System.out.println("4");
    }

    private void printNumber() {
        System.out.println("666");
        System.out.println("888");
    }

    /**
     * 4.在Debug过程中动态修改某个值
     */
    @Test
    public void dubuggingSetValue() {
        dubuggingSetValueMethod(10);
    }

    private void dubuggingSetValueMethod(Integer integer) {
        System.out.println(integer);
    }

    /**
     * 5.对变量执行表达式
     */
    @Test
    public void useEvaluate() {
        // string.toCharArray();
        String string = "string";

        List<String> stringList = new ArrayList<>();
        stringList.add("A");

        // stringList.add("B")
        for (String s : stringList) {
            System.out.println(s);
        }
    }

    /**
     * 6.wacth 观察指定条件所产生的结果，不用再每次通过表达式手动进行计算
     */
    @Test
    public void useWatch() {
        // string.toCharArray()
        String string = "string";
    }

    /**
     * 7.看内存对象 我们可以在Memory选项栏下，搜索对象对应的类就可以看到该类对象的数量，双击就可以通过表达式来过滤，非常强大。
     */
    @Test
    public void lookMemoryObject() {
        Integer c = 150;
        System.out.println(c == 150);
    }

    /**
     * 8.异常断点使用场景：在一个循环中有一个数据报错，想在报错的时候断点，因为你不知道报错数据的条件是什么，所以无法使用条件断点，而且循环次数很多，一次一次断掉放过非常麻烦。
     */
    @Test
    public void useExceptionBreakpoint() {
        List<String> stringList = new ArrayList<String>() {{
            add("aaa-bbb");
            add("bbb-ccc");
            add("ccc ddd");
            add("ddd-eee");
        }};


        for (String string : stringList) {
            // 想要查看当程序抛出StringIndexOutOfBoundsException异常时 string变量的情况
            String substring = string.substring(0, string.indexOf("-"));
            System.out.println(substring);
        }
    }

}
