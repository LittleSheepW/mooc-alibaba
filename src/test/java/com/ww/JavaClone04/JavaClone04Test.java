package com.ww.JavaClone04;

import com.ww.JavaClone04.entity.Order;
import com.ww.JavaClone04.util.CloneUtil;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author: Sun
 * @create: 2019-11-14 13:43
 * @version: v1.0
 */
public class JavaClone04Test {


    /**
     * 对于任何对象而言，一-般来说下面的表达式成立:
     * x.clone() != x的结果为true
     * x.clone().getClass() == x.getClass()的结果为true
     * 但是这些也不是强制的要求。
     * x.clone().equals(x)的结果也是true。这也不是强制要求。
     * <p>
     * 测试调用clone()方法的特性是否一致
     * <p>
     * 需要将Order类中的clone()修改为如下代码
     *
     * @Override
     * public Order clone() {
     *     try {
     *         return (Order) super.clone();
     *     } catch (CloneNotSupportedException e) {
     *         e.printStackTrace();
     *     }
     *     return null;
     * }
     */
    @Test
    public void shallowClone() {
        Order order = new Order();
        order.setId(1L);
        order.setOrderNo("00001");
        order.setItemList(new ArrayList<>());
        Order cloneOrder = order.clone();

        assertFalse(order == cloneOrder);
        assertTrue(order.getItemList() == cloneOrder.getItemList());
        assertTrue(order.getClass() == cloneOrder.getClass());
    }

    /**
     * 深克隆第一种方式：手动深拷贝方式实现深克隆
     */
    @Test
    public void deepCloneByManual() {
        Order order = new Order();
        order.setId(1L);
        order.setOrderNo("00001");
        order.setItemList(new ArrayList<>());
        Order cloneOrder = order.clone();

        assertFalse(order == cloneOrder);
        assertFalse(order.getItemList() == cloneOrder.getItemList());
        assertTrue(order.getClass() == cloneOrder.getClass());
    }

    /**
     * 深克隆第三种方式：使用commons-land3类库中的方法
     * 该深克隆的方式不如在类中手动重写clone()方法的效率高，该方法本质上也是通过Java序列化和反序列化实现
     */
    @Test
    public void deepCloneByLang3() {
        Order order = new Order();
        order.setId(1L);
        order.setOrderNo("00001");
        order.setItemList(new ArrayList<>());

        Order cloneOrder = SerializationUtils.clone(order);

        assertFalse(order == cloneOrder);
        assertFalse(order.getItemList() == cloneOrder.getItemList());
        assertTrue(order.getClass() == cloneOrder.getClass());
    }

    /**
     * 深克隆第四种方式：使用GSON包进行json序列化
     * 使用JSON序列化方式实现深拷贝的好处是，性能比Java序列化方式更好，
     * 更重要的是不要求序列化对象以及成员属性(嵌套) 都要实现序列化接口。
     */
    @Test
    public void deepCloneByGson() {
        Order order = new Order();
        order.setId(1L);
        order.setOrderNo("00001");
        order.setItemList(new ArrayList<>());

        Order cloneOrder = CloneUtil.deepCloneByGson(order, Order.class);
        assertFalse(order == cloneOrder);
        assertFalse(order.getItemList() == cloneOrder.getItemList());
        assertTrue(order.getClass() == cloneOrder.getClass());
    }

    /**
     * 1、不要让客户端去做任何类库可以替它完成的事
     * 2、不管采取哪种或者哪几种深拷贝方式，都尽量将其封装到项目的克隆工具类中，方便复用。
     */
}
