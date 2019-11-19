package com.ww.SwitchMeetNullpointer09;

import org.junit.Test;

/**
 * @author: Sun
 * @create: 2019-11-19 16:39
 * @version: v1.0
 */
public class SwitchMeetNullpointer09Test {

    /**
     * 调用此方法会抛出NullPointerException
     * 原因：在执行switch流程时，第一步就是将switch中的参数转为int类型，在此方法中参数为String类型，要将String类型转为
     * int类型所以调用该参数的hashcode()方法，因为该参数是null，所以调用null对象的实例方法会抛出NullPointerException。
     *
     * 为什么要将switch中的参数转为int类型？
     * Java虚拟机的tableswitch 和lookupswitch 指令只能支持int 类型的条件值。如果switch中使用其他类型的值，那么就必须转化为int 类型。
     *
     *
     */
    @Test
    public void throwNullPointerException() {
        String param = null;
        switch (param) {
            case "null":
                System.out.println("null");
                break;
            default:
                System.out.println("default");
        }
    }

    /**
     * 调用此方法控制台中会输出null
     */
    @Test
    public void switchTestHomework() {
        String param = null;
        switch (param = "null") {
            case "null":
                System.out.println("null");
                break;
            default:
                System.out.println("default");
        }
    }
}
