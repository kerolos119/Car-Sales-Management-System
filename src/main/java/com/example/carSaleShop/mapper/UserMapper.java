package com.example.carSaleShop.mapper;

import com.example.carSaleShop.document.Users;
import com.example.carSaleShop.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends AbstractMapper<UserDto, Users> {

    public UserMapper() {
        super(UserDto.class, Users.class);
    }

    @Override
    public Users updateToEntity(UserDto dto, Users entity) {
        if (dto.getUsername() != null && !dto.getUsername().isBlank())
            entity.setUsername(dto.getUsername());
        if (dto.getPassword() != null && !dto.getPassword().isBlank())
            entity.setPassword(dto.getPassword()); // encoding handled in service
        return entity;
    }
}