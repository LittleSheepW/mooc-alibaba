package com.ww.Deprecated07.entity;

import lombok.Data;

import java.util.List;

@Data
public class OrderCreateParam {

    /**
     * 对象详情
     * 参考示例：'[{"count":22,"name":"商品1"},{"count":33,"name":"商品2"}]'
     * <p>
     * 废弃原因：订单详情由JSON传参，改为对象传参。
     * 替代方案： {@link com.ww.Deprecated07.entity.OrderCreateParam#orderItemParams}
     */
    @Deprecated
    private String orderItemDetail;

    private List<OrderItemParam> orderItemParams;

    // 其他属性
}