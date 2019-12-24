package com.ww.Meal.Second;

import java.util.Collection;
import java.util.HashSet;

/**
 * 为了调优该程序的性能，需要查询HashSet，看看自从被创建以来添加了多少个元素。为了提供这种功能，我们得用一个addCount 变量记录
 * 插入的元素数量，并提供一个获取该变量数值的方法。HashSet类包含两个可以增加元素的方法: add 和addAll ，因此两个方法都要覆盖。
 *
 * @param <E>
 */
public class InstrumentedHashSet<E> extends HashSet<E> {

    private int addCount = 0;

    public InstrumentedHashSet() {
    }

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}