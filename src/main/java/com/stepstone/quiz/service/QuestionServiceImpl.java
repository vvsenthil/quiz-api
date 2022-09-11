package com.stepstone.quiz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stepstone.quiz.dto.QuestionRequest;
import com.stepstone.quiz.dto.QuestionResponse;
import com.stepstone.quiz.exception.QuizException;
import com.stepstone.quiz.model.Question;
import com.stepstone.quiz.repository.QuestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class QuestionServiceImpl implements QuestionService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private QuestionRepository questionRepository;

	/*
	 * This method is to add new question into the database
	 */
	@Override
	public QuestionResponse addQuestion(QuestionRequest request) {
		logger.debug("Called QuestionServiceImpl.addQuestion() with the question");
		Question quest = questionRepository.save(new Question(request.getQuestion(), request.getAnswer(),request.getQuizType()));
		return new QuestionResponse(quest.getQuestion(), quest.getAnswer(),quest.getQuizType());
	}

	/*
	 * This method is to validate the answer entered by user
	 */
	@Override
	public QuestionResponse validateAnswer(String answer) throws QuizException {
		logger.debug("Called QuestionServiceImpl.validateAnswer() with answer:" + answer);
		Question ans = questionRepository.findByAnswer(answer);
		QuestionResponse response = null;
		if (ans != null) {
			response = new QuestionResponse(ans.getQuestion(), ans.getAnswer(),ans.getQuizType());
		}
		return response;
	}
	
	/*
	 * This method is to retrieve the question and answers from the database          
	 */
	@Override
	public List<QuestionResponse> getAll() {
		List<Question> questions = questionRepository.findAll();
		logger.debug("Called QuestionServiceImpl.validateAnswer() with getAll:" + questions);
		List<QuestionResponse> finalDetails = new ArrayList<QuestionResponse>();
		questions.stream().forEach(x -> {
			finalDetails.add(new QuestionResponse(x.getQuestion(), x.getAnswer(),x.getQuizType()));
		});
		return finalDetails;
	}

	@Override
	public List<QuestionResponse> getQuestionsByQuizType(String quizType) {
		List<Question> questions = questionRepository.findByQuizType(quizType);
		logger.debug("Called QuestionServiceImpl.getQuestionsByQuizType() :" + questions);
		List<QuestionResponse> finalDetails = new ArrayList<QuestionResponse>();
		questions.stream().forEach(x -> {
			finalDetails.add(new QuestionResponse(x.getQuestion(), x.getAnswer(),x.getQuizType()));
		});
		return finalDetails;
	}
}
