package com.rabbitears.controller;

import com.rabbitears.dao.UserDao;
import com.rabbitears.domain.User;
import com.rabbitears.service.UserService;
import io.micrometer.core.instrument.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/list")
    public String list() {
        ArrayList<User> list = userService.getAll();
        list.forEach(user -> System.out.println(user.getName()));
        return "success";
    }
}
