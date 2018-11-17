package com.spark.pt.ptservice.domain.serviceadapters;

import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;

import com.spark.pt.ptservice.domain.ports.QuestionRepository;

public class GetQuestionServiceAdapterTest {
	
	@Mock
	private   QuestionRepository questionRepository ;
	
	@InjectMocks
	private GetQuestionServiceAdapter getQuestionServiceAdapter;
	
	
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
	@Test
	public void getAllQuestions_callTheQuestionsRepository(){
		when(questionRepository.getAllQuestion()).thenReturn(Collections.emptyList());
		
		getQuestionServiceAdapter.getAllQuestion();
		verify(questionRepository). getAllQuestion();
	}
	
	
	
}
