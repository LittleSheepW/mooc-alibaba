package com.ww.JavaSerializable03.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 使用支持序列化的Address Decorator对不支持序列化的属性进行序列化
 */
public class SerializePersonTransit implements Serializable {

    private Long id;
    private String name;
    private Boolean male;
    private List<SerializePersonTransit> friends;
    private SerializeAddress serializeAddress;

}