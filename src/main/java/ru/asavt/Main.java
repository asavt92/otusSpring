package ru.asavt;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.asavt.quetionService.QuestionService;
import ru.asavt.readerService.ReaderService;
import ru.asavt.testingService.TestingService;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/context.xml");

        QuestionService questionService = context.getBean(QuestionService.class);
        questionService.setQuestions(context.getBean(ReaderService.class).readQuestions());

        TestingService testingService = context.getBean(TestingService.class);
        testingService.exam();

    }
}
