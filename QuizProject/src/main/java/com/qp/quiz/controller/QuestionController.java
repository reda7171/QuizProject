package com.qp.quiz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qp.quiz.model.Question;
import com.qp.quiz.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	
	@Autowired
	private QuestionService questionService;
	
	
	@GetMapping("allquestions")
	public List<Question> getAllQuestions() {
		
		
		return questionService.getAllQuestions();
		
	}
	
	@GetMapping("firstfive")
	public List<Question> getFistFiveQuestion(){
		return questionService.getFiveFirstQuestions();
	}
	
	
	@GetMapping("count")
	public Long getCountQuestions()
	{
		return questionService.getCountQuestion();
	}
	
	
	@GetMapping("{id}")
	public Optional<Question> getQuestion(@PathVariable Integer id) {
		return questionService.getOneQuestion(id);
		
	}
	
	@GetMapping("CorrectAnswer/{id}")
	public String getCorrectAnswerOfQuestion(@PathVariable Integer id) {
		return questionService.getCorrectAnswerOfQuestion(id);
		
	}

	@GetMapping("details/{id}")
	public String getAllQuestionByQuestion(@PathVariable Integer id) {
		return questionService.getAllQuestionByQuestion(id);
	}
	
	@GetMapping("allwithoptions/{to}")
	public String getAllQuestionWithOptions(@PathVariable Integer to) {
		return questionService.getAllQuestionWithOptions(to);
	}
}
