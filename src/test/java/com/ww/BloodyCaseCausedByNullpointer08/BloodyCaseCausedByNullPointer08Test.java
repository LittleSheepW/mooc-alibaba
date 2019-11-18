package com.ww.BloodyCaseCausedByNullpointer08;

import com.google.common.base.Preconditions;
import com.ww.BloodyCaseCausedByNullpointer08.entity.NullOperation;
import com.ww.BloodyCaseCausedByNullpointer08.entity.Operation;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.*;

/**
 * @author: Sun
 * @create: 2019-11-18 15:19
 * @version: v1.0
 */
@Slf4j
public class BloodyCaseCausedByNullPointer08Test {

    /**
     * 接口提供方预防空指针①：
     * 返回空集合
     */

    /**
     * 接口提供方预防空指针②：
     * 使用Optional防止空指针异常
     * Optional是Java 8引入的特性，返回一个Optional则明确告诉使用者结果可能为空
     */
    @Test
    public void useOptional() {
        Map<String, String> stringMap = new HashMap<String, String>() {{
            put("1", "sun");
            put("2", "sunshine");
            put("3", "root");
        }};

        Optional<String> optional1 = Optional.ofNullable(stringMap.get("1"));
        log.info("[useOptional] [optional1:{}]", optional1);
        boolean optional1Present = optional1.isPresent();
        log.info("[useOptional] [optional1Present:{}]", optional1Present);

        Optional<String> optional2 = Optional.ofNullable(stringMap.get("4"));
        log.info("[useOptional] [optional2:{}]", optional2);
        boolean optional2Present = optional2.isPresent();
        log.info("[useOptional] [optional2Present:{}]", optional2Present);
    }

    /**
     * 接口提供方预防空指针③：
     * 使用空对象设计模式
     */
    @Test
    public void useNullObjectDesignPatterns() {
        if (true) {
            nullObjectDesignPatterns(new NullOperation());
        }
    }

    private void nullObjectDesignPatterns(Operation operation) {
        int a = 5;
        int b = 6;

        // 使用空对象设计模式后无需再进行此步骤的判断
        /*if (operation != null) {
            operation.execute(a, b);
        }*/

        operation.execute(a, b);
    }


    // -----------------------------------接口提供者、接口开发者分割线----------------------------------- //

    /**
     * 接口使用者预防空指针综合测试
     */
    @Test
    public void testUserNullPointer() {
        objectsNotNull("sunshine");
        commonsStringUtils("sunshine");
        commonsValidate("sunshine");
        commonsCollectionUtils(new ArrayList<java.lang.String>() {{
            add("sunshine");
            add("ohhhhhhh");
        }});
        guavaPreconditions(1D);
        lombokNotNull("sunshine");
        ideaNotNull("idea");
    }

    /**
     * 接口使用者预防空指针①：
     * null检查
     */
    private void checkNull(String param) {
        if (param == null) {
            throw new IllegalArgumentException("参数不能为空");
        }

        // do nothing
    }

    /**
     * 接口使用者预防空指针②：
     * 使用Objects.requireNonNull()
     *
     * @param param
     */
    private void objectsNotNull(String param) {
        Objects.requireNonNull(param);
    }

    /**
     * 接口使用者预防空指针③：
     * 使用字符串工具类: org.apache.commons.lang3.StringUtils
     *
     * @param param
     */
    private void commonsStringUtils(String param) {
        if (StringUtils.isNotEmpty(param)) {
            // nothing
        }
    }

    /**
     * 接口使用者预防空指针③：
     * 使用校验工具类: org.apache.commons.lang3.Validate
     *
     * @param param
     */
    private void commonsValidate(String param) {
        Validate.notNull(param, "param must not null");
        Validate.notEmpty(param);
    }

    /**
     * 接口使用者预防空指针③：
     * 使用集合工具类: org.apache.commons.collections4.CollectionUtils
     *
     * @param params
     */
    private void commonsCollectionUtils(List<String> params) {
        if (CollectionUtils.isNotEmpty(params)) {
            // nothing
        }
    }

    /**
     * 接口使用者预防空指针④：
     * 使用guava包的com.google.common.base.Preconditions 前置条件检测类。
     *
     * @param value
     */
    private void guavaPreconditions(double value) {
        Preconditions.checkArgument(value >= 0, "input is negative: %s", value);
    }

    /**
     * 接口使用者预防空指针⑤：
     * 使用lombok @NonNull注解
     * <p>
     * 实际编译后代码
     * public void lombokNotNull(@NonNull String param) {
     *     if (param == null) {
     *         throw new NullPointerException("param is marked non-null but is null");
     *     } else {
     *         System.out.println(param);
     *     }
     * }
     *
     * @param param
     */
    private void lombokNotNull(@NonNull String param) {
        // nothing
    }

    /**
     * 接口使用者预防空指针⑥：
     * 使用IDEA @NotNull注解
     * @param param
     */
    private void ideaNotNull(@NotNull String param) {
        // nothing
    }
}

