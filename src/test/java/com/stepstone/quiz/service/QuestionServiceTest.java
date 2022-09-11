package com.stepstone.quiz.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionServiceTest {

	@Autowired
	private QuestionService questionService;

	@Test
	public void getAll_should_return_questions() {
		final var questions = questionService.getAll();
		assertThat(questions, is(notNullValue()));
	}
}
