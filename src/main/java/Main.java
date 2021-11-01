import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.spring.project.model.User;
import ru.spring.project.service.handlers.UserHandler;
import ru.spring.project.service.holder.QuestionAndAnswers;
import ru.spring.project.utils.ResourceReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        ResourceReader reader = context.getBean(ResourceReader.class);
        UserHandler handler = context.getBean(UserHandler.class);

        List<QuestionAndAnswers> questionList = reader.getQuestionList();
        User userWithAnswers = handler.getUserWithAnswers(questionList);
        System.out.println(userWithAnswers);
    }
}
