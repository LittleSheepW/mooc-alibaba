package com.ww.SingleTestExampleOfUnitTest22;

import org.apache.commons.lang3.StringUtils;

/**
 * @author: Sun
 * @create: 2019-12-09 15:18
 * @version: v1.0
 */
public class SingleTestExampleOfUnitTest22 {

    /**
     * 《手册》第29页有对数据库单元测试的规定:
     *【推荐】和数据库相关的单元测试，可以设定自动回滚机制，不给数据库造成脏数据。或对单元测试产生的数据有明确的前后缀标识。
     */

    /**
     * 本节问题：
     * 1、对那些代码写单测？
     * 实际开发中，主要对数据访问层、服务层和工具类进行单元测试。
     * (1)数据库相关的单元测试一般要设置自动回滚。除此之外，还可以整合H2等内存数据库来对数据访问层代码进行测试。
     * (2)工具类的单元测试也非常重要，因为工具类一般在服务内共用，如果有BUG,影响面很大，很容易造成线上问题或故障。一般需要构造正常和边界值两种类型的用例，
     * 对工具类进行全面的测试，才可放心使用。此时结合注释小节所讲的内容，需将典型的调用和结果添加到注释上，方便函数的使用者。
     * (3)服务层的单元测试，一般要依赖mock工具，将服务的所有依赖都mock掉。其本质是“ 控制变量法”，将原本依赖的N个“变量"都变为“常量”，只观察所要测试的服务逻辑是否正确。
     *
     * 2、单元测试的结构
     * 典型的单元测试可分为三个阶段，分别为准备、执行和验证
     * 准备阶段(Given)主要负责创建测试数据、构造mock方法的返回值，准备环节的编码是单元测试最复杂的部分。需要注意的是Mockito库中以when开头的函数其实是在准备阶段。
     * 执行阶段(When)一般只是调用测试的函数，此部分代码通常较短。
     * 验证阶段(Then)通常验证测试函数的执行的结果、准备阶段mock函数的调用次数等是否符合预期。
     *
     * 3、单元测试方法如何命名？
     * (1)采用驼峰命名并应该体现出该测试函数的核心含义。
     */

    /**
     * 代码测试用例模板：
     * @Test
     * public void shouldReturnItemNameInUpperCase() {
     *     // Given     准备阶段，构造测试对象(数据)并mock掉底层依赖
     *     Item mockedItem = new Item("it1", "Item 1", "This is item 1", 2000, true);
     *     when(itemRepository.findById("it1")).thenReturn(mockedItem);
     *
     *     // When      直接调用待测试的函数
     *     String result = itemService.getItemNameUpperCase("it1");
     *
     *     // Then      验证阶段对结果进行断言
     *     verify(itemRepository, times(1)).findById("it1");
     *     assertThat(result).isEqualTo("ITEM 1");
     * }
     */

}

