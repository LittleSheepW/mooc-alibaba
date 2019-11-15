package com.ww.AttributeMapping06;

import com.ww.AttributeMapping06.convert.UserConverter;
import com.ww.AttributeMapping06.convert.UserDO2DTOConverter;
import com.ww.AttributeMapping06.convert.UserDO2DTOConverter2;
import com.ww.AttributeMapping06.entity.OrderDTO;
import com.ww.AttributeMapping06.entity.OrderDo;
import com.ww.AttributeMapping06.entity.UserDO;
import com.ww.AttributeMapping06.entity.UserDTO;
import com.ww.AttributeMapping06.mapper.OrderDO2DtoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Date;


/**
 * @author: Sun
 * @create: 2019-11-15 15:41
 * @version: v1.0
 */
@Slf4j
public class AttributeMapping06Test {

    /**
     * 测试单向转换器
     */
    @Test
    public void userToUserDtoUnidirectional() {
        UserDO userDO = new UserDO();
        userDO.setId(1L);
        userDO.setAge(20);
        userDO.setBirthDay(new Date());
        userDO.setName("sunzhongwei");
        userDO.setNickName("sunshinew");
        log.info("[userToUserDtoUnidirectional] [userDo:{}]", userDO);

        UserDO2DTOConverter userDO2DTOConverter = new UserDO2DTOConverter();
        UserDTO userDTO = userDO2DTOConverter.convert(userDO);
        log.info("[userToUserDtoUnidirectional] [userDTO:{}]", userDTO);
    }

    /**
     * 测试双向转换器
     */
    @Test
    public void userToUserDtoBilateral() {
        UserDO userDO = new UserDO();
        userDO.setId(1L);
        userDO.setAge(20);
        userDO.setBirthDay(new Date());
        userDO.setName("sunzhongwei");
        userDO.setNickName("sunshinew");
        log.info("[userToUserDtoBilateral] [userDo:{}]", userDO);

        UserDO2DTOConverter2 userDO2DTOConverter2 = new UserDO2DTOConverter2();
        UserDTO userDTO = userDO2DTOConverter2.doForward(userDO);
        log.info("[userToUserDtoBilateral] [userDTO:{}]", userDTO);

        UserDO userDoBack = userDO2DTOConverter2.doBackward(userDTO);
        log.info("[userToUserDtoBilateral] [userDoBack:{}]", userDoBack);
    }

    /**
     * 大型转换器
     */
    @Test
    public void userToUserDtoBigConverter() {
        UserDO userDO = new UserDO();
        userDO.setId(1L);
        userDO.setAge(20);
        userDO.setBirthDay(new Date());
        userDO.setName("sunzhongwei");
        userDO.setNickName("sunshinew");
        log.info("[userToUserDtoBigConverter] [userDo:{}]", userDO);

        UserDTO userDTO = UserConverter.convertToDTO(userDO);
        log.info("[userToUserDtoBigConverter] [userDo:{}]", userDTO);
    }

    /**
     * 使用MapStruct实现属性映射
     */
    @Test
    public void orderToOrderDto() {
        OrderDo orderDo = new OrderDo();
        orderDo.setId(1);
        orderDo.setName("sunshine");
        orderDo.setTime(new Date());
        orderDo.setOrderNo(3572531321L);
        log.info("[orderToOrderDto] [orderDo:{}]", orderDo);

        OrderDTO orderDo2Dto = OrderDO2DtoMapper.INSTANCE.orderDo2Dto(orderDo);
        log.info("[orderToOrderDto] [orderDo2Dto:{}]", orderDo2Dto);

        OrderDo orderDto2Order = OrderDO2DtoMapper.INSTANCE.orderDto2Order(orderDo2Dto);
        log.info("[orderToOrderDto] [orderDto2Order:{}]", orderDto2Order);

    }
}
