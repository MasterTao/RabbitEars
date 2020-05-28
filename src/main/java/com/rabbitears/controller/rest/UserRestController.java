package com.rabbitears.controller.rest;

import com.rabbitears.dto.user.ModifyPasswordDto;
import com.rabbitears.dto.user.LoginDto;
import com.rabbitears.dto.user.RegisterDto;
import com.rabbitears.entity.Result;
import com.rabbitears.entity.User;
import com.rabbitears.enums.ResultEnum;
import com.rabbitears.service.IUserService;
import com.rabbitears.service.impl.UserServiceImpl;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户相关操作
 * @author tao
 */
@RestController
@RequestMapping("/v1/user")
public class UserRestController {

    IUserService userService;

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public Result register(@RequestBody RegisterDto registerDto) {
        String name = registerDto.getName();
        String password = registerDto.getPassword();
        String confirmPassword = registerDto.getConfirmPassword();

        if ("".equals(name) || "".equals(password)) {
            return Result.build(ResultEnum.USER_INFO_EMPTY.getCode(), ResultEnum.USER_INFO_EMPTY.getMessage());
        }

        if (!password.equals(confirmPassword)) {
            return Result.build(ResultEnum.USER_CONFIRM_PASSWORD_ERROR.getCode(), ResultEnum.USER_CONFIRM_PASSWORD_ERROR.getMessage());
        }

        User user = userService.getByName(name);
        if (null != user) {
            return Result.build(ResultEnum.USER_NAME_EXIST.getCode(), ResultEnum.USER_NAME_EXIST.getMessage());
        }

        userService.add(name, password);
        return Result.buildSuccess();
    }

    @PostMapping(value = "/login")
    public Result login(@RequestBody LoginDto loginDto, HttpServletRequest request) {
        String name = loginDto.getName();
        User user = userService.getByName(name);
        if (null == user) {
            return Result.build(ResultEnum.USER_INFO_ERROR.getCode(), ResultEnum.USER_INFO_ERROR.getMessage());
        }

        // 判断加密后密码是否一致
        String password = loginDto.getPassword();
        String md5Pwd = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!user.getPassword().equals(md5Pwd)) {
            return Result.build(ResultEnum.USER_INFO_ERROR.getCode(), ResultEnum.USER_INFO_ERROR.getMessage());
        }

        // 设置session
        request.getSession().setAttribute("user", user);
        System.out.println(ReflectionToStringBuilder.reflectionToString(user));
        return Result.buildSuccess();
    }

    @GetMapping("/logout")
    public Result logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return Result.buildSuccess();
    }

    @PostMapping("/modifyPassword")
    public Result modify(@RequestBody ModifyPasswordDto modifyPasswordDto, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");

        // 两次密码输入不一致
        if (modifyPasswordDto.getNewPassword().equals(modifyPasswordDto.getOldPassword())) {
            return Result.build(ResultEnum.USER_CONFIRM_PASSWORD_ERROR.getCode(), ResultEnum.USER_CONFIRM_PASSWORD_ERROR.getMessage());
        }

        // 原密码输入错误
        String md5Pwd = DigestUtils.md5DigestAsHex(modifyPasswordDto.getOldPassword().getBytes());
        if (!user.getPassword().equals(md5Pwd)) {
            return Result.build(ResultEnum.USER_PASSWORD_ERROR.getCode(), ResultEnum.USER_PASSWORD_ERROR.getMessage());
        }

        User newUser = userService.updatePassword(user.getId(), modifyPasswordDto.getNewPassword());
        request.getSession().setAttribute("user", newUser);
        return Result.buildSuccess();
    }

    @GetMapping("/info")
    public Result info(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        return Result.build(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), user);
    }
}
