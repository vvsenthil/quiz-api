package com.stepstone.quiz.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stepstone.quiz.dto.QuestionRequest;
import com.stepstone.quiz.dto.QuestionResponse;
import com.stepstone.quiz.exception.QuizException;
import com.stepstone.quiz.service.QuestionService;

/**
 * Question Controller class
 */
@RestController
public class QuestionController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private QuestionService service;
	
	/*
	 * This Api is to get all the questions for a given quiz_type.          
	 */
	@GetMapping(value = "/questions/quiz/{quizType}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getQuestionsByQuizType(@PathVariable("quizType") String quizType) throws QuizException {
		logger.debug("Called QuestionController.getQuestionsByQuizType ");
		List<QuestionResponse> questions = service.getQuestionsByQuizType(quizType);
		if (questions.size() < 1) {
			logger.error("No Questions found for the this "+quizType+" quiz type!");
			throw new QuizException("No Questions found for the "+quizType+" quiz type!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(questions, HttpStatus.OK);
	}
	
	/*
	 * This Api is to validate the answer entered by the user      
	 */
	@GetMapping(value = "/questions/validate/{answer}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> validateAnswer(@PathVariable("answer") String answer) throws QuizException {
		logger.debug("Called QuestionController.validateAnswer ");
		QuestionResponse response = service.validateAnswer(answer);
		if (response != null)
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		else {
			logger.error("The given Answer is not correct, Please enter correct Answer !!!");
			throw new QuizException("The given Answer is not correct, Please enter correct Answer !!!",
					HttpStatus.BAD_REQUEST);
		}
	}

	/*
	 * This Api is to get all the questions available in the database        
	 */
	@GetMapping(value = "/questions", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getAll() throws QuizException {
		logger.debug("Called QuestionController.getAll ");
		List<QuestionResponse> questions = service.getAll();
		if (questions.size() < 1) {
			logger.error("No Questions found!");
			throw new QuizException("No Questions found!", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Object>(questions, HttpStatus.OK);
	}
	
	/*
	 * This Api is to add new question into the database        
	 */
	@PostMapping(value = "/questions/add", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> addQuestion(@RequestBody @Valid QuestionRequest request) {
		logger.debug("Called QuestionController.addQuestion");
		QuestionResponse response = service.addQuestion(request);
		if (response != null)
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		else {
			logger.error("There is no question found in the database !!!");
			throw new QuizException("There is no question found in the database !!!",
					HttpStatus.BAD_REQUEST);
		}
	}
}
