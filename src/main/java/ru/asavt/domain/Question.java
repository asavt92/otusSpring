package ru.asavt.domain;

import lombok.Data;

import java.util.List;

@Data
public class Question {

    private final String question;
    private final int rightAnswer;
    private final String[] variants;

    public Question(String question, int rightAnswer, String[] variants) {
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.variants = variants;
    }
}
