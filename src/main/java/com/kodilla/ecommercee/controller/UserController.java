package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.InvalidLoginDetailsException;
import com.kodilla.ecommercee.service.UserService;
import com.kodilla.ecommercee.domain.UserToken;
import com.kodilla.ecommercee.service.UserTokenService;
import java.time.LocalDateTime;
import java.util.Optional;
import org.omg.CORBA.DynAnyPackage.Invalid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private UserTokenService tokenService;

    @Autowired
    private UserMapper mapper;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        service.saveUser(mapper.mapToUser(userDto));
    }

    @PutMapping("{userId}")
    public void blockUser(@PathVariable Long userId) {
        Optional<User> user = service.findUser(userId);
        user.ifPresent(theUser -> theUser.setBlocked(true));
        mapper.mapToDto(service.saveUser(user.get()));
    }

    @PutMapping(path = "{userId}/{password}")
    public String requestToken(@PathVariable Long userId, @PathVariable String password) throws InvalidLoginDetailsException {
        if (service.userExists(userId) && password.equals(service.findUser(userId).get().getPassword())) {
            UserToken userToken = tokenService.generateToken(userId);
            String token = userToken.getToken();
            return token;
        } else {
            throw new InvalidLoginDetailsException();
        }
    }
}
