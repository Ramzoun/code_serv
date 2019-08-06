package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Question;

public interface QuestionService {
	
	// public List<Question> findByCathegory(int examId);
	
	public List<Question> findByCathegoryPage(int examId, int page);
	
	public Question findById(int theId);
	
	

}
