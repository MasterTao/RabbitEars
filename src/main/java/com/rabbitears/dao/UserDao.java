package com.rabbitears.dao;

import com.rabbitears.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Mapper
public interface UserDao {
    ArrayList<User> getAll();
}
