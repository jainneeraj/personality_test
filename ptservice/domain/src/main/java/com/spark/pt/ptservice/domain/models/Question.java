package com.spark.pt.ptservice.domain.models;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class Question {

	private String question ;
	private int id;
	private Category category ;
	private QuestionType question_type;
	
	
}
