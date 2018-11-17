package com.spark.pt.ptservice.domain.ports;

import java.util.List;
import java.util.Optional;

import com.spark.pt.ptservice.domain.models.Question;

public interface  QuestionRepository {
	
	List<Question> getAllQuestion();
	
	Optional<Question> getAllQuestion(String category);
	
}
