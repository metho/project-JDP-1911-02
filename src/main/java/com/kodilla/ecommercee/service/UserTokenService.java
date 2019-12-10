package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.UserToken;
import com.kodilla.ecommercee.repository.UserTokenRepository;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTokenService {

    @Autowired
    private UserTokenRepository repository;

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
        UserToken userToken = new UserToken(userId, token, tokenCreated, tokenExpired);
        return repository.save(userToken);
    }

    public String validateToken(Long userId, String password, UserToken userToken)
            throws InvalidLoginDetailsException, TokenExpiredException {
        if (authenticatedToken(userId, password)) {
            if (LocalDateTime.now().isBefore(userToken.getTokenExpired())) {
                return userToken.getToken();
            } else {
                throw new TokenExpiredException();
            }
        } else {
            throw new InvalidLoginDetailsException();
        }
    }

    public boolean authenticatedToken(Long userId, String password) {
        boolean result = repository.existsById(userId) && password.equals(repository.findById(userId).get().getUser().getPassword());
        return result;
    }
}
