package com.applaudo.andres.userManagementApp.mapper;

import com.applaudo.andres.userManagementApp.dto.UserDto;
import com.applaudo.andres.userManagementApp.entity.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    UserDto userEntity2UserDTO(UserEntity entity);
    UserEntity userDTO2UserEntity(UserDto dto);
}
