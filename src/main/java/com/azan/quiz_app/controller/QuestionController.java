package com.azan.quiz_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azan.quiz_app.entity.Question;
import com.azan.quiz_app.service.QuestionService;

@RestController
@RequestMapping("api/question")
public class QuestionController {

  @Autowired
  QuestionService questionService;

  @GetMapping("allQuestions")
  public ResponseEntity<List<Question>> getAllQuestions() {
    return questionService.getAllQuestions();
  }

  @PostMapping("addQuestions")
  public ResponseEntity<List<Question>> createQuestions(@RequestBody List<Question> questions) {
    // List<Question> returnedQuestions =
    // questionService.createQuestions(questions);

    return questionService.createQuestions(questions);
  }

  @PostMapping("add")
  public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
    return questionService.addQuestion(question);
  }

  @DeleteMapping("deleteAll") // Delete all
  public ResponseEntity<String> deleteAllQuestions() {
    return questionService.deleteAllQuestions();
  }

  @DeleteMapping("delete/{id}") // Delete a question
  public ResponseEntity<String> deleteQuestion(@PathVariable Integer id) {

    return questionService.deleteQuestion(id);
  }

  @GetMapping("category/{category}")
  public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {

    return questionService.getQuestionsByCategory(category);
  }
}
