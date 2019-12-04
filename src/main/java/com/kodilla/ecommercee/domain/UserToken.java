package com.kodilla.ecommercee.domain;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserToken {

    private Long userId;
    private String token;
    private LocalDateTime tokenCreated;

    public UserToken generateToken(Long userId) {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        String token = bytes.toString();
        LocalDateTime tokenCreated = LocalDateTime.now();
        UserToken userToken = new UserToken(userId,token,tokenCreated);
        return userToken;
    }
}
