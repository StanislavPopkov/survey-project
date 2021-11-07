package ru.spring.project.service.handlers;


import org.springframework.stereotype.Service;
import ru.spring.project.model.User;
import ru.spring.project.service.holder.QuestionAndAnswers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class UserHandler {

    public User getUserWithAnswers(List<QuestionAndAnswers> questionList) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите ваше имя:");
            String name = reader.readLine();
            System.out.println("Введите вашу фамилию:");
            String lastName = reader.readLine();
            for (QuestionAndAnswers questionAndAnswers : questionList) {
                System.out.println(questionAndAnswers.getQuestion());
                List<String> answersList = questionAndAnswers.getAnswersList();
                answersList.stream().forEach(System.out::println);
                System.out.println("Выберете номер ответа");
                int userChoice = 0;
                while (true) {
                    userChoice = Integer.parseInt(reader.readLine());
                    if (userChoice <= answersList.size()) {
                        break;
                    }
                    System.out.println("Вы ввели некорректный номер ответа");
                    System.out.println("Попробуйте еще раз");
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
