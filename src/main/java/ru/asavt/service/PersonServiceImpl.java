package ru.asavt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.asavt.dao.PersonDao;
import ru.asavt.domain.Person;

@Service("personService")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private final PersonDao dao;

    public PersonServiceImpl(PersonDao dao) {
        this.dao = dao;
    }
    public Person getByName(String name) {
        return dao.findByName(name);
    }
}
