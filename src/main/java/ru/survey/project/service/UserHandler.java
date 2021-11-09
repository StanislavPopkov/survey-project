package ru.survey.project.service;


import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.survey.project.localeholder.LocaleHolder;
import ru.survey.project.model.QuestionAndAnswers;
import ru.survey.project.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class UserHandler {

    private final MessageSource messageSource;
    private final LocaleHolder localeHolder;

    public UserHandler(MessageSource messageSource, LocaleHolder localeHolder) {
        this.messageSource = messageSource;
        this.localeHolder = localeHolder;
    }

    public User getUserWithAnswers(List<QuestionAndAnswers> questionList) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(messageSource.getMessage("enter.user.name", null, localeHolder.getLocale()));
            String name = reader.readLine();
            System.out.println(messageSource.getMessage("enter.user.lastName", null, localeHolder.getLocale()));
            String lastName = reader.readLine();
            for (QuestionAndAnswers questionAndAnswers : questionList) {
                System.out.println(questionAndAnswers.getQuestion());
                List<String> answersList = questionAndAnswers.getAnswersList();
                answersList.stream().forEach(System.out::println);
                System.out.println(messageSource.getMessage("choose.number.question", null, localeHolder.getLocale()));
                int userChoice = 0;
                while (true) {
                    try {
                        userChoice = Integer.parseInt(reader.readLine());
                    } catch (NumberFormatException e) {
                    }
                    if (userChoice != 0 && userChoice <= answersList.size()) {
                        break;
                    }
                    System.out.println(messageSource.getMessage("incorrect.number", null, localeHolder.getLocale()));
                    answersList.stream().forEach(System.out::println);

                }
                questionAndAnswers.setUserChoice(userChoice);
            }
            return new User(name, lastName, questionList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
