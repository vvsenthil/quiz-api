package com.stepstone.quiz.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class QuestionRequest {
	@NotBlank(message = "Question must be given and should not be blank")
	@NotNull(message = "Question must be given and should not be empty ")
	private String question;
	@NotBlank(message = "Answer must be given and should not be blank")
	@NotNull(message = "Answer must be given and should not be empty ")
	private String answer;
	@NotBlank(message = "quizType must be given and should not be blank")
	@NotNull(message = "quizType must be given and should not be empty ")
	private String quizType ; 

	public QuestionRequest() {
	}

	public QuestionRequest(String question, String ans,String quizType) {
		this.question = question;
		this.answer = ans;
		this.quizType = quizType; 
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuizType() {
		return quizType;
	}

	public void setQuizType(String quizType) {
		this.quizType = quizType;
	}
	
	
}
