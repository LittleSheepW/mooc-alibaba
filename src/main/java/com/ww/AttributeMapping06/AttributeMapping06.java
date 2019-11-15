package com.ww.AttributeMapping06;

/**
 * @author: Sun
 * @create: 2019-11-15 15:35
 * @version: v1.0
 */
public class AttributeMapping06 {

    /**
     * 为了更容易维护，易于拓展等原因会使用各种分层领域模型。在多层应用中，常需要对各种不同的分层对象进行转换，
     * 这就会存在一个非常棘手的问题即:编写不同的模型之间相互转换的代码非常麻烦。其中最常见和最简单的方式是编写
     * 对象属性转换函数，即普通的Getter/Setter方法。除此之外各种各种属性映射工具。
     */

    /**
     * 本节问题：
     * 1、那么常见的Java属性映射工具有哪些?
     * org.apache.commons.beanutils.BeanUtils#copyProperties
     * org.springframework.beans.BeanUtils#copyProperties(java.lang.Object, java.lang.Object)
     * org.dozer.Mapper#map(java.lang.Object, java.lang.Class<T>)
     * net.sf.cglib.beans.BeanCopier#copy
     * ma.glasnost.orika.MapperFacade#map(S, D)
     * MapStruct
     *
     * 2、它们的原理以及对其性能怎样?
     * dozer、commons、springframework原理都是使用了反射
     * cglib 包含了asm的依赖，asm库是一个Java字节码操作和分析框架，它可以用来修改已经存在的字节码或者直接二进制形式动态生成class文件。asm的特点是小且快。
     * orika 包含了javassist的依赖，javassist让操作字节码非常容易。javassist 允许java 程序运行时定义一个新的类，也可以实现在JVM加载类文件时修改它。
     * MapStruct的官网的介绍我们可以看出，MapStruct 采用原生的方法调用，因此更快速，更安全也更容易理解。根据官网的介绍我们知道，
     * 使用时只需要使用它的注解，定义好转换接口，转换函数，编译时会自动生成转换工具的实现类、调用属性赋值和取值函数实现转换。
     * MapStruct还支持通过注解形式定义不同属性名的映射关系等，功能很强大。
     *
     * 结论:采用字节码增强技术的Java属性转换工具和普通的Getter/Setter方法性能相差无几，甚至比Getter/Setter效率还高，反射的性能相对较差。
     * 因此从性能来讲首推Getter/Setter方式(含MapStruct)，其次是cglib。
     *
     * 3、实际开发中该如何选择?
     * 属性转换工具的优势:用起来方便，往往一-行行代码就实现多属性的转换，而且属性不对应可以通过注解或者修改配置方式自动适配，功能非常强大。
     *
     * 属性转换工具的缺点:
     * 1.多次对象映射(从A映射到B，再从B映射到C)如果属性不完全一致容易出错;
     * 2.有些转换工具，属性类型不一致自动转换容易出现意想不到的BUG;
     * 3.基于反射和字节码增强技术的映射工具实现的映射，对一个类属性的修改不容易感知到对其它转换类的影响。
     *
     * 建议使用定义转换类和转换函数，使用IDE中的插件实现一键调用所有set方法完成转换，不需要引入其它库，降低了复杂性、可以 支持更录活的映射。
     */
}
