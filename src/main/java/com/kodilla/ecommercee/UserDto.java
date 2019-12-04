package com.kodilla.ecommercee;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private String address;
    private Integer postcode;
}
