package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserToken;
import com.kodilla.ecommercee.repository.UserRepository;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTokenService {

    @Autowired
    private UserRepository repository;
    private User user;

    public UserToken saveToken(UserToken token) {
        return repository.save(token);
    }
    public UserToken generateToken(Long userId) {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        String token = bytes.toString();
        LocalDateTime tokenCreated = LocalDateTime.now();
        LocalDateTime tokenExpired = LocalDateTime.now().plusMinutes(60);
        UserToken userToken = new UserToken(userId,token,tokenCreated,tokenExpired);
        return userToken;
    }

    public boolean validateToken(String username, String password, UserToken userToken)
        throws InvalidLoginDetailsException, TokenExpiredException {
        if(this.user.getUsername().equals(username) && this.user.getPassword().equals(password)) {
            if(LocalDateTime.now().isBefore(userToken.getTokenExpired())) {
                return true;
            } else { throw new TokenExpiredException();}
        } else { throw new InvalidLoginDetailsException();}
    }
}
