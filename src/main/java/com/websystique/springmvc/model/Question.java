package com.websystique.springmvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="QUESTION")
public class Question implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Column(name="QUESTION_TXT", unique=true, nullable=false)
	private String questionTxt;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getQuestionTxt() {
		return questionTxt;
	}
	
	public void setQuestionTxt(String questionTxt) {
		this.questionTxt = questionTxt;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((questionTxt == null) ? 0 : questionTxt.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Question))
			return false;
		Question other = (Question) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (questionTxt == null) {
			if (other.questionTxt != null)
				return false;
		} else if (!questionTxt.equals(other.questionTxt))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", questionTxt=" + questionTxt + "]";
	}
}
