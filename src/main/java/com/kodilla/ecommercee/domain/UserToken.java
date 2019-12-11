package com.kodilla.ecommercee.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
