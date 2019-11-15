package com.ww.IntegerCacheProblemAnalysis02;

/**
 * @author: Sun
 * @create: 2019-11-05 16:43
 * @version: v1.0
 */
public class IntegerCacheProblemAnalysis02 {

    /**
     * 《手册》第7页有一段关于包装对象之间值的比较问题的规约1:
     * 【强制】所有整型包装类对象之间值的比较，全部使用equals方法比较。
     * 说明:对于Integer var = ? 在-128至127范围内的赋值，Integer对象是在IntegerCache.cache产生，
     * 会复用已有对象，这个区间内的Integer值可以直接使用==进行判断，但是这个区间之外的所有数据，
     * 都会在堆上产生，并不会复用已有对象，这是一个大坑，推荐使用equals方法进行判断。
     */

    /**
     * 本节问题：
     * 1、Integer.cache为什么会缓存-128-127之间的值呢?
     * 答案：是为了自动装箱时可以复用这些对象，这也是JLS的要求。如果不要求必须新建一个整型对象，
     * 缓存最常用的值(提前构造缓存范围内的整型对象)，会更省空间，速度也更快。
     *
     * 2、Integer缓存区间可以修改吗?
     * 答案：可以修改最大值的缓存范围，两种方式：
     * ①、增加虚拟机参数 -XX:AutoBoxCacheMax=<size>
     * ②、-Djava.lang.Integer.IntegerCache.high
     *
     * 3、其它的包装类型有没有类似缓存?
     * Byte、Short、Long、Character、Boolean也是有类似缓存的但是并不支持修改缓存的范围，Float、Double是没有的。
     */

    /**
     * 学习过程中所遇疑问：
     * 1、static final修饰的静态变量可以修改吗？
     * 如果在类中像static final int HIGH;这样的形式声明该变量而不为该变量赋值是会看到语法错误的
     * 必须显式赋值static final int HIGH = 1；或使用静态代码块来为其赋值。
     * 除此之外在别的地方是无法再次修改该变量的。
     */

}
