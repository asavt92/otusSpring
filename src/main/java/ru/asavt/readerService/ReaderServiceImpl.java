package ru.asavt.readerService;

import ru.asavt.quetionService.Question;

import java.io.*;
import java.util.ArrayList;

public class ReaderServiceImpl implements ReaderService {

    private final String path;
    private final String COMMA_DELIMITER = ";";

    public ReaderServiceImpl(String path) {
        this.path = path;
    }

    @Override
    public ArrayList<Question> readQuestions()  {

        ArrayList<Question> questions = new ArrayList<>();

        try {
            File file = new File(
                    getClass().getClassLoader().getResource(path).getFile()
            );

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(COMMA_DELIMITER);
                    questions.add(new Question(values[0],values[1]));
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return questions;
    }
}
