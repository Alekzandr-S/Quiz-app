package com.azan.quiz_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azan.quiz_app.entity.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
