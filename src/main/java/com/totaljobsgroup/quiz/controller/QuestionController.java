package com.totaljobsgroup.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Question Controller class
 */
@Controller
public class QuestionController {

    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public String getQuestions(Model model) {
        return "questions";
    }
}

