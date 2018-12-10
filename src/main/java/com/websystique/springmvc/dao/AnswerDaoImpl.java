package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.websystique.springmvc.model.Answer;
import com.websystique.springmvc.model.User;

public class AnswerDaoImpl extends AbstractDao<Integer, Answer> 
		implements AnswerDao {

	@Override
	public Answer findById(int answerId) {
		return getByKey(answerId);
	}
	
	@Override
	public void add(Answer answer) {
		persist(answer);
	}
	
	@Override
	public void delete(int answerId) {
		Answer answer = findById(answerId);
		delete(answer);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Answer> findAllAnswers() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Answer> answers = (List<Answer>) criteria.list();
		
		return answers;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Answer> findAllAnswersByUser(User user) {
		Criteria criteria = createEntityCriteria()
				.add(Restrictions.eq("userId", user.getId())).addOrder(Order.asc("id"));
		
		List<Answer> answers = (List<Answer>) criteria.list();
		
		return answers;
	}
}
