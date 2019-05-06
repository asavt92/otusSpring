package ru.asavt.dao;

import org.springframework.context.annotation.Bean;
import ru.asavt.domain.Person;
public class PersonDaoSimple implements PersonDao {

    public Person findByName(String name) {
        return new Person(name, 18);
    }
}
