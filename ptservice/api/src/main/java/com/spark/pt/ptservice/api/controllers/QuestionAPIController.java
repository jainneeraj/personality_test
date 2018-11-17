package com.spark.pt.ptservice.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spark.pt.ptservice.domain.models.Question;
import com.spark.pt.ptservice.domain.ports.GetQuestionService;

@RestController
public class QuestionAPIController {

    private GetQuestionService getQuestionService;
    
    @Autowired
    public QuestionAPIController(GetQuestionService getQuestionService) {
        this.getQuestionService = getQuestionService;
    }
    
    @GetMapping("/questions")
    public List<Question> getQuestions() {
        return getQuestionService.getAllQuestion();
        
    }


}
