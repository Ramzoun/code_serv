package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.luv2code.springboot.cruddemo.entity.Question;
import com.luv2code.springboot.cruddemo.service.QuestionService;

@RestController
@RequestMapping("/category")
public class QuestionRestController {

private QuestionService questionService;
	
	@Autowired
	public QuestionRestController(QuestionService theQuestionService) {
		questionService = theQuestionService;
	}
	
	
	@GetMapping("/question/{questionId}")
	public Question getQuestion(@PathVariable int questionId) {
		
		Question theQuestion = questionService.findById(questionId);
		
		if (theQuestion == null) {
			throw new RuntimeException("Employee id not found - " + questionId);
		}
		
		return theQuestion;
	}
	
	/*
	@GetMapping("/{cathId}")
	public List<Question> getCath(@PathVariable int cathId) {
		
		List<Question> theQuestion = questionService.findByCathegory(cathId);
		
		if (theQuestion == null) {
			throw new RuntimeException("Employee id not found - " + cathId);
		}
		
		return theQuestion;
	}
	*/
	
	@GetMapping("/{cathId}/{page}")
	public List<Question> getCathPage(@PathVariable int cathId, @PathVariable int page) {
		
		List<Question> theQuestion = questionService.findByCathegoryPage(cathId, page);
		
		if (theQuestion == null) {
			throw new RuntimeException("Employee id not found - " + cathId);
		}
		
		return theQuestion;
	}
	
	@GetMapping("/demo")
	public List<Question> getCathPage() {
		
		List<Question> theQuestion = questionService.findByCathegoryPage(1, 1);
		
		if (theQuestion == null) {
			throw new RuntimeException("demo questions not found - ");
		}
		
		return theQuestion;
	}
	
}
