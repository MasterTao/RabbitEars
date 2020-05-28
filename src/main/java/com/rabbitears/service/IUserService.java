package com.rabbitears.service;

import com.rabbitears.entity.User;

public interface IUserService {
    User getByName(String name);

    void add(String name, String password);

    User updatePassword(Integer id, String newPassword);
}
