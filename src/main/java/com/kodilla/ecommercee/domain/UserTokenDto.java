package com.kodilla.ecommercee.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserTokenDto {

    private Long id;
    private String token;
    private LocalDateTime tokenCreated;
    private LocalDateTime tokenExpired;
}
