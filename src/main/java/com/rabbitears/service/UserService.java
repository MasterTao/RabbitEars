package com.rabbitears.service;

import com.rabbitears.entity.User;
import com.rabbitears.mapper.UserExample;
import com.rabbitears.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

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

        // 密码加密
        String md5Pwd = DigestUtils.md5DigestAsHex(password.getBytes());
        user.setPassword(md5Pwd);

        // 这里设置一个默认图片
        user.setAvatar("/images/avatars/defaultAvatar.png");
        user.setCreateTime(LocalDateTime.now());
        user.setLastUpdateTime(user.getCreateTime());
        userMapper.insert(user);
    }

    public User updatePassword(Integer id, String newPassword) {
        User user = new User();
        user.setId(id);
        user.setPassword(DigestUtils.md5DigestAsHex(newPassword.getBytes()));
        userMapper.updateByPrimaryKeySelective(user);
        return userMapper.selectByPrimaryKey(id);
    }
}
