package com.ww.HowToSolveTheMultiLevelNestingProblemOfConditionalStatements17;

import com.ww.HowToSolveTheMultiLevelNestingProblemOfConditionalStatements17.grard.GrardDemo;

/**
 * @author: Sun
 * @create: 2019-12-02 17:07
 * @version: v1.0
 */
public class HowToSolveTheMultiLevelNestingProblemOfConditionalStatements17 {

    /**
     * 《手册》第19页，有关于多if-else 分支和嵌套的建议和解决方案:
     * (1)表达分支时，如果非要使用if()...else if()...else...方式表达逻辑，避免后续代码维护困难，不允许超过三层。
     * (2)如果超过3层可以使用卫语句、策略模式、状态模式等来实现。
     * (3)其中卫语句代码逻辑优先考虑失败、异常、中断、退出等直接返回的情况。
     */

    /**
     * 本节问题:
     * (1)使用过程中会遇到哪些奇葩的问题呢?
     * 有时候会认为某种写法工作中并不会用到。实则不然，很多知识是你真正理解之后就会想到使用它，恰恰是自认为没用和没有真正理解才导致工作不能灵活运用。
     */

    /**
     * 如何替代多分支和分支嵌套问题呢?
     * (1)如果某个条件极其罕见，就应该单独检查该条件，并在条件为真时立即从函数中返回。这样的单独检查常常被称为“卫语句”。卫语句要不就从函数中返回，要不就抛出一个异常。
     * 卫语句使用注意事项：使用卫语句是要特别注重卫语句的先后顺序，当条件非常复杂时，要特别注意卫语句的中断是否符合希望的逻辑。 {@link GrardDemo}
     *
     * (2)使用策略模式(枚举形式)，通过在枚举内部定义抽象函数，每个枚举常量重写该函数，这样根据枚举值获取枚举常量后调用该函数即可获得期待的计算结果。
     * {@link com.ww.HowToSolveTheMultiLevelNestingProblemOfConditionalStatements17.HowToSolveTheMultiLevelNestingProblemOfConditionalStatements17Test#getSalary(),com.ww.HowToSolveTheMultiLevelNestingProblemOfConditionalStatements17.constant.SalaryStrategyEnum}
     *
     * (3)使用状态模式，状态模式的使用场景有两类:
     * ①一种是行为随着状态改变而改变的场景
     * ②条件、分支判断语句的替代者。
     * 状态模式的其中一个优点就是“结构清晰”。状态模式体现了开闭原则和单一-职责原则，易于拓展和维护。所谓的结构清晰就是避免了过多的
     * switch-case 或者if-else 语句的使用，避免了程序的复杂性，提高了程序的可维护性。
     *
     * (4)拦截器过滤器模式，如果是Spring Web项目中还可以通过实现org.springframework.context.ApplicationContextAware接口，
     * 构造待处理的类型到对应处理器的映射，这也是简化if-else if-else的一个重要手段。  TODO: 2019-12-02 现阶段无法理解此种模式
     * <p>
     */
}
