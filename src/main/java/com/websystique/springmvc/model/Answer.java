package com.websystique.springmvc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

public class Answer implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@NotEmpty
	@Column(name="QUESTION_ID", nullable=false)
	private Integer questionId;
	
	@NotEmpty
	@Column(name="USER_ID", nullable=false)
	private Integer userId;
	
	@NotEmpty
	@Column(name="ANSWER_TXT", nullable=false)
	private String answerTxt;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getQuestionId() {
		return questionId;
	}
	
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	
	public String getAnswerTxt() {
		return answerTxt;
	}
	
	public void setAnswerTxt(String answerTxt) {
		this.answerTxt = answerTxt;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((answerTxt == null) ? 0 : answerTxt.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Answer))
			return false;
		Answer other = (Answer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (answerTxt == null) {
			if (other.answerTxt != null)
				return false;
		} else if (!answerTxt.equals(other.answerTxt))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Answer [id=" + id + ", answerTxt=" + answerTxt + "]";
	}
}
