package com.njesoft.user.controller;

import com.njesoft.user.VO.ResponseTemplateVO;
import com.njesoft.user.entity.User;
import com.njesoft.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(User user){
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable Long userId){
        return userService.getUserWithDepartment(userId);
    }
}
