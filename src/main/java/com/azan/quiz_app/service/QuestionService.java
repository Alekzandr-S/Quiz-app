package com.azan.quiz_app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.azan.quiz_app.dao.QuestionDao;
import com.azan.quiz_app.entity.Question;

@Service
public class QuestionService {

  @Autowired
  QuestionDao questionDao;

  public ResponseEntity<List<Question>> getAllQuestions() {
    try {
      return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);

    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
  }

  public ResponseEntity<List<Question>> createQuestions(List<Question> questions) {
    // List<Question> returnedQuestions = questionDao.saveAll(questions);
    try {
      return new ResponseEntity<>(questionDao.saveAll(questions), HttpStatus.OK);

    } catch (Exception e) {
      e.printStackTrace();
    }

    return new ResponseEntity<>(new ArrayList<>(), HttpStatus.CREATED);
  }

  public ResponseEntity<Question> addQuestion(Question question) {
    try {
      return new ResponseEntity<>(questionDao.save(question), HttpStatus.CREATED);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return new ResponseEntity<>(new Question(), HttpStatus.NOT_ACCEPTABLE);
  }

  public ResponseEntity<String> deleteAllQuestions() {
    try {

      questionDao.deleteAll();
      return new ResponseEntity<>("Success", HttpStatus.OK);

    } catch (Exception e) {
      e.printStackTrace();
    }

    return new ResponseEntity<>("Could not process your request", HttpStatus.INTERNAL_SERVER_ERROR);
  }

  public ResponseEntity<String> deleteQuestion(Integer id) {
    try {
      questionDao.deleteById(id);
      return new ResponseEntity<>("Success", HttpStatus.OK);

    } catch (Exception e) {
      e.printStackTrace();
    }

    return new ResponseEntity<>("Could not perform deletion", HttpStatus.BAD_REQUEST);

  }

  public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
    try {
      return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);

    } catch (Exception e) {
      e.printStackTrace();
    }

    return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
  }

}
