package com.spark.pt.ptservice.api;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.spark.pt.ptservice.api.controllers.QuestionAPIController;
import com.spark.pt.ptservice.domain.ports.GetQuestionService;

public class QuestionAPIControllerTest {

	 	@Mock
	    private GetQuestionService getQuestionServiceMock;

	    

	    @InjectMocks
	    private QuestionAPIController controller;
	 @Before
	    public void setup() {
	        MockitoAnnotations.initMocks(this);
	    }

	 
	 @Test
	    public void getAllQuestions_callsTheGetQuestuionService() {
	        when(getQuestionServiceMock.getAllQuestion()).thenReturn(Collections.emptyList());

	        controller.getQuestions();

	        verify(getQuestionServiceMock).getAllQuestion();
	    }
}
