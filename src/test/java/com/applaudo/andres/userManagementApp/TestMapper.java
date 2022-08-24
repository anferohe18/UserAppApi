package com.applaudo.andres.userManagementApp;

import com.applaudo.andres.userManagementApp.dto.UserDto;
import com.applaudo.andres.userManagementApp.entity.UserEntity;
import com.applaudo.andres.userManagementApp.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TestMapper {
    private UserMapper mapper = Mappers.getMapper(UserMapper.class);


    @Test
    void givenUserDto_When_Maps_Then_Correct(){
        UserDto dto = new UserDto();
        dto.setEmail("andresr427@gmail.com");
        dto.setPhone("312123456789");
        dto.setFirstName("Andres");
        dto.setLastName("Rodriguez");
        UserEntity entity = mapper.userDTO2UserEntity(dto);
        Assertions.assertEquals(dto,entity);

    }
}
