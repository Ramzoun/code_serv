package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.QuestionRepository;
import com.luv2code.springboot.cruddemo.entity.Question;

@Service
public class QuestionServiceImpl implements QuestionService {

	private QuestionRepository questionRepository;

	@Autowired
	public QuestionServiceImpl(QuestionRepository theQuestionRepository) {
		questionRepository = theQuestionRepository;
	}

	@Override
	public Question findById(int theId) {
		Optional<Question> result = questionRepository.findById(theId);

		Question theQuestion = null;

		if (result.isPresent()) {
			theQuestion = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}

		return theQuestion;
	}

	/*
	 * @Override public List<Question> findByCathegory(int examId) { List<Question>
	 * result = questionRepository.findQuestionByCathegory(examId);
	 * 
	 * return result; }
	 */
	
	@Override
	public List<Question> findByCathegoryPage(int idCath, int page) {
		Pageable pageWithTenElements = PageRequest.of(page - 1, 10);
		List<Question> result = questionRepository.findQuestionByCathegoryPagination(idCath, pageWithTenElements);

		return result;
	}

}
