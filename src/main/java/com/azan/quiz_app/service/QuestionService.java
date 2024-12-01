package com.azan.quiz_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azan.quiz_app.dao.QuestionDao;
import com.azan.quiz_app.entity.Question;

@Service
public class QuestionService {

  @Autowired
  QuestionDao questionDao;

  public List<Question> getAllQuestions() {
    return questionDao.findAll();
  }

  public List<Question> createQuestions(List<Question> questions) {
    List<Question> returnedQuestions = questionDao.saveAll(questions);
    return returnedQuestions;
  }

  public void deleteAllQuestions() {
    questionDao.deleteAll();
  }

  public List<Question> getQuestionsByCategory(String category) {
    return questionDao.findByCategory(category);
  }

}
