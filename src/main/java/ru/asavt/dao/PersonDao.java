package ru.asavt.dao;

import ru.asavt.domain.Person;

public interface PersonDao {

    Person findByName(String name);
}
