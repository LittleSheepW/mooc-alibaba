package com.ww.ArrayListSubListAndArraysAsList11;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Sun
 * @create: 2019-11-21 22:12
 * @version: v1.0
 */
public class ArrayListSubListAndArraysAsList11 {

    /**
     * 《手册》第11-12页对ArrayList的subList 和Arrays.asList() 进行了如下描述
     * 【强制】ArrayList 的subList结果不可强转成ArrayList，否则会抛出ClassCastException异常，
     * 即java.util.RandomAccessSubList cannot be cast to java.util.ArrayList。
     *
     * 【强制】在SubList场景中，高度注意对原集合元素的增加或删除，均会导致子列表的遍历、增加、删除产生
     * ConcurrentModificationException异常。
     *
     * 【强制】使用工具类Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方
     * 法，它的add/remove/clear方法会抛出UnsupportedOperationException异常。
     */

    /**
     * 本节问题：
     * 1、为什么ArrayList.SubList不可强转为ArrayList？
     * 答：SubList和ArrayList并没有继承关系，因此ArrayList的SubList 并不能强转为ArrayList。
     * 2、为何在SubList场景中，对原集合的增加或删除，均会导致子列表的遍历、增加、删除产生ConcurrentModificationException异常？
     * 答：因为在获取SubList对象时有一个modCount属性是复制了当前ArrayList对象中的modCount属性，对ArrayList对象增加或删除均会修改
     * modCount的值，而在使用SubList对象size()，get()方法时均会检查SubList对象中的modCount值和ArrayList中的modCount值是否一致，
     * 不一致则会抛出ConcurrentModificationException异常。
     * 3、为什么使用工具类Arrays.asList()把数组转换成集合后，为什么调用add/remove/clear方法会抛出UnsupportedOperationException异常？
     * 因为Arrays.arrayList继承于AbstractList，但是并没有重写AbstractList中的add/remove/removeRange方法。故会抛出该异常。
     *
     * @param args
     */

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(integers.getClass().getName());

    }
}
