package com.spark.pt.ptservice.database.repositoryadapters;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spark.pt.ptservice.domain.models.Category;
import com.spark.pt.ptservice.domain.models.Question;
import com.spark.pt.ptservice.domain.ports.QuestionRepository;

@Repository
public class QuestionRepositoryAdapter implements QuestionRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Question> getAllQuestion() {
		List<Question>  questions = jdbcTemplate.query(
			    "SELECT * FROM PT_QUESTIONS  ",
			    new RowMapper<Question>() {
			        public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
			        	Question c =  Question.builder().id(rs.getInt("id")).question(rs.getString("QUESTION_JSON")).category(Category.valueOf(rs.getString("CATEGORY"))).build();
			           
			            return c;
			        }
			    });
		
		
		return questions;
	}

	@Override
	public Optional<Question> getAllQuestion(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
