package com.spark.pt.ptservice.domain.serviceadapters;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.spark.pt.ptservice.domain.models.Category;
import com.spark.pt.ptservice.domain.models.Question;
import com.spark.pt.ptservice.domain.models.QuestionType;
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
	@Test
    public void getAllQuestions_whenThereAreSavedQuestions_returnsAPopulatedListOfQuestions() {
		QuestionType  question_type = new QuestionType();
		question_type.setType("single_choice");
		List<String> options = new ArrayList<String>();
		options.add("male");
		options.add("female");
		options.add("other");
		question_type.setOptions(options);
        Question q1 = Question.builder().category(Category.hard_fact).question("What is your gender?").question_type(question_type).build();
       
        List<Question> savedQuestions = new ArrayList<Question>();
        savedQuestions.add(q1);
        when(questionRepository.getAllQuestion()).thenReturn(savedQuestions);

        List<Question> returnedListOfQuestions = getQuestionServiceAdapter.getAllQuestion();

        assertTrue(returnedListOfQuestions.size() == 1);
        assertEquals(returnedListOfQuestions, savedQuestions);

        verify(questionRepository).getAllQuestion();
       
    }

	
	
}
