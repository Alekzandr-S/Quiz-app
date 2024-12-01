package com.azan.quiz_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
  public List<Question> getAllQuestions() {
    return questionService.getAllQuestions();
  }

  @PostMapping("addQuestions")
  public List<Question> createQuestions(@RequestBody List<Question> questions) {
    List<Question> returnedQuestions = questionService.createQuestions(questions);
    return returnedQuestions;
  }

  @DeleteMapping("deleteAll")
  public void deleteAllQuestions() {
    questionService.deleteAllQuestions();
  }

  @GetMapping("category/{category}")
  public List<Question> getQuestionsByCategory(@PathVariable String category) {

    return questionService.getQuestionsByCategory(category);
  }
}
