package com.spark.pt.ptservice.domain.models;

import java.util.List;

import lombok.Data;

@Data
public class QuestionType {

	private String type;
	private List<String> options;
	
	
}
