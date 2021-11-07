package ru.spring.project;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import ru.spring.project.model.User;
import ru.spring.project.service.handlers.UserHandler;
import ru.spring.project.service.holder.QuestionAndAnswers;
import ru.spring.project.utils.ResourceReader;

import java.util.List;


@Configuration
@ComponentScan
@PropertySource("classpath:config.properties")
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        ResourceReader reader = context.getBean(ResourceReader.class);
        UserHandler handler = context.getBean(UserHandler.class);

        List<QuestionAndAnswers> questionList = reader.getQuestionList();
        User userWithAnswers = handler.getUserWithAnswers(questionList);
        System.out.println(userWithAnswers);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
