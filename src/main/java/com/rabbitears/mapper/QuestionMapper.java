package com.rabbitears.mapper;

import com.rabbitears.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * QuestionDAO继承基类
 */
@Mapper
@Repository
public interface QuestionMapper extends MyBatisBaseDao<Question, Integer, QuestionExample> {
}