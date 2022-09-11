package com.stepstone.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stepstone.quiz.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
	Question findByAnswer(String answer);
	List<Question> findByQuizType(String quizType);
}
