package ru.survey.project.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.survey.project.localeholder.LocaleHolder;
import ru.survey.project.model.QuestionAndAnswers;
import ru.survey.project.model.User;

import java.util.List;

@Service
public class ResultOutService {

    private final MessageSource messageSource;
    private final LocaleHolder localeHolder;

    public ResultOutService(MessageSource messageSource, LocaleHolder localeHolder) {
        this.messageSource = messageSource;
        this.localeHolder = localeHolder;
    }

    public String getUserInfo(User user) {
        return "User{" +
                "name='" + user.getName() + '\'' +
                ", lastName='" + user.getLastName() + '\'' +
                ", questionList=" + getQuestionInfo(user.getQuestionList()) +
                '}';
    }

    private String getQuestionInfo(List<QuestionAndAnswers> questionList) {
        String questionMessage = messageSource.getMessage("final.question", null, localeHolder.getLocale());
        String answerMessage = messageSource.getMessage("answer.user", null, localeHolder.getLocale());
        StringBuilder sb = new StringBuilder();
        for (QuestionAndAnswers questionAndAnswers : questionList) {
            sb.append(String.format("%s %s %s %s", questionMessage, questionAndAnswers.getQuestion(), answerMessage,
                    questionAndAnswers.getAnswersList().get(questionAndAnswers.getUserChoice() - 1))).append(" ");
        }
        return sb.toString().trim();
    }

}
