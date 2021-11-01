package ru.spring.project.service.holder;

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

    @Override
    public String toString() {
        return String.format("Ответ пользователя на вопрос: %s: %s", question, answersList.get(userChoice - 1));
    }
}
