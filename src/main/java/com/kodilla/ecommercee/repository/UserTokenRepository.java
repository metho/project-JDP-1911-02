package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.UserToken;
import org.springframework.data.repository.CrudRepository;

public interface UserTokenRepository extends CrudRepository<UserToken,Long> {
}
