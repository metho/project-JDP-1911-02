package com.kodilla.ecommercee.repository;

import org.springframework.data.repository.CrudRepository;

import java.security.acl.Group;
import java.util.Optional;

public interface GroupRepository extends CrudRepository<Group, Long> {
    @Override
    Optional<Group> findById(Long id);

}
