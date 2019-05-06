package ru.asavt.quetionService;

import java.util.ArrayList;

public class QuestionServiceImpl implements QuestionService {

    private ArrayList<Question> questions;

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }


    @Override
    public ArrayList<Question> getQuestions() {
        return questions;
    }
}
