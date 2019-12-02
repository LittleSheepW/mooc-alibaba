package com.ww.HowToSolveTheMultiLevelNestingProblemOfConditionalStatements17;

import com.ww.HowToSolveTheMultiLevelNestingProblemOfConditionalStatements17.constant.SalaryStrategyEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: Sun
 * @create: 2019-12-02 17:07
 * @version: v1.0
 */
@Slf4j
public class HowToSolveTheMultiLevelNestingProblemOfConditionalStatements17Test {

    /**
     * 使用时根据枚举值获取枚举对象，直接调用该枚举常量对应的策略
     */
    @Test
    public void getSalary() {
        SalaryStrategyEnum salaryStrategyEnum = SalaryStrategyEnum.valueOf(0);
        if (salaryStrategyEnum != null) {
            log.info("角色：{}-->{} 元", salaryStrategyEnum.name(), salaryStrategyEnum.getSalary());
        }
    }
}
