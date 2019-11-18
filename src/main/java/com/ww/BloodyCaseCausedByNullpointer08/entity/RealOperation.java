package com.ww.BloodyCaseCausedByNullpointer08.entity;

/**
 * 真实对象
 *
 * @author: Sun
 * @create: 2019-11-18 18:48
 * @version: v1.0
 */
public class RealOperation implements Operation {

    @Override
    public void execute(int a, int b) {
        System.out.println(a + b);
    }
}
