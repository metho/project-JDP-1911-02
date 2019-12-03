package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.GroupEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends CrudRepository<GroupEntity, Long> {
    @Override
    Optional<GroupEntity> findById(Long id);
    @Override
    List<GroupEntity> findAll();
    @Override
    GroupEntity save (GroupEntity task);
    @Override
    void deleteById(Long id);
}
