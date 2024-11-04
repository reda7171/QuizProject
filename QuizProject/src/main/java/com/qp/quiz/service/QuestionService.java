package com.qp.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qp.quiz.model.Question;
import com.qp.quiz.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	public ResponseEntity<List<Question>> getAllQuestions() {
		
		try {
			return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
		}
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
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

		String correct;
		correct = "the correct answer is : \n " + "<ul><li>" +

				questionRepository.findAll().get(id).getRight_answer() + "</li></ul>";

		return correct;

	}

	public String getAllQuestionByQuestion(int id) {

		String question = questionRepository.findAll().get(id).getQuestion_title();
		String correctAnswer = questionRepository.findAll().get(id).getRight_answer();
		String option = "<ol><li>" + questionRepository.findAll().get(id).getOption1() + "</li>" + "<li>"
				+ questionRepository.findAll().get(id).getOption2() + "</li>" + "<li>"
				+ questionRepository.findAll().get(id).getOption3() + "</li>" + "<li>"
				+ questionRepository.findAll().get(id).getOption4() + "</li></ol>";

		return "Question : "+question+"\n"+ option + "\n" + "The Correct Answer is : " + correctAnswer;
	}

	
	
	public String getAllQuestionWithOptions(Integer to) {

		StringBuilder bld = new StringBuilder();
		String question;
		String correctAnswer;
		String option;
		
		
		
		for(int i =0; i<= to ;i++) {
		question = questionRepository.findAll().get(i).getQuestion_title();
		correctAnswer = questionRepository.findAll().get(i).getRight_answer();
		option = "<ol><li>" + questionRepository.findAll().get(i).getOption1() + "</li>" + "<li>"
				+ questionRepository.findAll().get(i).getOption2() + "</li>" + "<li>"
				+ questionRepository.findAll().get(i).getOption3() + "</li>" + "<li>"
				+ questionRepository.findAll().get(i).getOption4() + "</li></ol>";
		 
		bld.append("\nQuestion : ")
			.append(question)
			.append("\n")	
			.append(option)
			.append("\n")
			.append("The Correct Answer is : ")
			.append(correctAnswer);
		
		System.out.println("###############################################"+i);
		
		}
		return bld.toString();
		
	}

	public List<Question> getQuestionByCategory(String categoryname) {
		return questionRepository.findAll().stream().filter(cat -> cat.getCategory().equalsIgnoreCase(categoryname)).collect(Collectors.toList());
	}

	public List<Question> findByCategory(String categoryname) {
		return questionRepository.findByCategory(categoryname);
	}

	public ResponseEntity<String> addQuestion(Question q) {
		questionRepository.save(q);
		return new 
				ResponseEntity<>("Well Added",HttpStatus.CREATED);
	}

	
	 
	
}
