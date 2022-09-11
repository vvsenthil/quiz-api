package com.stepstone.quiz.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class QuizExceptionHandler {

	@ExceptionHandler(value = { QuizException.class })
	public ResponseEntity<Object> handleCardException(QuizException e) {
		QuizException quizException = new QuizException(e.getMessage(), e.getHttpStatus());
		return new ResponseEntity<>(quizException.getMessage(), e.getHttpStatus());
	}
}
