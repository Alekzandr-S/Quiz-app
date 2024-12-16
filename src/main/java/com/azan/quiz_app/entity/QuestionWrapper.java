package com.azan.quiz_app.entity;

import lombok.Data;

// @Entity
@Data
public class QuestionWrapper {

  private long id;
  private String questionTitle;
  private String option1;
  private String option2;
  private String option3;
  private String option4;

  public QuestionWrapper(long id, String questionTitle2, String option1, String option2, String option3,
      String option4) {
    this.id = id;
    this.questionTitle = questionTitle2;
    this.option1 = option1;
    this.option2 = option2;
    this.option3 = option3;
    this.option4 = option4;
  }
}
