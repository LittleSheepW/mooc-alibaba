package com.ww.Deprecated07;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: Sun
 * @create: 2019-11-18 13:46
 * @version: v1.0
 */
@Slf4j
public class Deprecated07 {

    /**
     * 【强制】不能使用过时的类或方法
     * 接口过时必须加@Deprecated注解，并清晰地说明采用的新接口或者新服务是什么。接口提供方既然明确是过时接口，
     * 那么有义务同时提供新的接口;作为调用方来说，有义务去考证过时方法的新实现是什么。
     */

    /**
     * 本节问题：
     * 问题一：如何更好的去遵守过期类、属性、接口的正确处理姿势?
     * 答：找一些优秀源码相关的示例进行学习。
     */

    /**
     * 1、在过期类、属性、接口中一定要加入@Deprecated注解，并说明过期的原因以及添加替换的类、属性、接口的跳转
     * 2、无论是修改替换过期的类、属性、接口还是调用过期类、属性、接口对应的新的类、属性、接口时都要进行单元测试，保证正确性
     * 3、在写工具类时最好在注释的基础上再添加一些范例和结果，方便使用者
     * 4、使用第三方库中的函数时，如果不知道其作用可以看注释或者从GitHub上拉取代码去对应的测试类中查看用法
     */
}
