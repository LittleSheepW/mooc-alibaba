package com.ww.BloodyCaseCausedByNullpointer08;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.function.Function;

/**
 * @author: Sun
 * @create: 2019-11-18 15:19
 * @version: v1.0
 */
public class BloodyCaseCausedByNullPointer08 {

    /**
     * 《手册》的第7页和25页有两段关于空指针的描述
     *【强制】Object 的equals方法容易抛空指针异常，应使用常量或确定有值的对象来调用equals。
     *【推荐】防止NPE，是程序员的基本修养，注意NPE产生的场景:
     * 1.返回类型为基本数据类型，return 包装数据类型的对象时，自动拆箱有可能产生NPE。
     *   反例:public int f () { return Integer对象}，如果为 null,自动解箱抛NPE。
     * 2.数据库的查询结果可能为null。
     * 3.集合里的元素即使isNotEmpty,取出的数据元素也可能为null。
     * 4.远程调用返回对象时，一律要求进行空指针判断，防止NPE。
     * 5.对于Session中获取的数据，建议进行NPE检查，避免空指针。
     * 6.级联调用obj.getA ().getB ().getC (); -连串调用，易产生NPE。
     */

    /**
     * 本节问题：
     * 1、如何学习NullPointerException ( 简称为NPE) ?
     * 答：①通过源码学习NullPointerException
     *    ②通过JLS第11张Exceptions对异常进行学习
     * 2、哪些用法可能造成NPE相关的BUG?
     * 3、在业务开发中作为接口提供者和使用者如何更有效地避免空指针呢?
     */


    public static <T, V> List<V> partitionCallList(List<T> dataList, int size, Function<List<T>, List<V>> function) {

        if (CollectionUtils.isEmpty(dataList)) {
            return new ArrayList<>(0);
        }
        Preconditions.checkArgument(size > 0, "size 必须大于0");

        return Lists.partition(dataList, size)
                .stream()
                .map(function)
                .reduce(new ArrayList<>(),
                        (resultList1, resultList2) -> {
                            resultList1.addAll(resultList2);
                            return resultList1;
                        });
    }

    public void test() {
        Optional<String> byId1 = getById("1");
        System.out.println(byId1.isPresent());

        Optional<String> byId2 = getById("2");
        System.out.println(byId2.isPresent());
    }


    public Optional<String> getById(String id) {
        Map<String, String> stringMap = new HashMap<String, String>(){{
            put("1", "sun");
            put("2", "sunshine");
            put("3", "root");
        }};

        return Optional.ofNullable(stringMap.get(id));
    }

}
