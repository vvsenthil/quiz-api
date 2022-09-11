package com.stepstone.quiz;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.stepstone.quiz.dto.QuestionRequest;
import com.stepstone.quiz.service.QuestionService;

@SpringBootApplication
public class QuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}

	@Bean
	CommandLineRunner run(QuestionService questionService) {
		return args -> {
			questionService.addQuestion(new QuestionRequest("What is the capital of Cuba?", "Cuba","Science"));
			questionService.addQuestion(new QuestionRequest("What is the capital of France?", "Paris","Science"));
			questionService.addQuestion(new QuestionRequest("What is the capital of Poland?", "Poland","Geography"));
			questionService.addQuestion(new QuestionRequest("What is the capital of Germany?", "Germany","Geography"));
		};
	}
}
