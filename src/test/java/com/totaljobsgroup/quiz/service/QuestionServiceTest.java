package com.totaljobsgroup.quiz.service;

import com.totaljobsgroup.quiz.repository.QuestionRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

/**
 * Tests for Question Service
 */
public class QuestionServiceTest {

    @Test
    public void findAll_should_return_questions(){
        // given
        QuestionRepository mockQuestionRepository = mock(QuestionRepository.class);
        BasicQuestionService questionService = new BasicQuestionService(mockQuestionRepository);

        // when
        List<String> questions = questionService.getQuestions();

        // then
        assertNotNull(questions);
    }
}
