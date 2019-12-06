package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.domain.UserToken;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
       User user = new User(userDto.getUsername(), userDto.getPassword(), userDto.getAddress(), userDto.getPostcode());
       user.setId(userDto.getId());
       user.setBlocked(userDto.isBlocked());
       return user;
    }

    public UserDto mapToDto(final User user) {
        return new UserDto(user.getId(),user.getUsername(),user.getPassword(),user.getAddress(),user.getPostcode(),user.isBlocked());
    }

    public User mapToUserFromUserToken(final UserToken userToken) {
        User user = new User(userToken.getUsername(),userToken.getPassword(),userToken.getAddress(),userToken.getPostcode());
        return user;
    }
}
