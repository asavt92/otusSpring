package ru.asavt.dao;

import ru.asavt.domain.Question;

public interface QuestionDao {

    Iterable<? extends Question> getQuestions();
}
