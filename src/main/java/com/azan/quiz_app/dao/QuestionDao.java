package com.azan.quiz_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azan.quiz_app.entity.Question;
import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

  List<Question> findByCategory(String category);
}
