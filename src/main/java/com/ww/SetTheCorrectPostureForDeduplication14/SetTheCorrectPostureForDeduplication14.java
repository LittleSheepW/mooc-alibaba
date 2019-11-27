package com.ww.SetTheCorrectPostureForDeduplication14;

/**
 * @author: Sun
 * @create: 2019-11-27 21:32
 * @version: v1.0
 */
public class SetTheCorrectPostureForDeduplication14 {

    /**
     *《手册》的第11页关于集合处理的章节有这样的描述:
     *【参考】利用Set元素唯一的特性，可以快速对一个集合进行去重操作，避免使用List的contains方法进行遍历、对比、去重操作。
     *【强制】关于hashCode和equals的处理，遵循如下规则:
     * 1.只要覆写equals, 就必须覆写hashCode;
     * 2.因为Set存储的是不重复的对象，依据hashCode和equals进行判断，所以Set存储的对象必须覆写这两个方法;
     * 3.如果自定义对象作为Map的键，那么必须覆写hashCode和equals。说明: String 已覆写hashCode和equals方法，
     * 所以我们可以愉快地使用String对象作为key来使用。
     */

    /**
     * 本节问题：
     * 1、Set是怎样保证数据的唯一性呢?
     * 答：依据HashMap key值唯一保证了数据的唯一性(HashSet中的所有数据存储在HashMap的keySet中)。
     *
     * 2、Set存储的是不重复的对象，是不是根据hashCode和equals来判断是否重复的呢?
     * 答：是
     *
     * 3、Set和List的去重性能差距是多大呢?
     * 长度为10万时使用List去重耗时接近1分钟，而使用Set去重则只需要17毫秒;
     * 而集合长度为100万时，使用List去重，耗时则约为1.7小时，使用Set 去重则只需要1.33秒。
     */
}
