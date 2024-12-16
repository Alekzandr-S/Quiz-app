package com.azan.quiz_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.azan.quiz_app.entity.Answers;
import com.azan.quiz_app.entity.QuestionWrapper;
import com.azan.quiz_app.service.QuizService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/quiz")
public class QuizController {

  @Autowired
  QuizService quizService;

  @PostMapping("add")
  public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam Integer numQ,
      @RequestParam String title) {
    return quizService.createQuiz(category, numQ, title);
  }

  @GetMapping("get/{quizID}")
  public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer quizID) {
    return quizService.getQuiz(quizID);
  }

  @GetMapping("answers/{id}")
  public ResponseEntity<String> getQuizScore(@PathVariable Integer id, @RequestBody List<Answers> answers) {
    return quizService.getQuizScore(id, answers);
  }

}
