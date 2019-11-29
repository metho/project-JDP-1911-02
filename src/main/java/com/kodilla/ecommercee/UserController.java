package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @PostMapping(value = "create", consumes = APPLICATION_JSON_VALUE)
    public void createUser(UserDto userDto) {
        userDto = new UserDto(1L,"user","password", "Elm Street",32333);
    }

    @PutMapping(value = "block")
    public void blockUser(Long userId) {

    }

    @PutMapping(value = "generateToken")
    public String generateToken(Long userId) {
        return "abc";
    }
}
