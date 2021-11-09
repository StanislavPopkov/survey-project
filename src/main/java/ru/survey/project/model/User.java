package ru.survey.project.model;


import java.util.List;

public class User {

    private String name;
    private String lastName;
    private List<QuestionAndAnswers>questionList;

    public User(String name, String lastName, List<QuestionAndAnswers> questionList) {
        this.name = name;
        this.lastName = lastName;
        this.questionList = questionList;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public List<QuestionAndAnswers> getQuestionList() {
        return questionList;
    }
}
