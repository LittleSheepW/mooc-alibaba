package com.ww.AttributeMapping06.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author: Sun
 * @create: 2019-11-15 17:25
 * @version: v1.0
 */
@Data
public class OrderDo {

    private Integer id;

    private String name;

    private Date time;

    private Long orderNo;
}
