package ru.survey.project.dao;

import ru.survey.project.model.QuestionAndAnswers;

import java.util.List;

public interface ResourceReader {

    List<QuestionAndAnswers> getQuestionList();

    String getDataResource();
}
