package com.kodilla.ecommercee;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDto {

    private Long userId;
    private String username;
    private String password;

}
