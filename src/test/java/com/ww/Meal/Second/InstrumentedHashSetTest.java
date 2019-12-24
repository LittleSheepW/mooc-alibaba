package com.ww.Meal.Second;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class InstrumentedHashSetTest {

    /**
     * 我们运行该程序，发现断言失败，显示期待的值是3，而实际值却是6，为什么结果会是6？
     * 因为调用InstrumentedHashSet.addAll()方法后，
     * addAll()方法增加了变量值后又调用了super.addAll(c); 该方法中循环接收到的集合，又调用了add()方法，此时调用的add()方法是
     * 我们自己写的InstrumentedHashSetTest类中的add()，我们自己覆盖的add()方法中第一行addCount++;所以最终并不是3，而是6
     */
    @Test
    public void testAddCount() {
        List<String> stringList = Arrays.asList("Snap", "Crackle", "Pop");
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(stringList);
        Assert.assertEquals(stringList.size(), s.getAddCount());
    }
}