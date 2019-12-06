package com.ww.SetTheCorrectPostureForDeduplication14.util;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Sun
 * @create: 2019-12-06 14:18
 * @version: v1.0
 */
public class CollectionUtil {

    /**
     * 使用{@link java.util.List#contains(Object)} 去除集合中重复数据
     *
     * @param data
     * @param <T>
     * @return
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

    /**
     * 使用Set去除集合中重复数据
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
}
