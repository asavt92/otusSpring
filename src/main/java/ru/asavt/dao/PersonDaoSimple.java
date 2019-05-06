package ru.asavt.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import ru.asavt.domain.Person;

@Repository
public class PersonDaoSimple implements PersonDao {

    public Person findByName(String name) {
        return new Person(name, 18);
    }
}
