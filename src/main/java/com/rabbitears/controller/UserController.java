package com.rabbitears.controller;

import com.rabbitears.entity.User;
import com.rabbitears.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户相关操作
 * @author tao
 */
@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestParam("name") String name, @RequestParam("password") String password) {
        if ("".equals(name) || "".equals(password)) {
            return "用户名，密码不能为空";
        }

        User user = userService.getByName(name);
        if (null != user) {
            return "用户名已存在";
        }

        userService.add(name, password);
        return "添加成功";
    }

    @PostMapping("/login")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, HttpServletRequest request) {
        User user = userService.getByName(name);
        if (null == user) {
            return "用户名或密码错误";
        }

        if (!user.getPassword().equals(password)) {
            return "用户名或密码错误";
        }

        // 设置session
        request.getSession().setAttribute("user", user);

        return "登陆成功";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "success";
    }

    @PostMapping("/modify")
    public String modify() {
        return "success";
    }

    @GetMapping("/info")
    public String info(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        System.out.println(user);
        return "success";
    }
}
