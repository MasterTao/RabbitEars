package com.rabbitears.service;

import com.rabbitears.dao.UserDao;
import com.rabbitears.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public ArrayList<User> getAll() {
        return userDao.getAll();
    }
}
