package ru.survey.project.model;

import java.util.List;

public class QuestionAndAnswers {

    private String question;
    private List<String> answersList;
    private int userChoice;

    public QuestionAndAnswers(String question, List<String> answersList) {
        this.question = question;
        this.answersList = answersList;
    }

    public int getUserChoice() {
        return userChoice;
    }

    public void setUserChoice(int userChoice) {
        this.userChoice = userChoice;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswersList() {
        return answersList;
    }

}
