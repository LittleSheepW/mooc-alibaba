package com.ww.DoYouReallyUnderstandVariadicParameters13;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author: Sun
 * @create: 2019-11-26 16:02
 * @version: v1.0
 */
public class DoYouReallyUnderstandVariadicParameters13Test {

    @Test
    public void format() {
        String pattern = "我喜欢在 %s 上学习 %s";
        String arg0 = "https://www.imooc.com/";
        String arg1 = "编程";
        String format = String.format(pattern, arg0, arg1, "sun");

        String expected = "我喜欢在 " + arg0 + " 上学习 " + arg1;
        Assert.assertEquals(expected, format);
    }

}
