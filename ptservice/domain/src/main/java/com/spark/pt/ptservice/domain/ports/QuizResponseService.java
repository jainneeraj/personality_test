package com.spark.pt.ptservice.domain.ports;

import com.spark.pt.ptservice.domain.models.Question;

public interface QuizResponseService {

	 boolean saveQuestionReponse(Question question);
	
}
