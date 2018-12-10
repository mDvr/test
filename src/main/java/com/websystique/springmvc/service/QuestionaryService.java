package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Answer;
import com.websystique.springmvc.model.Question;
import com.websystique.springmvc.model.User;

public interface QuestionaryService {
	
	Question findQuestionById(int questionId);
	Question findQuestionByTxt(String txt);
	
	void addQuestion(Question question);
	void deleteQuestion(int questionId);
	
	List<Answer> getAllAnswersByUserName(String userName);
	
	void answerAllQUestions(List<Answer> answers);
	List<User> findAllPersonsByPercentOfEmptyAnswersAndWordCount(int percent, int wordCount);
}
