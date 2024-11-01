package com.qp.quiz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qp.quiz.model.Question;
import com.qp.quiz.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	public List<Question> getAllQuestions() {
		return questionRepository.findAll();
	}

	public Optional<Question> getOneQuestion(Integer questionid) {
		return questionRepository.findById(questionid);
	}

	public List<Question> getFiveFirstQuestions() {
		return questionRepository.findAll().subList(0, 5);
	}

	public Long getCountQuestion() {
		return questionRepository.count();
	}

	public String getCorrectAnswerOfQuestion(Integer id) {

		String Correct;
		Correct = "the correct answer is : \n " + "<ul><li>" +

				questionRepository.findAll().get(id).getRight_answer() + "</li></ul>";

		return Correct;

	}

	public String getAllQuestionByQuestion(int id) {

		String question = questionRepository.findAll().get(id).getQuestion_title();
		String CorrectAnswer = questionRepository.findAll().get(id).getRight_answer();
		String Option = "<ol><li>" + questionRepository.findAll().get(id).getOption1() + "</li>" + "<li>"
				+ questionRepository.findAll().get(id).getOption2() + "</li>" + "<li>"
				+ questionRepository.findAll().get(id).getOption3() + "</li>" + "<li>"
				+ questionRepository.findAll().get(id).getOption4() + "</li></ol>";

		return "Question : "+question+"\n"+Option + "\n" + "The Correct Answer is : " + CorrectAnswer;
	}

	
	
	public String getAllQuestionWithOptions(Integer to) {

		String allquestion = "";
		String question,CorrectAnswer,Option;
		
		
		for(int i =0; i<= to ;i++) {
		question = questionRepository.findAll().get(i).getQuestion_title();
		 CorrectAnswer = questionRepository.findAll().get(i).getRight_answer();
		 Option = "<ol><li>" + questionRepository.findAll().get(i).getOption1() + "</li>" + "<li>"
				+ questionRepository.findAll().get(i).getOption2() + "</li>" + "<li>"
				+ questionRepository.findAll().get(i).getOption3() + "</li>" + "<li>"
				+ questionRepository.findAll().get(i).getOption4() + "</li></ol>";
		 
		 allquestion = allquestion + "\nQuestion : "+i+question+"\n"+Option + "\n" + "The Correct Answer is : " + CorrectAnswer+"\n";
		
		System.out.println("###############################################"+i);
		
		}
		return allquestion;
		
	}

	
	
}
