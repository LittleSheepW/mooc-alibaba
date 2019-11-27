package com.ww.SetTheCorrectPostureForDeduplication14;

import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author: Sun
 * @create: 2019-11-27 21:35
 * @version: v1.0
 */
public class SetTheCorrectPostureForDeduplication14Test {

    @Test
    public void useRemoveDuplicateBySet() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
        Set<Integer> integerSet = removeDuplicateBySet(integerList);
        System.out.println(integerSet);
    }

    @Test
    public void useRemoveDuplicateByList() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
        integerList = removeDuplicateByList(integerList);
        System.out.println(integerList);
    }

    /**
     * 使用HashSet去重
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Set<T> removeDuplicateBySet(List<T> data) {
        if (CollectionUtils.isEmpty(data)) {
            return new HashSet<>();
        }
        return new HashSet<>(data);
    }

    /**
     * 使用List.contains()去重
     */
    public static <T> List<T> removeDuplicateByList(List<T> data) {
        if (CollectionUtils.isEmpty(data)) {
            return new ArrayList<>();
        }
        List<T> result = new ArrayList<>(data.size());
        for (T current : data) {
            if (!result.contains(current)) {
                result.add(current);
            }
        }
        return result;
    }
}
