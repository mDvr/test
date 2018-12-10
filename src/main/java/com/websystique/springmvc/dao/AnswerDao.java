package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Answer;
import com.websystique.springmvc.model.Question;
import com.websystique.springmvc.model.User;

public interface AnswerDao {
	
	Answer findById(int answerId);
	
	void add(Answer answer);
	void delete(int answerId);
	
	List<Answer> findAllAnswers();
	List<Answer> findAllAnswersByUser(User user);
}
