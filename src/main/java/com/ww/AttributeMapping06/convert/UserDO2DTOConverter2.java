package com.ww.AttributeMapping06.convert;

import com.google.common.base.Converter;
import com.ww.AttributeMapping06.entity.UserDO;
import com.ww.AttributeMapping06.entity.UserDTO;

/**
 * 双向转换
 */
public class UserDO2DTOConverter2 extends Converter<UserDO, UserDTO> {

    @Override
    public UserDTO doForward(UserDO userDO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(userDO.getName());
        userDTO.setAge(userDO.getAge());
        userDTO.setNickName(userDO.getNickName());
        userDTO.setBirthDay(userDO.getBirthDay());
        return userDTO;

    }

    @Override
    public UserDO doBackward(UserDTO userDTO) {
        UserDO userDO = new UserDO();
        userDO.setName(userDTO.getName());
        userDO.setAge(userDTO.getAge());
        userDO.setNickName(userDTO.getNickName());
        userDO.setBirthDay(userDTO.getBirthDay());
        return userDO;

    }
  }