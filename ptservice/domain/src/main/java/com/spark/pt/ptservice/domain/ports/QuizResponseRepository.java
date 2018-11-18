package com.spark.pt.ptservice.domain.ports;

import com.spark.pt.ptservice.domain.models.Question;

public interface QuizResponseRepository {

		 boolean saveQuestionReponse(Question question);
}
