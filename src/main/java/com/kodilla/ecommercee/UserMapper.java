package com.kodilla.ecommercee;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
       User user = new User(userDto.getUsername(), userDto.getPassword(), userDto.getAddress(), userDto.getPostcode());
       user.setId(userDto.getId());
        return user;
    }

    public UserDto mapToDto(final User user) {
        return new UserDto(user.getId(),user.getUsername(),user.getPassword(),user.getAddress(),user.getPostcode());
    }
}
