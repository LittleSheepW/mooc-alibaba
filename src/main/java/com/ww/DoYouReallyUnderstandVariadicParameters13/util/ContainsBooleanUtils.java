package com.ww.DoYouReallyUnderstandVariadicParameters13.util;

import org.apache.commons.lang3.BooleanUtils;

/**
 * @author: Sun
 * @create: 2019-11-26 17:06
 * @version: v1.0
 */
public class ContainsBooleanUtils {

    /**
     * 包装BooleanUtil#or(boolean... array)
     *
     * @param array
     * @return
     */
    public static boolean containsBooleanUtilOr(boolean... array) {
        return BooleanUtils.or(array);
    }
}
