package com.qp.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qp.quiz.model.Question;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
