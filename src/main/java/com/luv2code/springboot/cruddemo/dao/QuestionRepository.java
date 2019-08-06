package com.luv2code.springboot.cruddemo.dao;

import java.util.List;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.luv2code.springboot.cruddemo.entity.Question;

public interface QuestionRepository extends PagingAndSortingRepository<Question, Integer> {

	 @Query("SELECT q FROM Question q WHERE q.qCath = ?1")
	 List<Question> findQuestionByCathegory(Integer idExam);
	 
	 @Query("SELECT q FROM Question q WHERE q.qCath = ?1")
	 List<Question> findQuestionByCathegoryPagination(Integer idCath, Pageable pageable);
}
