package com.spark.pt.ptservice.database.repositoryadapters;

import java.util.Date;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spark.pt.ptservice.domain.models.Question;
import com.spark.pt.ptservice.domain.ports.QuizResponseRepository;

@Repository
public class QuizResponseRepositoryAdapter implements QuizResponseRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public boolean saveQuestionReponse(Question question) {
		  		  Object[] params = new Object[] { question.getId(), question.getAnswer(),"Q101","neeraj@gmail.com", new Date() };
		          int[] types = new int[] { Types.INTEGER, Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.TIMESTAMP };
 		          String insertSql = "INSERT INTO pt_user_response (" + " question_id, " + " answer, " + " quiz_id, " +"user_id,"+ " date) " + "VALUES (?, ?, ?, ?,?)";
		          int row = jdbcTemplate.update(insertSql, params, types);
		          return row==1?true:false;

	}

}
