package com.ww.EnumerationClassCorrectLearningPosture10;

import com.ww.EnumerationClassCorrectLearningPosture10.constant.ActivityStatesEnum;
import com.ww.EnumerationClassCorrectLearningPosture10.constant.CoinEnum;
import com.ww.EnumerationClassCorrectLearningPosture10.constant.OperationEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author: Sun
 * @create: 2019-11-20 10:28
 * @version: v1.0
 */
@Slf4j
public class EnumerationClassCorrectLearningPosture10Test {

    /**
     * 使用Enum类编译后的隐藏方法
     */
    @Test
    public void enumHideMethod() {
        // values()
        CoinEnum[] values = CoinEnum.values();
        System.out.println(Arrays.asList(values));
        // valueOf()
        System.out.println(CoinEnum.valueOf("PENNY"));
    }

    /**
     * 序列化Enum类
     */
    @Test
    public void enumSerialize() throws IOException {
        CoinEnum[] values = CoinEnum.values();
        // 序列化
        byte[] serialize = SerializationUtils.serialize(values);
        log.info("序列化后的字符：{}", new String(serialize));

        // 反序列化
        CoinEnum[] values2 = SerializationUtils.deserialize(serialize);
        Assert.assertTrue(Objects.deepEquals(values, values2));
    }

    /**
     * 序列化时枚举类中的某个属性
     * 反序列化之前删除序列化时枚举类中指定的属性
     * 由此模拟二方的枚举类添加新的常量后，如果使用方没有及时更新JAR包，使用Java反序列化时可能会抛出IllegalArgumentException。
     *
     * @throws IOException
     */
    @Test
    public void testSerializeEnumException() throws IOException {
        SerializationUtils.serialize(CoinEnum.PENNY, new ObjectOutputStream(new FileOutputStream("/Users/sun/Desktop/Enum")));
    }

    @Test
    public void testDeserializeEnumException() throws IOException {
        // 反序列化
        CoinEnum penny = SerializationUtils.deserialize(new ObjectInputStream(new FileInputStream("/Users/sun/Desktop/Enum")));
        System.out.println(penny);
    }


    /**
     * 测试Enum常量中的方法
     */
    @Test
    public void enumMethod() {
        double x = 5;
        double y = 3;
        for (OperationEnum op : OperationEnum.values()) {
            System.out.println(x + " " + op + " " + y +
                    " = " + op.eval(x, y));
        }

    }

    /**
     * 使用状态机枚举类
     */
    @Test
    public void useActivityStates() {
        ActivityStatesEnum deaclare = ActivityStatesEnum.DEACLARE;
        System.out.println(deaclare.ordinal());

        System.out.println(deaclare.nextState().ordinal());
    }

}
