package com.rabbitears.service.impl;

import com.rabbitears.entity.Question;
import com.rabbitears.mapper.QuestionMapper;
import com.rabbitears.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements IQuestionService {

    QuestionMapper questionMapper;

    @Autowired
    public void setQuestionMapper(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    @Override
    public List<Question> list() {
        return null;
    }

    @Override
    public Integer add(Question question) {
        return questionMapper.insertSelective(question);
    }
}
