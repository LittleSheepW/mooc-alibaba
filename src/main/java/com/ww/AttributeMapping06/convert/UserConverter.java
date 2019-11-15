package com.ww.AttributeMapping06.convert;

import com.ww.AttributeMapping06.entity.UserDO;
import com.ww.AttributeMapping06.entity.UserDTO;

/**
 * 大型转换器，在这里编写该对象到各层对象的转换函数
 */
public class UserConverter {

    public static UserDTO convertToDTO(UserDO source) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(source.getName());
        userDTO.setAge(source.getAge());
        userDTO.setNickName(source.getNickName());
        userDTO.setBirthDay(source.getBirthDay());
        return userDTO;
    }

    public static UserDO convertToDO(UserDO source) {
        UserDO userDO = new UserDO();
        userDO.setId(source.getId());
        userDO.setName(source.getName());
        userDO.setAge(source.getAge());
        userDO.setNickName(source.getNickName());
        userDO.setBirthDay(source.getBirthDay());
        return userDO;
    }
    
  // 转换成UserVO等
}