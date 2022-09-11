package com.stepstone.quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = "Question must be given and should not be empty ")
	@Column(name = "question", unique = true, nullable = false)
	private String question;

	@NotNull(message = "Answer must be given and should not be empty ")
	private String answer;
	
	@NotNull(message = "quizType must be given and should not be empty ")
	private String quizType;

	public String getQuizType() {
		return quizType;
	}

	public void setQuizType(String quizType) {
		this.quizType = quizType;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Question() {
	}

	public Question(String question, String ans,String quizType) {
		this.question = question;
		this.answer = ans;
		this.quizType = quizType; 
	}

}
