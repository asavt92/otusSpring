package ru.asavt.service;

import org.springframework.context.annotation.Bean;
import ru.asavt.dao.PersonDao;
import ru.asavt.domain.Person;

public class PersonServiceImpl implements PersonService {

    private final PersonDao dao;

    public PersonServiceImpl(PersonDao dao) {
        this.dao = dao;
    }

    public Person getByName(String name) {
        return dao.findByName(name);
    }
}
