package com.ww.BloodyCaseCausedByNullpointer08.entity;

/**
 * 应用空对象设计模式
 *
 * @author: Sun
 * @create: 2019-11-18 18:52
 * @version: v1.0
 */
public class NullOperation implements Operation {

    @Override
    public void execute(int a, int b) {
        System.out.println("This is NullOperation object.");
    }
}
