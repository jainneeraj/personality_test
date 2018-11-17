package com.spark.pt.ptservice.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spark.pt.ptservice.database.repositoryadapters.QuestionRepositoryAdapter;
import com.spark.pt.ptservice.domain.ports.GetQuestionService;
import com.spark.pt.ptservice.domain.ports.QuestionRepository;
import com.spark.pt.ptservice.domain.serviceadapters.GetQuestionServiceAdapter;

@Configuration
public class ApplicationConfiguration {
	
	@Bean
    public GetQuestionService getQuestionService(QuestionRepository questionRepository) {
        return new GetQuestionServiceAdapter(questionRepository);
    }
	
	@Bean
    public QuestionRepository questionRepository() {

		
		return new QuestionRepositoryAdapter();
	
	}


	 
}
