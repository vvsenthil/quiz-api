package com.totaljobsgroup.quiz.repository;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Tests for Question Repository
 */

public class QuestionRepositoryTest {

    @Test
    public void findAll_should_return_questions(){
        // given
        StaticQuestionRepository questionRepository = new StaticQuestionRepository();

        // when
        List<String> questions = questionRepository.findAll();

        // then
        assertNotNull(questions);
        assertEquals(4, questions.size());
    }
}
