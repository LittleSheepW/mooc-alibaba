package com.ww.HowToSolveTheMultiLevelNestingProblemOfConditionalStatements17.validator;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Component;

@Component
public class UserSexValidator extends Validator<UserParam> {

    @Override
    void validate(UserParam param) {
        System.out.println("验证性别");
        if (param == null) {
            throw new RuntimeException("");
        }
        // 模拟服务，根据userId查询性别
        boolean isFemale = RandomUtils.nextBoolean();
        if (!isFemale) {
            throw new RuntimeException("仅限女性玩家哦！");
        }
    }
}