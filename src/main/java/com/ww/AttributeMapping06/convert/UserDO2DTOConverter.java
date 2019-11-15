package com.ww.AttributeMapping06.convert;

import com.ww.AttributeMapping06.entity.UserDO;
import com.ww.AttributeMapping06.entity.UserDTO;
import org.springframework.core.convert.converter.Converter;


/**
 * 单向转换
 */
public class UserDO2DTOConverter implements Converter<UserDO, UserDTO> {

    @Override
    public UserDTO convert(UserDO source) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(source.getName());
        userDTO.setAge(source.getAge());
        userDTO.setNickName(source.getNickName());
        userDTO.setBirthDay(source.getBirthDay());
        return userDTO;
    }
}