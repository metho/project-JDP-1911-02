package com.kodilla.ecommercee.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class UserToken extends User {

    @Id
    @GeneratedValue
    private Long id;
    private String token;
    private LocalDateTime tokenCreated;
    private LocalDateTime tokenExpired;

}
