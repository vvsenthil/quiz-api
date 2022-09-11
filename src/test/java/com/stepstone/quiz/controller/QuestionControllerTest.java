package com.stepstone.quiz.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.stepstone.quiz.dto.QuestionRequest;
import com.stepstone.quiz.dto.QuestionResponse;

/**
 * Tests for Question Controller
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class QuestionControllerTest {

	@Autowired
	private QuestionController questionController;

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void init() {
		mockMvc = standaloneSetup(questionController).build();
	}

	@Test
	public void getQuestions_should_return_questions() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/questions")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers
						.jsonPath("$[*].answer").value(Lists.newArrayList("Cuba", "Paris", "Poland", "Germany","Delhi")));
	}
	
	@Test
	public void testAddQuestion() throws Exception {
		QuestionRequest request = new QuestionRequest("What is the capital of India?", "Delhi","Science");
		QuestionResponse response = (QuestionResponse) questionController.addQuestion(request).getBody();
		assertEquals("Delhi",response.getAnswer());
	}
	
	@Test
	public void testValidate_Answer() throws Exception {
		QuestionResponse response = (QuestionResponse) questionController.validateAnswer("Paris").getBody();
		assertEquals("Paris",response.getAnswer());
	}
	
	@Test
	public void testValidate_QuizType() throws Exception {
		List<QuestionResponse> response = (List<QuestionResponse>) questionController.getQuestionsByQuizType("Science").getBody();
		assertEquals(3,response.size());
	}
}
