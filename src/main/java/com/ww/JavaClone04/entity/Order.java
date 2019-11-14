package com.ww.JavaClone04.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Order implements Cloneable, Serializable {

    private Long id;

    private String orderNo;

    private List<Item> itemList;


    @Override
    public Order clone() {
        try {
            Order order = (Order) super.clone();
            if (id != null) {
                order.id = new Long(id);
            }
            if (orderNo != null) {
                order.orderNo = new String(orderNo);
            }

            if (itemList != null) {
                List<Item> items = new ArrayList<>();
                for (Item each : itemList) {
                    Item item = new Item();
                    Long id = each.getId();
                    if (id != null) {
                        item.setId(new Long(id));
                    }
                    Long itemId = each.getItemId();
                    if (itemId != null) {
                        item.setItemId(new Long(itemId));
                    }
                    String name = each.getName();
                    if (name != null) {
                        item.setName(new String(name));
                    }
                    String desc = each.getDesc();
                    if (desc != null) {
                        item.setDesc(new String(desc));
                    }
                    items.add(item);
                }
                order.setItemList(items);
            }
            return order;
        } catch (CloneNotSupportedException ignore) {

        }

        return null;
    }
}