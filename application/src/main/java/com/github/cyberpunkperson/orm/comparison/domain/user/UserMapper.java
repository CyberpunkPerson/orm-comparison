package com.github.cyberpunkperson.orm.comparison.domain.user;


import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userProjectionToUser(com.github.cyberpunkperson.orm.comparison.model.User user);

    com.github.cyberpunkperson.orm.comparison.model.User userToUserProjection(User user);

}
