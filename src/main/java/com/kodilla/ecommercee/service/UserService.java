package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public Optional<User> findUser(Long userId) {
        return repository.findById(userId);
    }

    public boolean userExists(Long userId) {
        return repository.existsById(userId);
    }

    public boolean authenticated(Long userId, String password) {
        boolean result = repository.existsById(userId) && password.equals(repository.findById(userId).get().getPassword());
        return result;
    }
}
