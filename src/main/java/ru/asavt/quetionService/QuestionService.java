package ru.asavt.quetionService;

import java.util.ArrayList;

public interface QuestionService {

    ArrayList<Question> getQuestions();
    void setQuestions(ArrayList<Question> questions);


}
