package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
public class UserToken {

    @Id
    @GeneratedValue
    private Long id;
    private String token;
    private LocalDateTime tokenCreated;
    private LocalDateTime tokenExpired;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public UserToken(Long id, String token, LocalDateTime tokenCreated, LocalDateTime tokenExpired) {
        this.token = token;
        this.tokenCreated = tokenCreated;
        this.tokenExpired = tokenExpired;
    }
}
