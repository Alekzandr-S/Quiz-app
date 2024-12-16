package com.azan.quiz_app.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import com.azan.quiz_app.entity.Question;

import java.util.List;

@Repository
public class QuestionDaoImpl {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Question> getRandomQuestionByCategory(String category, int numQ) {
        String sql = "SELECT * FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT " + numQ;
        Query nativeQuery = entityManager.createNativeQuery(sql, Question.class);
        nativeQuery.setParameter("category", category);

        return nativeQuery.getResultList();
    }
}
