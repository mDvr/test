package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.websystique.springmvc.model.Question;
import com.websystique.springmvc.model.User;

public class QuestionDaoImpl extends AbstractDao<Integer, Question> 
		implements QuestionDao {
	
	@Override
	public Question findById(int questionId) {
		return getByKey(questionId);
	}
	
	@Override
	public Question findByTxt(String txt) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("questionTxt", txt));
		
		return (Question) crit.uniqueResult();
	}
	
	@Override
	public void add(Question question) {
		persist(question);
	}
	
	@Override
	public void delete(int questionId) {
		Question question = findById(questionId);
		delete(question);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Question> findAllQuestions() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Question> questions = (List<Question>) criteria.list();
		
		return questions;
	}
}
