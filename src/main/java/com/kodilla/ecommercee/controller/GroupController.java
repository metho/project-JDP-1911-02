package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/group")
@CrossOrigin("*")
public class GroupController {

    @Autowired
    private DbService service;

    @Autowired
    private GroupMapper groupMapper;

    @GetMapping
    public List<GroupDto> getGroups() {
        return groupMapper.mapToGroupDtoList(service.getAllGroups());
    }
    @GetMapping
    public GroupDto getGroup (Long groupId){
        return groupMapper.mapToGroupDto(service.getGroupById(groupId));
    }
    @DeleteMapping
    public void deleteGroup (Long groupId){
        service.deleteById(groupId);
    }
    @PostMapping
    public void createGroup (@RequestBody GroupDto groupDto) {
        service.saveTask(groupMapper.mapToGroup(groupDto));
    }

}
