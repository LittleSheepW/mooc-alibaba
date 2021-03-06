package com.ww.IntegerCacheProblemAnalysis02;

import org.junit.Test;

/**
 * @author: Sun
 * @create: 2019-11-05 16:43
 * @version: v1.0
 */
public class IntegerCacheProblemAnalysis02Test {

    /**
     * 《手册》第7页有一段关于包装对象之间值的比较问题的规约1:
     * 【强制】所有整型包装类对象之间值的比较，全部使用equals方法比较。
     * 说明:对于Integer var = ? 在-128至127范围内的赋值，Integer对象是在IntegerCache.cache产生，
     * 会复用已有对象，这个区间内的Integer值可以直接使用==进行判断，但是这个区间之外的所有数据，
     * 都会在堆上产生，并不会复用已有对象，这是一个大坑，推荐使用equals方法进行判断。
     */

    // 缓存常用的包装对象可以节省内存(空间)并提供更快的速度

    @Test
    public void byteCacheRange() {
        // 默认缓存-128-127之间，注释中没有指出可以修改缓存范围
        Byte a = 127, b = 127;
        System.out.println(a == b);
    }

    @Test
    public void shortCacheRange() {
        // 默认缓存-128-127之间，注释中没有指出可以修改缓存范围
        Short a = 126, b = 126, c = 128, d = 128;
        System.out.println(a == b);
        System.out.println(c == d);
    }

    @Test
    public void integerCacheRange() {
        /**
         * 默认缓存-128-127之间 JLS中明确指出的缓存范围，
         * 可以修改最大值的缓存范围，两种方式：
         * 1、增加虚拟机参数 -XX:AutoBoxCacheMax=<size>
         * 2、-Djava.lang.Integer.IntegerCache.high
         */
        Integer a = 100, b = 100, c = 150, d = 150;
        System.out.println(a == b);
        System.out.println(c == d);
    }

    @Test
    public void longCacheRange() {
        // 默认缓存-128-127之间，注释中没有指出可以修改缓存范围
        Long a = -128L, b = -128L, c = 150L, d = 150L;
        System.out.println(a == b);
        System.out.println(c == d);
    }

    @Test
    public void floatCacheRange() {
        // 没有缓存范围
        Float a = 1f, b = 1f, c = 128f, d = 128f;
        System.out.println(a == b);
        System.out.println(c == d);
    }

    @Test
    public void doubleCacheRange() {
        // 没有缓存范围
        Double a = 127.0, b = 127.0, c = 128.0, d = 128.0;
        System.out.println(a == b);
        System.out.println(c == d);
    }

    @Test
    public void characterCacheRange() {
        // 默认缓存0-127之间，注释中没有指出可以修改缓存范围
        Character a = 126, b = 126, c = 128, d = 128;
        System.out.println(a == b);
        System.out.println(c == d);
    }

    @Test
    public void booleanCacheRange() {
        // 默认缓存TRUE、FALSE两个布尔对象
        Boolean a = true, b = false;
        System.out.println(a == b);
    }
}
