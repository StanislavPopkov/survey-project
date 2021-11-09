package ru.survey.project;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import ru.survey.project.dao.ResourceReader;
import ru.survey.project.localeholder.LocaleHolder;
import ru.survey.project.model.User;
import ru.survey.project.service.ResultOutService;
import ru.survey.project.service.UserHandler;
import ru.survey.project.model.QuestionAndAnswers;

import java.util.List;


@Configuration
@ComponentScan
@PropertySource("classpath:config.properties")
@EnableAspectJAutoProxy
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        ResourceReader reader = context.getBean(ResourceReader.class);
        UserHandler handler = context.getBean(UserHandler.class);
        ResultOutService resultOutService = context.getBean(ResultOutService.class);
        LocaleHolder localeHolder = context.getBean(LocaleHolder.class);

        List<QuestionAndAnswers> questionList = reader.getQuestionList();
        User userWithAnswers = handler.getUserWithAnswers(questionList);
        System.out.println(resultOutService.getUserInfo(userWithAnswers));

        localeHolder.setLocale("ru");
        userWithAnswers = handler.getUserWithAnswers(questionList);
        System.out.println(resultOutService.getUserInfo(userWithAnswers));

    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
