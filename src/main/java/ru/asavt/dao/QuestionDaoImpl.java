package ru.asavt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.asavt.domain.Question;
import ru.asavt.persistence.DataLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component("questionDao")
public class QuestionDaoImpl implements QuestionDao {

    @Autowired
    private final DataLoader dataLoader;

    private final List<Question> questions;

    public QuestionDaoImpl(DataLoader dataLoader) {
        this.dataLoader = dataLoader;
        questions = new ArrayList<>();

        String[] row;
        while ((row = dataLoader.getNext()) != null) {
            questions.add(
                    new Question(row[0], Integer.parseInt(row[1].trim()), Arrays.copyOfRange(row, 2, row.length))
            );
        }
    }


    @Override
    public Iterable<? extends Question> getQuestions() {
        return questions;
    }
}
