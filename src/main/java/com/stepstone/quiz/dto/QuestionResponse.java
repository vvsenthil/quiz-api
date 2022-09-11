package com.stepstone.quiz.dto;

public class QuestionResponse {

	private String question;
	private String answer;
	private String quizType ; 
	
	public QuestionResponse() {
	}

	public QuestionResponse(String question) {
		this.question = question;
	}

	public QuestionResponse(String question, String ans,String quizType) {
		this.question = question;
		this.answer = ans;
		this.setQuizType(quizType); 
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
