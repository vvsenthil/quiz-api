package com.totaljobsgroup.quiz.service;

import com.totaljobsgroup.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Question Service implementation
 */
@Service
public class BasicQuestionService implements QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public BasicQuestionService(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    public List<String> getQuestions() {
        return new ArrayList<>();
    }
}
