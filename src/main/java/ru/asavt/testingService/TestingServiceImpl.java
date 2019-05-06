package ru.asavt.testingService;

import ru.asavt.quetionService.Question;
import ru.asavt.quetionService.QuestionService;

import java.util.ArrayList;
import java.util.Scanner;

public class TestingServiceImpl implements TestingService {

    private int score;
    private String result = null;
    private final QuestionService questionService;

    public TestingServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
        score = 0;
    }

    @Override
    public void exam() {
        ArrayList<Question> questions = questionService.getQuestions();
        Scanner scanner = new Scanner(System.in);


        System.out.println("Hello lets tests");
        for (Question q:questions) {
            System.out.println(q.getQuestion());
            String a = scanner.next();
            if(a.equals(q.getAnswer())){
                score+=1;
                System.out.println("ok!");
            } else {
                System.out.println("wrong! true answer : " + q.getAnswer());
            }
        }

        result = (score > 0) ? "good" : "bad";
        System.out.println("ok, its all. your result : " + result);
    }

    @Override
    public String getResult() {
        return result;
    }
}
