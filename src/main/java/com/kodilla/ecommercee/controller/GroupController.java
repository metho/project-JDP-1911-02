package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/group")
public class GroupController {

    @Autowired
    GroupRepository groupRepository;

//    @Autowired
//    GroupMapper groupMapper;


}
