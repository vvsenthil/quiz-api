package com.totaljobsgroup.quiz.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests for Question Controller
 */
@WebMvcTest(QuestionController.class)
public class QuestionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getQuestions() throws Exception {
        // given
        String urlPath = "/questions";

        //when
        ResultActions result = mockMvc.perform(get(urlPath));

        // then
        result.andExpect(status().isOk());
    }

}
