package com.ww.DoYouReallyUnderstandVariadicParameters13;

/**
 * @author: Sun
 * @create: 2019-11-26 15:53
 * @version: v1.0
 */
public class DoYouReallyUnderstandVariadicParameters13 {

    /**
     * 《手册》第7页有一段关于Java变长参数的规约:
     * 【强制】相同参数类型，相同业务含义，才可以使用Java的可变参数，避免使用Object。
     * 说明:可变参数必须放置在参数列表的最后。(提倡同学们尽量不用可变参数编程)
     * 正例: public List<User> listUsers(String type, Long... ids) {..}
     */

    /**
     * 本节问题：
     * 1、为什么要有变长参数?
     * 试想一下，如果没有变长参数的语言特性，我们会怎么处理?
     * ①我们可以通过定义多个相同类型的参数进行重载。但是这样做如果参数数量不固定就无法实现。
     * ②我们还可以通过定义数组的参数进行重载。但是这就要求调用时要构造数组，又变成了“定长”，而且需要增加构造数组的代码，代码不够简洁。
     * 为了适应了不确定参数个数的情况，同时避免了手动构造数组，提高语言的简洁性和代码的灵活性。
     * <p>
     * 2、可变参数的常见用法是什么?
     * 3、可变参数有哪些诡异的表现?
     */

    /**
     * 课后作业：
     * 1、结合之前空指针章节所讲的内容，思考示例程序{@link com.ww.DoYouReallyUnderstandVariadicParameters13.BooleanDemo}有啥隐患? 该如何避免呢?
     *
     * 2、结合本节学的内容，请封装一个工具类，包装org.apache.commons.lang3.BooleanUtils#or(java.lang.Boolean..).函数，避免选择函数签名时的冲突问题。
     * 封装好的工具类：{@link com.ww.DoYouReallyUnderstandVariadicParameters13.ContainsBooleanUtils}
     *
     * @param args
     */

    public static void main(String[] args) {
        /**
         * 第一阶段：不自动装箱拆箱，不匹配变长参数直接找到justPrint(boolean b)
         */
        justPrint(true);

        /**
         * 第一阶段：不自动装箱拆箱，不匹配变长参数没有找到对应的and方法所以进入第二阶段
         * 第二阶段：自动装箱拆箱，不匹配可变参数依然没有找到对应的and方法所以进入第三阶段
         * 第三阶段：自动装箱拆箱，允许匹配变长参数。问题就出现在第三个阶段，允许匹配变长参数时就要允许自动拆箱和装箱，这样函数3和函数4都可匹配到，因此无法通过编译。
         */
        /*boolean result = and(true, true, true);
        System.out.println(result);*/

        and(new boolean[]{true, true, true});

        // ------------------------------------------------------ //
        
        System.out.println(ContainsBooleanUtils.containsBooleanUtilOr(true, true, false));
    }

    // 函数1
    private static void justPrint(boolean b) {
        System.out.println(b);
    }

    // 函数2
    private static void justPrint(Boolean b) {
        System.out.println(b);
    }

    /**
     * 函数3  编译后代码：
     * private static boolean and(boolean... booleans) {
     *     System.out.println("boolean");
     *     boolean[] var1 = booleans;
     *     int var2 = booleans.length;
     *
     *     for(int var3 = 0; var3 < var2; ++var3) {
     *         boolean b = var1[var3];
     *         if (!b) {
     *             return false;
     *         }
     *     }
     *
     *     return true;
     * }
     *
     * @param booleans
     * @return
     */
    private static boolean and(boolean... booleans) {
        System.out.println("boolean");
        for (boolean b : booleans) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    // 函数4
    private static boolean and(Boolean... booleans) {
        System.out.println("Boolean");
        for (Boolean b : booleans) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
