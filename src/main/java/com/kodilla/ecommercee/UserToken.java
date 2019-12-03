package com.kodilla.ecommercee;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserToken {

    private String token;
    private LocalDateTime tokenCreated;
    }
