package com.ww.SetTheCorrectPostureForDeduplication14;

import com.ww.SetTheCorrectPostureForDeduplication14.util.CollectionUtil;
import com.ww.UnitTestConstructsTheCorrectPostureOfTheData21.entity.simple.Person;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.randomizers.collection.ListRandomizer;
import org.jeasy.random.randomizers.text.StringRandomizer;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 查看List#contains() 和 使用Set去重的效率
 */
@Slf4j
public class SetDemo {

    public static void main(String[] args) {

        List<Integer> lengthList = new LinkedList<>();
        int base = 1;
        for (int i = 1; i <= 6; i++) {
            base *= 10;
            lengthList.add(base);
        }

        // TODO: 2019-12-06 seed参数的意义
        StringRandomizer stringRandomizer = new StringRandomizer(10, 100, 1000);

        for (Integer length : lengthList) {
            log.debug("------------长度为 {} 时-------", length);
            ListRandomizer<String> listRandomizer = new ListRandomizer<>(stringRandomizer, length);
            List<String> data = listRandomizer.getRandomValue();

            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            Set<String> resultBySet = CollectionUtil.removeDuplicateBySet(data);
            log.debug("set去重耗时：{} ms   length:{}", stopWatch.getTime(), resultBySet.size());

            stopWatch = new StopWatch();
            stopWatch.start();
            List<String> resultByList = CollectionUtil.removeDuplicateByList(data);
            log.debug("list去重耗时：{} ms   length:{}", stopWatch.getTime(), resultByList.size());
        }
    }
}
