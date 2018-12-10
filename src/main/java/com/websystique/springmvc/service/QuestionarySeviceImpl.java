package com.websystique.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.AnswerDao;
import com.websystique.springmvc.dao.QuestionDao;
import com.websystique.springmvc.dao.UserDao;
import com.websystique.springmvc.model.Answer;
import com.websystique.springmvc.model.Question;
import com.websystique.springmvc.model.User;

@Service("questionaryService")
@Transactional
public class QuestionarySeviceImpl implements QuestionaryService {
	
	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
	private AnswerDao answerDao;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public Question findQuestionById(int questionId) {
		return questionDao.findById(questionId);
	}
	
	@Override
	public Question findQuestionByTxt(String txt) {
		return questionDao.findByTxt(txt);
	}
	
	@Override
	public void addQuestion(Question question) {
		questionDao.add(question);
	}
	
	@Override
	public void deleteQuestion(int questionId) {
		questionDao.delete(questionId);
	}
	
	@Override
	public List<Answer> getAllAnswersByUserName(String userName) {
		User user = userDao.findBySSO(userName);
		return answerDao.findAllAnswersByUser(user);
	}
	
	@Override
	public void answerAllQUestions(List<Answer> answers) {
		for (Answer answer : answers) {
			answerDao.add(answer);
		}
	}
	
	@Override
	public List<User> findAllPersonsByPercentOfEmptyAnswersAndWordCount(int percent, 
			int wordCount) {
		List<User> allUsers = userDao.findAllUsers();
		List<User> result = new ArrayList<>();
		
		for (User user : allUsers) {
			List<Answer> answers = answerDao.findAllAnswersByUser(user);
			
			int counter = 0;
			
			for (Answer answer : answers) {
				if (answer.getAnswerTxt() != null
						&& !answer.getAnswerTxt().isEmpty()
						&& answer.getAnswerTxt().split(" +").length >= wordCount) {
					counter++;
				}	
			}
			
			if (counter / answers.size() >= percent) {
				result.add(user);
			}	
		}
		
		return result;
	}

}
