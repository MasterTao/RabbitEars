package com.rabbitears.service;

import com.rabbitears.entity.Question;

import java.util.List;

public interface IQuestionService {

    // TODO 分页
    List<Question> list();

    Integer add(Question question);
}
