package com.stepstone.quiz.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stepstone.quiz.QuizApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = QuizApplication.class)
public class QuestionRepositoryTest {

	@Autowired
	private QuestionRepository questionRepository;

	@Test
	public void findAll_should_return_questions() {
		final var questions = questionRepository.findAll();
		assertThat(questions, is(notNullValue()));
		assertThat(questions, is(hasSize(4)));

	}
}
