package com.ww.AttributeMapping06.mapper;

import com.ww.AttributeMapping06.entity.OrderDTO;
import com.ww.AttributeMapping06.entity.OrderDo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * 使用MapStruct完成属性映射
 * @author: Sun
 * @create: 2019-11-15 17:26
 * @version: v1.0
 */
@Mapper
public interface OrderDO2DtoMapper {

    OrderDO2DtoMapper INSTANCE = Mappers.getMapper(OrderDO2DtoMapper.class);

    @Mapping(source = "orderNo", target = "serialNumber")
    OrderDTO orderDo2Dto(OrderDo var1);

    @Mapping(source = "serialNumber", target = "orderNo")
    OrderDo orderDto2Order(OrderDTO var1);
}
