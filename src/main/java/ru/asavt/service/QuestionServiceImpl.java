package ru.asavt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.asavt.dao.QuestionDao;
import ru.asavt.domain.Person;
import ru.asavt.domain.Question;
import ru.asavt.localization.Locale;

import java.io.PrintStream;
import java.io.Reader;
import java.util.Scanner;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private final QuestionDao dao;

    @Autowired
    private final Reader in;

    @Autowired
    private final PrintStream out;

    @Autowired
    private final Locale locale;

    public QuestionServiceImpl(QuestionDao dao, Reader in, PrintStream out, Locale locale) {
        this.dao = dao;
        this.in = in;
        this.out = out;
        this.locale = locale;
    }

    private String readLine() {
        Scanner scanner = new Scanner(in);
        return scanner.nextLine();
    }

    @Override
    public void run() {
        out.println(locale.message("greeting"));
        Person person = new Person(readLine(), 18);

        int score = 0;

        for (Question question : dao.getQuestions()
        ) {
            out.println(question.getQuestion());
            int index = 1;
            for (String variant: question.getVariants()) {
                out.println(index + " - " + variant);
                index++;
            }
            String answer = readLine();
            int answerVariant;
            try {
                answerVariant = Integer.parseInt(answer);
            } catch (NumberFormatException e) {
                out.println(locale.message("incorrectInput"));
                continue;
            }
            if (answerVariant == question.getRightAnswer()) {
                score++;
            }
        }
        person.setResult(score);
        out.println(locale.message("total", new String[] {person.getName(), "" + score}));

    }
}
