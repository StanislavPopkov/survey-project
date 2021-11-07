package ru.spring.project.utils;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.spring.project.service.holder.QuestionAndAnswers;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResourceReader {

    private String path;

    public ResourceReader(@Value("${questions.path}")String path) {
        this.path = path;
    }

    public List<QuestionAndAnswers> getQuestionList() {
        try (InputStream resourceAsStream = ResourceReader.class.getClassLoader().getResourceAsStream(path);
             BufferedInputStream buf = new BufferedInputStream(resourceAsStream)) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int readLen = buf.read(buffer);
            while (readLen != -1) {
                bos.write(buffer);
                readLen = buf.read(buffer);
            }
            String questions = bos.toString();
            String[] split1 = questions.split("\\n");
            ArrayList<QuestionAndAnswers> questionAndAnswers = new ArrayList<>();
            for (String questionWithAnswers : split1) {
                String[] split2 = questionWithAnswers.split(";");
                List<String> answersList = Arrays.stream(split2).skip(1).map(String::trim).collect(Collectors.toList());
                questionAndAnswers.add(new QuestionAndAnswers(split2[0], answersList));

            }
            return questionAndAnswers;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
