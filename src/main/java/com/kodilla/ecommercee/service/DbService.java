package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.GroupEntity;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {
    @Autowired
    private GroupRepository repository;

    public List<GroupEntity> getAllGroups() {
        return repository.findAll();
    }

    public GroupEntity getGroupById(Long id){
        return repository.findById(id).orElse(null);
    }

    public GroupEntity saveTask(final GroupEntity groupEntity) {
        return repository.save(groupEntity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
