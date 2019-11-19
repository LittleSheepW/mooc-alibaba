package com.ww.SwitchMeetNullpointer09;

/**
 * @author: Sun
 * @create: 2019-11-19 15:22
 * @version: v1.0
 */
public class SwitchMeetNullpointer09 {

    /**
     * 《手册》的第18页有关于switch的规约:
     * 【强制】当switch括号内的变量类型为String并且此变量为外部参数时，必须先进行null判断。
     */

    /**
     * 本节问题：
     * 1、switch除了String 还支持哪种类型?
     * 答：switch的表达式必须是char, byte, short, int, Character, Byte, Short, Integer, String或者enum类型，否则会发生编译错误
     *
     * 2、为什么《手册》规定字符串类型参数要先进行null判断?
     * 因为Java虚拟机的tableswitch 和lookupswitch 指令只能支持int 类型的条件值。如果switch中使用其他类型的值，那么就必须转化为int 类型。如果不对字符串类型进行null判断，
     * 就会抛出NullPointerException。
     *
     * @param args
     */

    /**
     * 此代码通过反编译之后进行分析
     * switch语句执行的时候，首先将执行switch的表达式。如果表达式为null, 则会抛出NullPointerException，整个switch语句的执行将被中断。
     * <p>
     * switch语句执行流程：
     * 1、计算字符串参数的哈希值
     * 2、判断该参数哈希值是否在case条件中哈希值的范围
     * 3、判断哈希值相等
     * 4、判断对象是否相等，然后执行对应的代码块
     *
     * @param args
     */
    public static void main(String[] args) {
        String param = "t";
        switch (param) {
            case "a":
                System.out.println("b");
                break;
            case "b":
                System.out.println("a");
                break;
            case "c":
                System.out.println("c");
                break;
            default:
                System.out.println("default");
        }
    }


}

