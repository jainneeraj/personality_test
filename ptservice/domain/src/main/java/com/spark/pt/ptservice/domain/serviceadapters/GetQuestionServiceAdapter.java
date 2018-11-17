package com.spark.pt.ptservice.domain.serviceadapters;

import java.util.List;
import java.util.Optional;

import com.spark.pt.ptservice.domain.models.Question;
import com.spark.pt.ptservice.domain.ports.GetQuestionService;
import com.spark.pt.ptservice.domain.ports.QuestionRepository;

public class GetQuestionServiceAdapter implements GetQuestionService {
	
	private QuestionRepository questionRepository ;
	
	
	 public GetQuestionServiceAdapter(QuestionRepository questionRepository) {
	        this.questionRepository = questionRepository;
	    }


	@Override
	public List<Question> getAllQuestion() {
		// TODO Auto-generated method stub
		return questionRepository.getAllQuestion();
	}

	@Override
	public Optional<Question> getAllQuestion(String category) {
		// TODO Auto-generated method stub
		return questionRepository.getAllQuestion(category);
	}

}
