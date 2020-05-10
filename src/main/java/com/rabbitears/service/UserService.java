package com.rabbitears.service;

import com.rabbitears.entity.User;
import com.rabbitears.mapper.UserExample;
import com.rabbitears.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class UserService {

    UserMapper userMapper;

    @Autowired
    public void setUserDao(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getByName(String name) {
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(name);
        List<User> users = userMapper.selectByExample(example);
        return users.isEmpty() ? null : users.get(0);
    }

    public void add(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setAvatar("");
        user.setCreateTime(LocalDateTime.now());
        user.setLastUpdateTime(user.getCreateTime());
        userMapper.insert(user);
    }


}
