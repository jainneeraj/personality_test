package com.spark.pt.ptservice.domain.serviceadapters;

import com.spark.pt.ptservice.domain.models.Question;
import com.spark.pt.ptservice.domain.ports.QuizResponseRepository;
import com.spark.pt.ptservice.domain.ports.QuizResponseService;

public class QuizResponseServiceAdapter implements QuizResponseService{

	
	private QuizResponseRepository quizResponseRepository ;
	
	
	 public QuizResponseServiceAdapter(QuizResponseRepository quizResponseRepository) {
	        this.quizResponseRepository = quizResponseRepository;
	    }

	@Override
	public boolean saveQuestionReponse(Question question) {
		 return quizResponseRepository.saveQuestionReponse(question);
	}

}
