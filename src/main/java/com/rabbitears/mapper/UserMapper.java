package com.rabbitears.mapper;

import com.rabbitears.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * UserMapper继承基类
 */
@Mapper
@Repository
public interface UserMapper extends MyBatisBaseDao<User, Integer, UserExample> {
}