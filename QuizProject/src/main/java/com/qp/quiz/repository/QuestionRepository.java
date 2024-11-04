package com.qp.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qp.quiz.model.Question;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
	
	
	public List<Question> findByCategory(String category);
	
	
	@Query("SELECT QS FROM Question QS WHERE QS.difficulty_level = :difficultyLevel")
	public List<Question> findByDifficultyLevel(@Param("difficultyLevel") String difficultyLevel);

}
