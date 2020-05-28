package com.rabbitears.controller.rest;

import com.rabbitears.dto.question.QuestionDto;
import com.rabbitears.entity.Question;
import com.rabbitears.entity.Result;
import com.rabbitears.entity.User;
import com.rabbitears.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/question")
public class QuestionRestController {

    IQuestionService questionService;

    @Autowired
    public void setQuestionService(IQuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody QuestionDto questionDto, HttpServletRequest request) {
        Question question = new Question();
        question.setTitle(questionDto.getTitle());
        question.setDescription(questionDto.getDescription());

        User user = (User) request.getSession().getAttribute("user");
        question.setId(user.getId());

        question.setCreateTime(LocalDateTime.now());
        question.setLastUpdateTime(question.getCreateTime());

        questionService.add(question);

        return Result.buildSuccess();
    }

}
