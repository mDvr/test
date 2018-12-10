package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Question;
import com.websystique.springmvc.model.User;

public interface QuestionDao {
	
	Question findById(int questionId);
	Question findByTxt(String txt);
	
	void add(Question question);
	void delete(int questionId);
	
	List<Question> findAllQuestions();
}
