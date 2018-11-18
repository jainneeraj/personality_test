package com.spark.pt.ptservice.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spark.pt.ptservice.domain.models.Question;
import com.spark.pt.ptservice.domain.ports.QuizResponseService;

@RestController
public class QuizAPIController {

  private QuizResponseService quizResponseService;
    
    @Autowired
    public QuizAPIController(QuizResponseService quizResponseService) {
        this.quizResponseService = quizResponseService;
    }
     
    @PostMapping(path = "/quizResponse", consumes = "application/json", produces = "application/json")  
    public boolean  getQuestions(@RequestBody Question question) {
        return quizResponseService.saveQuestionReponse(question);
        
    }

	
	
}
