package com.ww.Meal.Second;

/**
 * @author: Sun
 * @create: 2019-12-24 15:20
 * @version: v1.0
 */
public class Second {

    /**
     * JVM指令：
     * invokestatic:用于调用静态方法，即使用static关键字修饰的方法。这些方法在编译器就可以确定，运行期不会修改，因此方法调用指令中效率最高，属于静态绑定;
     * invokespecial:用于调用私有实例方法、构造器，以及使用super 关键字调用父类的实例方法或构造器，和所实现接口的默认方法。用在类加载时就能确定具体的方法，不需要等到运行时根据实际对象去调用该对象的函数;
     * invokevirtual:用于调用非私有实例方法;
     * invokeinterface:用于调用接口方法，在运行时确定一个实现此接口的对象;
     * invokedynamic:用于调用动态方法，invokedynamic把如何查找目标方法的决定权从虚拟机下放到了具体的用户代码中，为实现lambda表达式，实现动态语言等提供了便利。
     */
}
