package ru.spring.project.model;


import ru.spring.project.service.holder.QuestionAndAnswers;

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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", questionList=" + questionList +
                '}';
    }
}
