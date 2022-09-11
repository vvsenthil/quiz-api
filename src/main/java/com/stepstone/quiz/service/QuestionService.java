package com.stepstone.quiz.service;

import java.util.List;

import com.stepstone.quiz.dto.QuestionRequest;
import com.stepstone.quiz.dto.QuestionResponse;

public interface QuestionService {
	List<QuestionResponse> getAll();

	QuestionResponse addQuestion(QuestionRequest request);

	QuestionResponse validateAnswer(String answer);
	
	List<QuestionResponse> getQuestionsByQuizType(String quizType);
}
