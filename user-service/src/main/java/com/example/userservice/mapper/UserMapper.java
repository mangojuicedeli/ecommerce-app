package com.example.userservice.mapper;

import com.example.userservice.dto.UserDto;
import com.example.userservice.repository.UserEntity;
import com.example.userservice.vo.RequestUser;
import com.example.userservice.vo.ResponseUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity convertDtoToEntity(UserDto userDto);
    UserDto convertReqToDto(RequestUser requestUser);
    ResponseUser convertDtoToRes(UserDto userDto);
}
