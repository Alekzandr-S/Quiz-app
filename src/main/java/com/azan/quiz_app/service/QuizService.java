package com.azan.quiz_app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

// import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.azan.quiz_app.dao.QuizDao;
import com.azan.quiz_app.dao.impl.QuestionDaoImpl;
import com.azan.quiz_app.entity.Answers;
import com.azan.quiz_app.entity.Question;
import com.azan.quiz_app.entity.QuestionWrapper;
// import com.azan.quiz_app.entity.Question;
import com.azan.quiz_app.entity.Quiz;

@Service
public class QuizService {

  @Autowired
  QuizDao quizDao;
  @Autowired
  QuestionDaoImpl questionDaoImpl;

  public ResponseEntity<String> createQuiz(String category, Integer numQ, String title) {
    try {
      Quiz quiz = new Quiz();
      List<Question> questions = questionDaoImpl.getRandomQuestionByCategory(category,
          numQ);

      quiz.setTitle(title);
      quiz.setQuestions(questions);

      quizDao.save(quiz);

      return new ResponseEntity<>("Quiz created successfully", HttpStatus.CREATED);

    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity<>("Could not create quiz", HttpStatus.BAD_REQUEST);
  }

  public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer quizID) {
    Optional<Quiz> quiz = quizDao.findById(quizID);
    List<Question> questionsFromDb = quiz.get().getQuestions();

    List<QuestionWrapper> questions = new ArrayList<>();
    for (int i = 0; i < questionsFromDb.size(); i++) {
      QuestionWrapper qw = new QuestionWrapper(
          questionsFromDb.get(i).getId(),
          questionsFromDb.get(i).getQuestionTitle(),
          questionsFromDb.get(i).getOption1(),
          questionsFromDb.get(i).getOption2(),
          questionsFromDb.get(i).getOption3(),
          questionsFromDb.get(i).getOption4());
      questions.add(qw);
    }

    return new ResponseEntity<>(questions, HttpStatus.OK);
  }

  public ResponseEntity<String> getQuizScore(Integer id, List<Answers> answers) {
    Optional<Quiz> quiz = quizDao.findById(id);
    List<Question> questions = quiz.get().getQuestions();

    int marks = 0;

    for (Question qw : questions) {
      String righAnswer = qw.getRightAnswer();
      int righAnswerId = qw.getId();

      for (Answers studAnswers : answers) {
        String studentAnswer = studAnswers.getAnswer();
        int studentAnswerId = studAnswers.getId();

        if (righAnswerId == studentAnswerId && righAnswer.toLowerCase().equals(studentAnswer.toLowerCase())) {
          marks++;
        }
      }
    }
    return new ResponseEntity<>("Score: " + marks + "/4", HttpStatus.OK);

  }

}
