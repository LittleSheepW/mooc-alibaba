package com.ww.DoYouReallyUnderstandVariadicParameters13;

/**
 * and()方法中的隐患为：
 * 调用add()方法时可能会传入null值，and()方法中如果不做判空会导致空指针异常。
 *
 * @author: Sun
 * @create: 2019-11-26 16:52
 * @version: v1.0
 */
public class BooleanDemo {

    public static void main(String[] args) {
        and(new boolean[]{true, true, true});
        and(null);
    }

    private static boolean and(boolean... booleans) {
        if (booleans == null) {
            throw new RuntimeException("传入的值为null");
        }
        for (boolean b : booleans) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

}
