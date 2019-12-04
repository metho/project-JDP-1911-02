package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserService;
import com.kodilla.ecommercee.domain.UserToken;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private UserMapper mapper;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        service.saveUser(mapper.mapToUser(userDto));
    }

    @PutMapping("{userId}")
    public void blockUser(@PathVariable Long userId) {
        Optional<User> user = service.findUser(userId);
        if(user.isPresent()) {
            user.get().setBlocked(true);
        }
        mapper.mapToDto(service.saveUser(user.get()));
    }

    @PutMapping
    public void validateTokenOneHour(UserToken userToken) {
        if (LocalDateTime.now().isBefore(userToken.getTokenCreated().plusMinutes(60))) {
            Optional<User> user = service.findUser(userToken.getUserId());
            if(user.isPresent()) {
                user.get().setBlocked(false);
                mapper.mapToDto(service.saveUser(user.get()));
            } else {
                user.get().setBlocked(true);
                mapper.mapToDto(service.saveUser(user.get()));
            }
        }
    }
}