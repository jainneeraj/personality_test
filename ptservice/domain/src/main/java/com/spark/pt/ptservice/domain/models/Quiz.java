package com.spark.pt.ptservice.domain.models;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Quiz {

	private List<Question> questions ;
	
	
	
}
