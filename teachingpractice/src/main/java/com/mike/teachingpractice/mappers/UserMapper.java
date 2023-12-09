/*
 * Mapper with MapStruct to map the User model to the UserDto
 */
package com.mike.teachingpractice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mike.teachingpractice.dtos.SignUpDto;
import com.mike.teachingpractice.dtos.UserDto;
import com.mike.teachingpractice.models.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "passwordHash", ignore = true)
    User signUpToUser(SignUpDto signUpDto);
}
